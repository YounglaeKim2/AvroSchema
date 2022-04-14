package com.avroSchema.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;


public class Data {

    private Column_ column_;

    private ArrayList<Column_> columns = new ArrayList<Column_>();

    public ArrayList<Column_> getColumns() {return columns;}

    // Data 생성자
    Data(XSSFSheet sheet) {

        // 몇행인지 한번 보고
        System.out.println();
        System.out.println("총 "+sheet.getPhysicalNumberOfRows()+" 행 입니다.");
        System.out.println();
        for (int i = 9; i < sheet.getPhysicalNumberOfRows(); i++) {
            // add method(얕은복사, 주소값 참조) 를 사용하기 때문에 instance 를 새로 만들어 줘야해.
            column_ = new Column_();
            // 엑셀 행 값 가져오지 못하는 경우 continue 해버리기
            if (sheet.getRow(i) == null || sheet.getRow(i).getCell(0) == null || sheet.getRow(i).getCell(7).getStringCellValue().contains("-")) {continue;}

            // 세터를 이용해서 columnName 을 넣어주자
            column_.setColumnName(sheet.getRow(i).getCell(7).getStringCellValue());
            // nullable
            if (sheet.getRow(i).getCell(3).getStringCellValue().contains("NN")) {column_.setNullable(false);}
            else {column_.setNullable(true);}
            // type
            column_.setType(sheet.getRow(i).getCell(5).getStringCellValue());
            // length value
            column_.setLengthValue(sheet.getRow(i).getCell(6).toString());

            // columns 에 넣어준다
            columns.add(i-9,column_);
            System.out.println(i+1 +"행 : " + columns.get(i-9).getColumnName() + " | " + columns.get(i-9).getNullable() + " | " + columns.get(i-9).getType() + " | " +columns.get(i-9).getLengthValue());
        }
    }

    // 내부 클래스 COLUMN_
    public class Column_ {

        private String columnName;
        private boolean nullable;
        private String type;
        private String lengthValue;

        // 디폴트 생성자
//        Column_(){}

//        Column_(String columnName, boolean nullable, String type, String lengthValue) {
//            this.columnName = columnName;
//            this.nullable = nullable;
//            this.type = type;
//            this.lengthValue = lengthValue;
//        }

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