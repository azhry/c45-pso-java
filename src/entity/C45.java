/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String, Map<Integer, Double>> attributeEntropy;
    private Map<String, Map<Integer, Integer>> totalAttributeSamples;
    
    public C45() {
        this.classDistribution = new HashMap<>();
        this.valueDistribution = new HashMap<>();
        this.attributeEntropy = new HashMap<>();
        this.totalAttributeSamples = new HashMap<>();
    }
    
    public void fit(List<Data> data) {
        this.dataList = data;
        this.classDistribution = this.countClassDistribution(data);
        this.countValueDistribution(data);
        this.calculateTotalEntropy();
        this.calculateAttributeEntropy();
        this.calculateAttributeGain();
    }
    
    public int predict(Data data) {
        return 0;
    }
    
    private void buildTree() {
        
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
            double divResult = value / TOTAL_SAMPLES;
            this.totalEntropy += (-1) * divResult * Math.log(divResult);
        });
    }
    
    private void calculateAttributeEntropy() {
        for (String attr : this.attributes) {
            this.attributeEntropy.put(attr, this.calculateEntropy(attr));
        }
    }
    
    private Map<Integer, Double> calculateEntropy(String attr) {
        Map<Integer, Double> entropy = new HashMap<>();
        Map<String, Map<Integer, Integer>> totalSamples = new HashMap<>();
        this.valueDistribution.forEach((key, value) -> {
            Map<Integer, Integer> dist = value.get(attr);
            Map<Integer, Integer> freq = totalSamples.get(attr);
            dist.forEach((k, v) -> {
                freq.merge(k, 1, (old, curr) -> old + v);
            });
            totalSamples.put(attr, freq);
        });
        
        Map<Integer, Integer> freq = totalSamples.get(attr);
        this.totalAttributeSamples.put(attr, freq);
        this.valueDistribution.forEach((key, value) -> {
            Map<Integer, Integer> dist = value.get(attr);
            dist.forEach((k, v) -> {
                double divResult = v / totalSamples.get(attr).get(k);
                double currEntropy = divResult * Math.log(divResult);
                entropy.merge(k, (-1) * currEntropy, (old, curr) -> 
                        old + currEntropy);
            });
        });
        return entropy;
    }

    private void calculateAttributeGain() {
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
            double divResult = totalSamples.get(attrVal) / TOTAL_SAMPLES;
            gain[0] += (divResult * entropy);
        });
        return gain[0];
    }
}
