//package com.avroSchema.data;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.json.JSONArray;
//import org.json.simple.JSONObject;
//
//public class DataSpec {
//
//    private Data data;
//
//    private String tableName;
//    private String tableNameEng;
//
//    public DataSpec(XSSFSheet sheet){
////        setTableName(sheet);
////        setTableNameEng(sheet);
//        data = new Data(sheet);
//        getData();
//        tableName = data.getTableName();
//        tableNameEng = data.getTableNameEng();
//        data.getColumn_();
//    }
////    private void setTableName(XSSFSheet sheet){tableName = sheet.getRow(6).getCell(2).getStringCellValue();}
////    private void setTableNameEng(XSSFSheet sheet){tableNameEng = sheet.getRow(6).getCell(6).getStringCellValue();}
////    public String getTableNameEng(){return tableNameEng;}
//
//    public Data getData() {
//        return data;
//    }
//
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
//}
