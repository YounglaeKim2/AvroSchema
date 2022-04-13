package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class DataSpec {

    private Data data;

    private String tableName;
    private String tableNameEng;

    public DataSpec(XSSFSheet sheet){
        setTableName(sheet);
        setTableNameEng(sheet);
        data = new Data(sheet);
//        System.out.println();
//        System.out.println(tableNameEng);
//        System.out.println();

    }

    // getter setter
//    private void setTableName(XSSFSheet sheet){tableName = sheet.getRow(6).getCell(2).getStringCellValue();}
    private void setTableName(XSSFSheet sheet){tableName = sheet.getRow(6).getCell(2).getStringCellValue();}
    public String getTableName(){return tableName;}
    private void setTableNameEng(XSSFSheet sheet){tableNameEng = sheet.getRow(6).getCell(6).getStringCellValue();}
    public String getTableNameEng(){return tableNameEng;}

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
