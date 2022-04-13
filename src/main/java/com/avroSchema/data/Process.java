package com.avroSchema.data;

import com.avroSchema.SaveFile;
import org.json.simple.JSONObject;

public class Process {

    public static final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

    JSONObject jsonAvroSchema;

    SaveFile saveFile = new SaveFile();

    public Process(String path){
        Sheet pcs = new Sheet(filePath);
        for(int i = 4; i <pcs.workbook.getNumberOfSheets(); i++){
            DataSpec dts = new DataSpec(pcs.getSheetAt(i));
            Data dt = dts.getData();
            jsonAvroSchema = dt.toAvro(pcs.getSheetAt(i));
            saveFile.SaveFile(pcs.getSheetAt(i));

            System.out.println();
            System.out.println(dts.getTableNameEng());
            System.out.println(dt.toAvro(pcs.getSheetAt(i)));
            System.out.println();
        }

    }
}
