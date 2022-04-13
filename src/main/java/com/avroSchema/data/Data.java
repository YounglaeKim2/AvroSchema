package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Data {

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

    // temp for null

    public ArrayList<Column_> columns = new ArrayList<Column_>();

    public Data(XSSFSheet sheet){

        String columnName;
        boolean nullable;
        String type;
        String lengthValue;

        System.out.println("테이블 한글명 : " + sheet.getRow(6).getCell(2).getStringCellValue());
        System.out.println("테이블 영문명 : " + sheet.getRow(6).getCell(6).getStringCellValue());

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
        System.out.println(columns.get(0).columnName.toString());
        for(Column_ c : columns){
            System.out.println(c.columnName);
        }


    }
    public JSONObject toAvro(XSSFSheet sheet){
        JSONObject avroSchema;
        JSONArray jsonArrayInFields;
        JSONObject jsonObjectForAvroSchema;
        String tableName;
        String tableNameEng;
        // temp for null
        String[] tempString = {"string", "null"};
        String[] tempInt = {"int", "null"};
        String[] tempDouble = {"double", "null"};
        tableName = sheet.getRow(6).getCell(2).getStringCellValue();
        tableNameEng = sheet.getRow(6).getCell(6).getStringCellValue();

        // avroSchema
        avroSchema = new JSONObject();
        avroSchema.put("type","record");
        avroSchema.put("namespace","com.meta.datalake");
        avroSchema.put("name",tableNameEng);
        // jsonArray in fields
        jsonArrayInFields = new JSONArray();
        jsonObjectForAvroSchema = new JSONObject();

        for(Column_ c : columns){
            jsonObjectForAvroSchema.put("name",c.columnName);
            // Not Null 이 아닐 경우
            if(c.nullable){
                if(c.type.contains("VARCHAR2")){jsonObjectForAvroSchema.put("type",tempString);}
                else if(c.type.contains("VARCHAR")){jsonObjectForAvroSchema.put("type",tempString);}
                else if(c.type.contains("TIMESTAMP")){jsonObjectForAvroSchema.put("type",tempString);}
                else if(c.lengthValue.contains(",")){jsonObjectForAvroSchema.put("type",tempDouble);}
                else{jsonObjectForAvroSchema.put("type",tempInt);}
            }else{
                if(c.type.contains("VARCHAR2")){jsonObjectForAvroSchema.put("type","string");}
                else if(c.type.contains("VARCHAR")){jsonObjectForAvroSchema.put("type","string");}
                else if(c.type.contains("TIMESTAMP")){jsonObjectForAvroSchema.put("type","string");}
                else if(c.lengthValue.contains(",")){jsonObjectForAvroSchema.put("type","double");}
                else{jsonObjectForAvroSchema.put("type","int");}
            }
            jsonArrayInFields.put(jsonObjectForAvroSchema);
        }
        avroSchema.put("fields",jsonArrayInFields);
        return avroSchema;
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