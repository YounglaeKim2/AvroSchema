package com.avroSchema.service;

import com.avroSchema.data.Data;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Process {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

    public Process(String filePath){

        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public XSSFSheet getSheetAt(int index){
        sheet = workbook.getSheetAt(index);
        return sheet;
    }
}
