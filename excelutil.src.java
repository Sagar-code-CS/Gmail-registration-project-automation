package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
    public static List<String[]> getTestData(String excelPath) {
        List<String[]> data = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); 

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String[] rowData = new String[5];
                for (int i = 0; i < 5; i++) {
                    rowData[i] = row.getCell(i).toString();
                }
                data.add(rowData);
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
