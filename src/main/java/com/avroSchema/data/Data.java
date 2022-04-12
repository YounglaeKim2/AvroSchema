package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Data {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

    public ArrayList<Column_> columns = new ArrayList<Column_>();

    public void eachColData(XSSFSheet sheet){

        String columnName;
        boolean nullable;
        String type;
        String lengthValue;

        for(int i = 9; i < sheet.getPhysicalNumberOfRows(); i++){

            columnName = sheet.getRow(i).getCell(0).getStringCellValue();
            if(sheet.getRow(i).getCell(3).getStringCellValue().contains("NN")){nullable = false;}
            else{nullable = true;}
            type = sheet.getRow(i).getCell(5).getStringCellValue();
            lengthValue = sheet.getRow(i).getCell(6).toString();

            Column_ column_ = new Column_(columnName, nullable, type, lengthValue);
            System.out.println(column_.getModel());
            System.out.println();
            columns.add(column_);
        }
        for(Column_ c : columns){
            System.out.println(c.columnName);
        }
    }

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

    public class Column_{

        private String columnName;
        private boolean nullable;
        private String type;
        private String lengthValue;

        public Column_(String columnName, boolean nullable, String type, String lengthValue){
            this.columnName = columnName;
            this.nullable = nullable;
            this.type = type;
            this.lengthValue = lengthValue;
        }

        public String getColumnName(){
            return columnName;
        }
        public void setColumnName(String columnName){
            this.columnName = columnName;
        }

        public boolean getNullable() {
            return nullable;
        }
        public void setNullable(boolean nullable) {
            this.nullable = nullable;
        }

        public String getType(){
            return type;
        }
        public void setType(String type){
            this.type = type;
        }

        public String getLengthValue(){
            return getLengthValue();
        }
        public void setLengthValue(String lengthValue){
            this.lengthValue = lengthValue;
        }

        public String getModel(){
            return "칼럼명 : " + this.columnName + " | Null 여부 : " + this.nullable + " | 타입 : " + this.type + " | 길이 : " + this.lengthValue;
        }
    }
}