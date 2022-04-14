package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Sheet {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;

    // Sheet 생성자
    public Sheet(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
    }

    // Sheet
    public XSSFSheet getSheetAt(int index){
        sheet = workbook.getSheetAt(index);
        return sheet;
    }
}
