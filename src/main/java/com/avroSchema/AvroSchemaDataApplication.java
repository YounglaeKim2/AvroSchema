package com.avroSchema;

import com.avroSchema.data.Sheet;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AvroSchemaDataApplication {

    public static final String filePath = "C:/Users/220209/Desktop/0.서산_테이블정의서_20220413.xlsx";

    public static void main(String[] args) {

        try {
            Sheet sheet = new Sheet(filePath);
            FileManager fileManager = new FileManager();

//            for (int i = 4; i < sheet.workbook.getNumberOfSheets(); i++) {
                fileManager.SaveFile(sheet.getSheetAt(11));
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}