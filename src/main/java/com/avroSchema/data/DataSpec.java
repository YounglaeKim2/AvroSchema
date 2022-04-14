package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.JSONArray;
import org.json.simple.JSONObject;

public class DataSpec {

    private Data data;

    private String tableNameKor;
    private String tableNameEng;

    public String getTableNameKor() {return tableNameKor;}
    private void setTableNameKor(String tableNameKor) {this.tableNameKor = tableNameKor;}
    public String getTableNameEng() {return tableNameEng;}
    private void setTableNameEng(String tableNameEng) {this.tableNameEng = tableNameEng;}

    // DataSpec 생성자
    DataSpec(XSSFSheet sheet){
        setTableNameKor(sheet.getRow(6).getCell(2).getStringCellValue());
        setTableNameEng(sheet.getRow(6).getCell(6).getStringCellValue());

        System.out.println();
        System.out.println("한글테이블명 : "+getTableNameKor());
        System.out.println("영어테이블명 : "+getTableNameEng());
        data = new Data(sheet);
    }

    // Avro Schema 만들기
    private JSONObject toAvro(XSSFSheet sheet){
        // avro schema
        JSONObject avroSchema = new JSONObject();
        // 3줄 고정
        avroSchema.put("namespace", "com.meta.datalake");
        avroSchema.put("name", getTableNameEng());
        avroSchema.put("type", "record");
        JSONArray jsonArrayInFields;
        JSONObject jsonObjectInJsonArray;
        // temp for null
        String[] tempString = {"string", "null"};
        String[] tempInt = {"int", "null"};
        String[] tempDouble = {"double", "null"};

        // jsonArray in fields
        jsonArrayInFields = new JSONArray();
        jsonObjectInJsonArray = new JSONObject();
        for(int i = 0; i < data.getColumns().size(); i++){
            jsonObjectInJsonArray.put("name", data.getColumns().get(i).columnName);
            if(data.getColumns().get(i).nullable){
                if(data.getColumns().get(i).lengthValue.contains(",")){jsonObjectInJsonArray.put("type", tempDouble);}
                if(data.getColumns().get(i).type.contains("NUMBER")){jsonObjectInJsonArray.put("type", tempInt);}
                else{jsonObjectInJsonArray.put("type", tempString);}
            } else {
                if(data.getColumns().get(i).lengthValue.contains(",")){jsonObjectInJsonArray.put("type", "double");}
                if(data.getColumns().get(i).type.contains("NUMBER")){jsonObjectInJsonArray.put("type", "int");}
                else{jsonObjectInJsonArray.put("type", "string");}
            }
            jsonArrayInFields.put(jsonObjectInJsonArray);
        }
        avroSchema.put("fields", jsonArrayInFields);
        System.out.println("Avro Schema 입니다");
        System.out.println(avroSchema);
        return avroSchema;
    }
}