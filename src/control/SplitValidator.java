/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Azhary Arliansyah
 */
public class SplitValidator {
   
    private List<Data> data = new ArrayList<>();
    private Map<Integer, Integer> classDistribution = new HashMap<>();
    
    public SplitValidator(ArrayList<Data> data) {
        this.data = (ArrayList)data.clone();
        this.classDistribution = this.countClassDistribution(this.data);
    }
    
    public Map<String, List<Data>> stratifiedSplit(double ratio) {
        int dataSize = this.data.size();
        int trainSize = (int)(dataSize * ratio);
        
        Map<Integer, Double> distPercentage = new HashMap<>();
        this.classDistribution.forEach((k, v) -> {
            distPercentage.put(k, (double)v / (double)dataSize);
        });
        
        Map<String, List<Data>> split = new HashMap<>();

        List<Data> trainData = new ArrayList<>();
        List<Data> testData = new ArrayList<>();
        Map<Integer, Integer> currentDist = new HashMap<>();
        List<Data> splitData = this.data;
        System.out.println(this.classDistribution);
        while(true) {
            boolean splitTrain = false;
            for (int i = 0; i < splitData.size(); i++) {
                
//                System.out.println(trainData.size() + "::" + trainSize);
                if (trainData.size() >= trainSize) {
                    break;
                }
                Data row = splitData.get(i);
                int cls = (Integer)Reflector.callUserFunc(Data.class, 
                        row, "get" + StringUtils.capitalize(Data.LABEL));
//                System.out.println(currentDist.get(cls) + "::" + 
//                        distPercentage.get(cls) * 
//                                this.classDistribution.get(cls));
                if (currentDist.containsKey(cls) && currentDist.get(cls) >= 
                        distPercentage.get(cls) * 
                        this.classDistribution.get(cls)) {
                    continue;
                }
                trainData.add(row);
                splitData.remove(i);
                currentDist = this.incrementDistribution(currentDist, cls);
                splitTrain = true;
            }
            if (trainData.size() >= trainSize || !splitTrain) {
                break;
            }
        }
        
        testData = splitData;
        split.put("train", trainData);
        split.put("test", testData);
        
        return split;
    }
    
    private Map<Integer, Integer> incrementDistribution(
            Map<Integer, Integer> dist, int key) {
        if (dist.containsKey(key)) {
            int currentKeyDist = dist.get(key) + 1;
            dist.put(key, currentKeyDist);
        } else {
            dist.put(key, 1);
        }
        return dist;
    }
    
    private Map<Integer, Integer> countClassDistribution(List<Data> data) {
        Map<Integer, Integer> classDistribution = new HashMap<>();
        this.data.stream().forEach(row -> {
            int cls = (Integer)Reflector.callUserFunc(Data.class, row, 
                    "get" + StringUtils.capitalize(Data.LABEL));
            if (classDistribution.containsKey(cls)) {
                int c = classDistribution.get(cls);
                classDistribution.put(cls, ++c);
            } else {
                classDistribution.put(cls, 1);
            }
        });
        
        return classDistribution;
    }
}
