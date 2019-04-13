/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import entity.Data;
import entity.Data;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Azhary Arliansyah
 */
public class ExcelHandler {
    
    private final String baseDir = System.getProperty("user.dir");
    
    public ExcelHandler() {
        
    }
    
    public void write(String path, Map<Integer, Object[]> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Experiment");
        
        Set<Integer> keyset = data.keySet();
        int rownum = 0;
        for (int key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                   cell.setCellValue((String)obj); 
                } else if (obj instanceof Integer) {
                   cell.setCellValue((Integer)obj); 
                } else if (obj instanceof Double) {
                   cell.setCellValue((Double)obj);
                }
            }
        }
        
        try {
            FileOutputStream out = new FileOutputStream(
                    new File(baseDir + path));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Data> read(String path, int sheetIndex)
            throws FileNotFoundException, IOException {
        File excelFile = new File(baseDir + path);
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        List<Data> result = new ArrayList<>();
        
        Iterator<Row> rowIt = sheet.iterator();
        if (rowIt.hasNext()) {
            rowIt.next();
        }
        if (rowIt.hasNext()) {
            rowIt.next();
        }
        
        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            result.add(new Data(row.getCell(1).getStringCellValue(), 
                    (int)row.getCell(2).getNumericCellValue(), 
                    (int)row.getCell(3).getNumericCellValue(), 
                    (int)row.getCell(4).getNumericCellValue(), 
                    (int)row.getCell(5).getNumericCellValue(), 
                    (int)row.getCell(6).getNumericCellValue(), 
                    (int)row.getCell(7).getNumericCellValue(), 
                    (int)row.getCell(8).getNumericCellValue(), 
                    (int)row.getCell(9).getNumericCellValue(), 
                    (int)row.getCell(10).getNumericCellValue(), 
                    (int)row.getCell(11).getNumericCellValue(), 
                    (int)row.getCell(12).getNumericCellValue()));
        }
        
        return result;
    }
    
    public List<Data> read(File file, int sheetIndex)
            throws FileNotFoundException, IOException {
        File excelFile = file;
        FileInputStream fis = new FileInputStream(excelFile);
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        List<Data> result = new ArrayList<>();
        
        Iterator<Row> rowIt = sheet.iterator();
        if (rowIt.hasNext()) {
            rowIt.next();
        }
        if (rowIt.hasNext()) {
            rowIt.next();
        }
        
        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            result.add(new Data(row.getCell(1).getStringCellValue(), 
                    (int)row.getCell(2).getNumericCellValue(), 
                    (int)row.getCell(3).getNumericCellValue(), 
                    (int)row.getCell(4).getNumericCellValue(), 
                    (int)row.getCell(5).getNumericCellValue(), 
                    (int)row.getCell(6).getNumericCellValue(), 
                    (int)row.getCell(7).getNumericCellValue(), 
                    (int)row.getCell(8).getNumericCellValue(), 
                    (int)row.getCell(9).getNumericCellValue(), 
                    (int)row.getCell(10).getNumericCellValue(), 
                    (int)row.getCell(11).getNumericCellValue(), 
                    (int)row.getCell(12).getNumericCellValue()));
        }
        
        return result;
    }
}
