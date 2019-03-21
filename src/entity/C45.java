/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Node.Type;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Azhary Arliansyah
 */
public class C45 {
    
    private final String[] attributes = new String[] {
        "pendidikan", "pekerjaan", "penghasilan", "ptr", "ventilasi", 
        "pencahayaan", "kelembaban", "lantai", "dinding", "atap"
    };
    
    private Map<Integer, Integer> classDistribution;
    private Map<Integer, Map<String, Map<Integer, Integer>>> valueDistribution;
    private List<Data> dataList;
    private double totalEntropy;
    private Map<String, Double> attributeGain;
    private Map<String, Set<Integer>> attributeValue;
    private Map<String, Map<Integer, Double>> attributeEntropy;
    private Map<String, Map<Integer, Integer>> totalAttributeSamples;
    private Node tree;
    
    public C45() {
        this.classDistribution = new HashMap<>();
        this.valueDistribution = new HashMap<>();
        this.attributeEntropy = new HashMap<>();
        this.totalAttributeSamples = new HashMap<>();
        this.attributeGain = new HashMap<>();
    }
    
    public void fit(List<Data> data) {
        this.dataList = data;
        this.classDistribution = this.countClassDistribution(data);
        this.calculateTotalEntropy();
    }
    
    public int predict(Data data) {
        return 0;
    }
    
    private void buildTree(List<Data> data) {
        Type t = null;
        if (this.tree == null) {
            t = Type.ROOT;
            this.tree = new Node("", t);
        }
        
        // TODO: check if all records have same class (create new method)
        
        this.countValueDistribution(data);
        this.calculateAttributeEntropy();
        this.calculateAttributeGain();
        List<Map.Entry<String, Double>> sortedAttr = 
                MathFx.sortMapDouble(this.attributeGain, "DESC");
        Map.Entry<String, Double> entry = sortedAttr.get(0);
        
        if (t == Type.ROOT) {
            this.tree.setAttribute(entry.getKey());
        }
        
        if (t == Type.BRANCH) {
            
        } else {
           
        }
    }
    
    private void setAttributeValues(List<Data> data, String attr) {
        this.attributeValue = new HashMap<>();
        data.stream().forEach(row -> {
            Set<Integer> set;
            if (this.attributeValue.containsKey(attr)) {
                
            } else {
                set = new HashSet<Integer>();
            }
        });
    }
    
    private Map<Integer, List<Data>> binning() {
        return new HashMap<>();
    }
    
