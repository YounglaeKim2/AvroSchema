package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Data {

    public ArrayList<Column_> columns = new ArrayList<Column_>();
    private String tableName;
    private String tableNameEng;

    private void setTableName(XSSFSheet sheet) {tableName = sheet.getRow(6).getCell(2).getStringCellValue();}
    public String getTableName() {return tableName;}
    private void setTableNameEng(XSSFSheet sheet) {tableNameEng = sheet.getRow(6).getCell(6).getStringCellValue();}
    public String getTableNameEng() {return tableNameEng;}

    // Data 생성자
    public Data(XSSFSheet sheet) {

        setTableName(sheet);
        System.out.println();
        System.out.println("테이블명(한글) : " + getTableName());
        setTableNameEng(sheet);
        System.out.println("테이블명(영어) : " + getTableNameEng());

        String columnName;
        boolean nullable;
        String type;
        String lengthValue;
        for (int i = 9; i < sheet.getPhysicalNumberOfRows(); i++) {

            System.out.println(sheet.getPhysicalNumberOfRows());

            // 엑셀 행 값 잘못 가져오는 경우 continue 해버리기
            if (sheet.getRow(i) == null || sheet.getRow(i).getCell(0) == null) {continue;}

            columnName = sheet.getRow(i).getCell(0).getStringCellValue();
            if (sheet.getRow(i).getCell(3).getStringCellValue().contains("NN")) {
                nullable = false;
            } else {
                nullable = true;
            }
            type = sheet.getRow(i).getCell(5).getStringCellValue();
            lengthValue = sheet.getRow(i).getCell(6).toString();

            Column_ column_ = new Column_(columnName, nullable, type, lengthValue);

            columns.add(column_);
            System.out.println(column_.columnName + " | " + column_.nullable + " | " + column_.type + " | " + column_.lengthValue);

        }
        toAvro(sheet);
    }

    // avroSchema 만들기
    public JSONObject toAvro(XSSFSheet sheet) {
        JSONObject avroSchema;
        JSONArray jsonArrayInFields;
        JSONObject jsonObjectForAvroSchema;
        // temp for null
        String[] tempString = {"string", "null"};
        String[] tempInt = {"int", "null"};
        String[] tempDouble = {"double", "null"};

        // avroSchema
        avroSchema = new JSONObject();
        avroSchema.put("type", "record");
        avroSchema.put("namespace", "com.meta.datalake");
        avroSchema.put("name", tableNameEng);
        // jsonArray in fields
        jsonArrayInFields = new JSONArray();
        jsonObjectForAvroSchema = new JSONObject();

        for (Column_ c : columns) {
            jsonObjectForAvroSchema.put("name", c.columnName);
            // Not Null 이 아닐 경우
            if (c.nullable) {
                if (c.type.contains("VARCHAR2")) {
                    jsonObjectForAvroSchema.put("type", tempString);
                } else if (c.type.contains("VARCHAR")) {
                    jsonObjectForAvroSchema.put("type", tempString);
                } else if (c.type.contains("TIMESTAMP")) {
                    jsonObjectForAvroSchema.put("type", tempString);
                } else if (c.lengthValue.contains(",")) {
                    jsonObjectForAvroSchema.put("type", tempDouble);
                } else {
                    jsonObjectForAvroSchema.put("type", tempInt);
                }
            } else {
                if (c.type.contains("VARCHAR2")) {
                    jsonObjectForAvroSchema.put("type", "string");
                } else if (c.type.contains("VARCHAR")) {
                    jsonObjectForAvroSchema.put("type", "string");
                } else if (c.type.contains("TIMESTAMP")) {
                    jsonObjectForAvroSchema.put("type", "string");
                } else if (c.lengthValue.contains(",")) {
                    jsonObjectForAvroSchema.put("type", "double");
                } else {
                    jsonObjectForAvroSchema.put("type", "int");
                }
            }
            jsonArrayInFields.put(jsonObjectForAvroSchema);
        }
        avroSchema.put("fields", jsonArrayInFields);
        System.out.println(avroSchema);
        return avroSchema;
    }

    // 내부 클래스 COLUMN_
    public class Column_ {

        private String columnName;
        private boolean nullable;
        private String type;
        private String lengthValue;

        public Column_(String columnName, boolean nullable, String type, String lengthValue) {
            this.columnName = columnName;
            this.nullable = nullable;
            this.type = type;
            this.lengthValue = lengthValue;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public boolean getNullable() {
            return nullable;
        }

        public void setNullable(boolean nullable) {
            this.nullable = nullable;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLengthValue() {
            return getLengthValue();
        }

        public void setLengthValue(String lengthValue) {
            this.lengthValue = lengthValue;
        }
    }
}