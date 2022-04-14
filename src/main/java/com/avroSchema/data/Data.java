package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Data {

    private Column_ column_= new Column_();

    private ArrayList<Column_> columns = new ArrayList<Column_>();
//    private String tableName;
//    private String tableNameEng;
//
//    private void setTableName(XSSFSheet sheet) {tableName = sheet.getRow(6).getCell(2).getStringCellValue();}
//    public String getTableName() {return tableName;}
//    private void setTableNameEng(XSSFSheet sheet) {tableNameEng = sheet.getRow(6).getCell(6).getStringCellValue();}
//    public String getTableNameEng() {return tableNameEng;}
//
//    public Column_ getColumn_() {return column_;}
//    private void setColumn_(Column_ column_) {this.column_ = column_;}
//
//    public ArrayList<Column_> getColumns() {return columns;}
//    private void setColumns(ArrayList<Column_> columns) {this.columns = columns;}

    // Data 생성자
    public Data(XSSFSheet sheet) {

//        column_ = new Column_(column_.getColumnName(), column_.getNullable(), column_.getType(), column_.getLengthValue());

//        setTableName(sheet);
//        System.out.println();
//        System.out.println("테이블명(한글) : " + getTableName());
//        setTableNameEng(sheet);
//        System.out.println("테이블명(영어) : " + getTableNameEng());

        // 몇행인지 한번 보고
        System.out.println();
        System.out.println("총 "+sheet.getPhysicalNumberOfRows()+" 행 입니다.");
        System.out.println();
        for (int i = 9; i < sheet.getPhysicalNumberOfRows(); i++) {

            // 엑셀 행 값 가져오지 못하는 경우 continue 해버리기
            if (sheet.getRow(i) == null || sheet.getRow(i).getCell(0) == null) {continue;}

            // 세터를 이용해서 columnName 을 넣어주자
            column_.setColumnName(sheet.getRow(i).getCell(0).getStringCellValue());
            // nullable
            if (sheet.getRow(i).getCell(3).getStringCellValue().contains("NN")) {column_.setNullable(false);}
            else {column_.setNullable(true);}
            // type
            column_.setType(sheet.getRow(i).getCell(5).getStringCellValue());
            // length value
            column_.setLengthValue(sheet.getRow(i).getCell(6).toString());

            // columns 에 넣어준다
            columns.add(column_);
            System.out.println(i+1 +"행 : " + column_.getColumnName() + " | " + column_.getNullable() + " | " + column_.getType() + " | " + column_.getLengthValue());
        }
//        toAvro(sheet);
    }

    // avroSchema 만들기
//    public JSONObject toAvro(XSSFSheet sheet) {
//        JSONObject avroSchema;
//        JSONArray jsonArrayInFields;
//        JSONObject jsonObjectForAvroSchema;
//        // temp for null
//        String[] tempString = {"string", "null"};
//        String[] tempInt = {"int", "null"};
//        String[] tempDouble = {"double", "null"};
//
//        // avroSchema
//        avroSchema = new JSONObject();
//        avroSchema.put("type", "record");
//        avroSchema.put("namespace", "com.meta.datalake");
//        avroSchema.put("name", tableNameEng);
//        // jsonArray in fields
//        jsonArrayInFields = new JSONArray();
//        jsonObjectForAvroSchema = new JSONObject();
//
//        for (Column_ c : columns) {
//            jsonObjectForAvroSchema.put("name", c.columnName);
//            // Not Null 이 아닐 경우
//            if (c.nullable) {
//                if (c.type.contains("VARCHAR2")) {
//                    jsonObjectForAvroSchema.put("type", tempString);
//                } else if (c.type.contains("VARCHAR")) {
//                    jsonObjectForAvroSchema.put("type", tempString);
//                } else if (c.type.contains("TIMESTAMP")) {
//                    jsonObjectForAvroSchema.put("type", tempString);
//                } else if (c.lengthValue.contains(",")) {
//                    jsonObjectForAvroSchema.put("type", tempDouble);
//                } else {
//                    jsonObjectForAvroSchema.put("type", tempInt);
//                }
//            } else {
//                if (c.type.contains("VARCHAR2")) {
//                    jsonObjectForAvroSchema.put("type", "string");
//                } else if (c.type.contains("VARCHAR")) {
//                    jsonObjectForAvroSchema.put("type", "string");
//                } else if (c.type.contains("TIMESTAMP")) {
//                    jsonObjectForAvroSchema.put("type", "string");
//                } else if (c.lengthValue.contains(",")) {
//                    jsonObjectForAvroSchema.put("type", "double");
//                } else {
//                    jsonObjectForAvroSchema.put("type", "int");
//                }
//            }
//            jsonArrayInFields.put(jsonObjectForAvroSchema);
//        }
//        avroSchema.put("fields", jsonArrayInFields);
//        System.out.println(avroSchema);
//        return avroSchema;
//    }



    // 내부 클래스 COLUMN_
    class Column_ {

        String columnName;
        boolean nullable;
        String type;
        String lengthValue;

        // 디폴트 생성자
        Column_(){}

        Column_(String columnName, boolean nullable, String type, String lengthValue) {
            this.columnName = columnName;
            this.nullable = nullable;
            this.type = type;
            this.lengthValue = lengthValue;
        }

        public String getColumnName() {return columnName;}
        private void setColumnName(String columnName) {this.columnName = columnName;}

        public boolean getNullable() {return nullable;}
        private void setNullable(boolean nullable) {this.nullable = nullable;}

        public String getType() {return type;}
        private void setType(String type) {this.type = type;}

        public String getLengthValue() {return lengthValue;}
        private void setLengthValue(String lengthValue) {this.lengthValue = lengthValue;}
    }
}