    private Map<Integer, List<Data>> getBin(List<Data> data, String attr, 
            int binValue) {
        Map<Integer, List<Data>> dist = new HashMap<>();
        String attrName = StringUtils.capitalize(attr);
        try {
            Method method = Data.class.getMethod("get" + attrName, null);
            data.stream().forEach(row -> {
                try {
                    int label = row.getIspa();
                    Object value = method.invoke(row, null);
                    if ((int)value == binValue) {
                        List<Data> records;
                        if (dist.containsKey(label)) {
                            records = dist.get(label);
                        } else {
                            records = new ArrayList<>();
                        }
                        records.add(row);
                        dist.put(label, records);
                    }
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(C45.class.getName()).log(Level.SEVERE, 
                            null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(C45.class.getName()).log(Level.SEVERE, 
                            null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(C45.class.getName()).log(Level.SEVERE, 
                            null, ex);
                }
            });
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(C45.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(C45.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dist;
    }
    
    private Map<Integer, Integer> countClassDistribution(
            List<Data> data) {
        Map<Integer, Integer> map = new HashMap<>();
        data.stream().forEach(row -> {
            int cls = row.getIspa();
            if (map.containsKey(cls)) {
                int c = map.get(cls);
                map.put(cls, ++c);
            } else {
                map.put(cls, 1);
            }
        });
        return map;
    }
    
    private void countValueDistribution(List<Data> data) {
        this.valueDistribution = new HashMap<>();
        this.valueDistribution.put(1, new HashMap<>());
        this.valueDistribution.put(2, new HashMap<>());
        
        final int ROW_LENGTH = 12;
        for (int i = 0; i < data.size(); i++) {
            Data row = data.get(i);
            int label = row.getIspa();
            this.incrementDistribution(label, "pendidikan", 
                    row.getPendidikan());
            this.incrementDistribution(label, "pekerjaan", row.getPekerjaan());
            this.incrementDistribution(label, "penghasilan", 
                    row.getPenghasilan());
            this.incrementDistribution(label, "ptr", row.getPtr());
            this.incrementDistribution(label, "ventilasi", row.getVentilasi());
            this.incrementDistribution(label, "pencahayaan", 
                    row.getPencahayaan());
            this.incrementDistribution(label, "kelembaban", 
                    row.getKelembaban());
            this.incrementDistribution(label, "lantai", row.getLantai());
            this.incrementDistribution(label, "dinding", row.getDinding());
            this.incrementDistribution(label, "atap", row.getAtap());
        }
    }
    
    private void incrementDistribution(int label, String attr, int value) {
        Map<String, Map<Integer, Integer>> map = 
                this.valueDistribution.get(label);
        int intVal = value;
        Map <Integer, Integer> dist = new HashMap<>();
        if (map.containsKey(attr)) {
            dist = map.get(attr);
            if (dist.containsKey(intVal)) {
                dist.computeIfPresent(intVal, (k, v) -> v + 1);
            } else {
                dist.put(intVal, 1);
            }
        } else {
            dist.put(intVal, 1);
        }
        map.put(attr, dist);
        this.valueDistribution.put(label, map);
    }
    
    private void calculateTotalEntropy() {
        final int TOTAL_SAMPLES = this.dataList.size();
        this.totalEntropy = 0;
        this.classDistribution.forEach((key, value) -> {
            double divResult = (double)value / (double)TOTAL_SAMPLES;
            this.totalEntropy += (-1) * divResult * Math.log(divResult);
        });
    }
    
    private void calculateAttributeEntropy() {
        this.attributeEntropy = new HashMap<>();
        for (String attr : this.attributes) {
            this.attributeEntropy.put(attr, this.calculateEntropy(attr));
        }
    }
    
    private Map<Integer, Double> calculateEntropy(String attr) {
        Map<Integer, Double> entropy = new HashMap<>();
        Map<String, Map<Integer, Integer>> totalSamples = new HashMap<String, 
                Map<Integer, Integer>>();
        Map<Integer, Integer> freq = totalSamples.get(attr);
        if (freq == null) {
            freq = new HashMap<>();
        }
        
        for (Map.Entry<Integer, Map<String, Map<Integer, Integer>>> e : 
                this.valueDistribution.entrySet()) {
            Map<Integer, Integer> dist = e.getValue().get(attr);
            for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
                int k = entry.getKey();
                Integer v = freq.get(k);
                if (v == null) {
                    freq.put(k, entry.getValue());
                } else {
                    freq.put(k, v + entry.getValue());
                }
            }
            totalSamples.put(attr, freq);
        } 
        
        this.totalAttributeSamples.put(attr, freq);
        this.valueDistribution.forEach((key, value) -> {
            Map<Integer, Integer> dist = value.get(attr);
            dist.forEach((k, v) -> {
                double divResult = (double)v / 
                        (double)totalSamples.get(attr).get(k);
                double currEntropy = divResult * Math.log(divResult);
                Double val = entropy.get(k);
                if (val == null) {
                    entropy.put(k, (-1) * currEntropy);
                } else {
                    entropy.put(k, val + currEntropy);
                }
            });
        });
        return entropy;
    }

    private void calculateAttributeGain() {
        this.attributeGain = new HashMap<>();
        for (String attr : this.attributes) {
            this.attributeGain.put(attr, this.calculateGain(attr));
        }
    }
    
    private double calculateGain(String attr) {
        Double[] gain = new Double[]{this.totalEntropy};
        Map<Integer, Double> attributeEntropy = this.attributeEntropy
                                                .get(attr);
        Map<Integer, Integer> totalSamples = this.totalAttributeSamples
                                                .get(attr);
        
        final int TOTAL_SAMPLES = this.dataList.size();
        attributeEntropy.forEach((attrVal, entropy) -> {
            double divResult = (double)totalSamples.get(attrVal) / 
                    (double)TOTAL_SAMPLES;
            gain[0] += (divResult * entropy);
        });
        return gain[0];
    }
}
