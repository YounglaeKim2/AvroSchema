package com.avroSchema;

import com.avroSchema.data.DataSpec;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class SaveFile {

    File dir;
    String[] filenames;
    boolean isDirExist;
    Path pathBefore;

    // 파일 저장하기
    public void SaveFile(XSSFSheet sheet) throws IOException{
        DataSpec dataSpec = new DataSpec(sheet);

        dir = new File("../");
        filenames = dir.list();
        isDirExist = Arrays.asList(filenames).contains("txtAvroSchemaFiles");
        pathBefore = Paths.get("../txtAvroSchemaFiles/");

        // 해당 경로의 폴더가 존재하지 않으면 폴더 만들어서 저장하기기
        if(!isDirExist){Files.createDirectory(pathBefore);}
        FileWriter file = new FileWriter("../txtAvroSchemaFiles/"+ dataSpec.getTableNameEng() +".txt");
        file.write(dataSpec.toAvro(sheet).toJSONString());
        file.flush();
        file.close();
    }
}
