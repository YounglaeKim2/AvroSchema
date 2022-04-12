package com.avroSchema.service;

import com.avroSchema.data.Data;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Process {

    public void process(String filePath){
        Data dt = new Data();
        Data.Column_ dataCol = new Data.Column_(dt.thisIsColumnName(dt.sheet), dt.thisIsNullabe(dt.sheet), dt.thisIsType(dt.sheet), dt.thisIsLengthValue(dt.sheet));
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            dt.workbook = new XSSFWorkbook(fileInputStream);
//            System.out.println(dt.thisIsColumnName(dt.getSheet(4)));
            System.out.println(dataCol.columnName);
            System.out.println(dataCol.nullable);
            System.out.println(dataCol.lengthValue);
            System.out.println(dataCol.type);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
