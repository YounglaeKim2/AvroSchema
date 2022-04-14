package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.JSONArray;
import org.json.simple.JSONObject;

public class DataSpec {



    private Data data;

    private String tableNameKor;
    private String tableNameEng;

    public DataSpec(XSSFSheet sheet){
        setTableNameKor(sheet.getRow(6).getCell(2).getStringCellValue());
        setTableNameEng(sheet.getRow(6).getCell(6).getStringCellValue());
        System.out.println();
        System.out.println("한글테이블명 : "+getTableNameKor());
        System.out.println("영어테이블명 : "+getTableNameEng());
        data = new Data(sheet);
    }

    public String getTableNameKor() {return tableNameKor;}
    private void setTableNameKor(String tableNameKor) {this.tableNameKor = tableNameKor;}
    public String getTableNameEng() {return tableNameEng;}
    private void setTableNameEng(String tableNameEng) {this.tableNameEng = tableNameEng;}

    //    public JSONObject toAvro(XSSFSheet sheet){
//        JSONObject avroSchema;
//        JSONArray jsonArrayInFields;
//        JSONObject jsonObjectForAvroSchema;
//        // temp for null
//        String[] tempString = {"string", "null"};
//        String[] tempInt = {"int", "null"};
//        String[] tempDouble = {"double", "null"};
//        // avroSchema
//        avroSchema = new JSONObject();
//        avroSchema.put("type", "record");
//        avroSchema.put("namespace", "com.meta.datalake");
////        avroSchema.put("name", tableNameEng);
//        avroSchema.put("name", tableNameEng);
//
//        // jsonArray in fields
//        jsonArrayInFields = new JSONArray();
//        jsonObjectForAvroSchema = new JSONObject();
//
////        for (Data.Column_ c : data.columns){
////            jsonObjectForAvroSchema.put("name", c.getColumnName());
////        }
//
//        for(int i = 0; i <data.columns.size(); i++){
//            jsonObjectForAvroSchema.put("name", )
//        }
//
//    }
}
