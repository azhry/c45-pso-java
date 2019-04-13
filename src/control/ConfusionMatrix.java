/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Azhary Arliansyah
 */
public class ConfusionMatrix {
    
    private Map<String, Map<String, Integer>> matrix;
    
    public ConfusionMatrix() {
        this.reset();
    }
    
    public void update(String actual, String predicted) {
        this.matrix.get(actual).computeIfPresent(predicted, (k, v) -> v + 1);
    }
    
    public void reset() {
        this.matrix = new HashMap<>();
        
        Map<String, Integer> row = new HashMap<>();
        row.put("1", 0);
        row.put("2", 0);
        
        Map<String, Integer> row2 = new HashMap<>();
        row2.put("1", 0);
        row2.put("2", 0);
        
        this.matrix.put("1", row);
        this.matrix.put("2", row2);
    }
    
    public Map<String, Map<String, Integer>> getMatrix() {
        return this.matrix;
    }
    
    public double getAccuracy() {
       int tp = this.matrix.get("1").get("1") + 
               this.matrix.get("2").get("2");
       int f = MathFx.sumMap(this.matrix.get("1")) + 
               MathFx.sumMap(this.matrix.get("2"));
       return (double)tp / (double)f;
    }
}