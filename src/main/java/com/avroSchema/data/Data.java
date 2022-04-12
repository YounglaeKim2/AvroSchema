package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Data {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

    public static class Column_{
        public String columnName;
        public boolean nullable;
        public String type;
        public String lengthValue;

        public Column_(String columnName, boolean nullable, String type, String lengthValue){
            this.columnName = columnName;
            this.nullable = nullable;
            this.type = type;
            this.lengthValue = lengthValue;
        }
    }

    // index 번째 sheet 가져오기
    public XSSFSheet getSheet(int index){

        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



        sheet = workbook.getSheetAt(index);
        return sheet;
    }

    public String thisIsColumnName(XSSFSheet sheet){
        return getSheet(5).getRow(10).getCell(0).getStringCellValue();
//        return sheet.getRow(9).getCell(0).getStringCellValue();
    }
    public boolean thisIsNullabe(XSSFSheet sheet){
//        if(sheet.getRow(9).getCell(3).getStringCellValue().contains("NN")){
//            return false;
//        }else{
//            return true;
//        }
        if(getSheet(5).getRow(11).getCell(3).getStringCellValue().contains("NN")){
            return false;
        }else{
            return true;
        }
    }
    public String thisIsType(XSSFSheet sheet){
        return getSheet(5).getRow(10).getCell(5).getStringCellValue();
    }
    public String thisIsLengthValue(XSSFSheet sheet){
        return getSheet(5).getRow(10).getCell(6).toString();
    }

    Column_ column_ = new Column_(thisIsColumnName(sheet), thisIsNullabe(sheet), thisIsType(sheet), thisIsLengthValue(sheet));

}
