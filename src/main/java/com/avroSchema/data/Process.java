package com.avroSchema.data;

import com.avroSchema.SaveFile;

public class Process {

    private Sheet sheet;
    private SaveFile saveFile;

    public Process(){

        final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

        sheet = new Sheet(filePath);
        saveFile = new SaveFile();

        for(int i = 4; i<sheet.workbook.getNumberOfSheets();i++){
            System.out.println(i);
            saveFile.SaveFile(sheet.getSheetAt(i));
        }
    }
}
