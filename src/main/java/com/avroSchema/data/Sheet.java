package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sheet {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;

    // Sheet 생성자
    public Sheet(String filePath){
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        }catch (FileNotFoundException e){e.printStackTrace();
        }catch (IOException e){e.printStackTrace();}
    }

    // Sheet
    public XSSFSheet getSheetAt(int index){
        sheet = workbook.getSheetAt(index);
        return sheet;
    }
}
