/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c45.pso;

import Entity.ExcelHandler;
import entity.C45;
import entity.Data;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azhary Arliansyah
 */
public class C45PSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExcelHandler exl = new ExcelHandler();
        List<Data> data;
        try {
            data = exl.read("/data/data.xlsx", 1);
            C45 clf = new C45();
            clf.fit(data);
//            clf.showTree();
            System.out.println(clf.score(data));
        } catch (IOException ex) {
            Logger.getLogger(C45PSO.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    }
    
}
