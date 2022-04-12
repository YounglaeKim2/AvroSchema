package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";


//    public String columnName;
//    public boolean nullable;
//    public String type;
//    public String lengthValue;


    public class Column_{
        private String columnName;
        private boolean nullable;
        public String type;
        public String lengthValue;

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

        public boolean isNullable() {
            return nullable;
        }

        public void setNullable(boolean nullable) {
            this.nullable = nullable;
        }

        public String getModel(){
            return "칼럼명 : " + this.columnName + " | Null 여부 : " + this.nullable + " | 타입 : " + this.type + " | 길이 : " + this.lengthValue;
        }
    }

    public ArrayList<Column_> columns = new ArrayList<Column_>();

//    public class ColumnData{

//    public String columnNameIs(int index, int row){
//        return getSheet(index).getRow(row).getCell(0).getStringCellValue();
//    }
//
//    public boolean nullableIs(int index, int row){
//        if(getSheet(index).getRow(row).getCell(3).getStringCellValue().contains("NN")){return false;}
//        else{return true;}
//    }
//
//    public String typeIs(int index, int row){
//        return getSheet(index).getRow(row).getCell(5).getStringCellValue();
//    }
//
//    public String lengthValueIs(int index, int row){
//        return getSheet(index).getRow(row).getCell(6).toString();
//    }
//    }

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
}