package com.avroSchema;

import com.avroSchema.data.Data;
import com.avroSchema.data.DataSpec;
import com.avroSchema.data.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class SaveFile {

    private Data data;
    private DataSpec dataSpec;
    private Sheet pcs;

    public void SaveFile(XSSFSheet sheet){
        data = new Data(sheet);
        dataSpec = new DataSpec(sheet);

        File dir = new File("../");
        Path pathBefore = Paths.get("../");
        String[] filenames = dir.list();

        boolean isDirExist = Arrays.asList(filenames).contains("txtAvroSchemaFiles");

        if(!isDirExist){
            try{
                Files.createDirectory(pathBefore);
                System.out.println("성공!");
            }catch (FileAlreadyExistsException e){e.printStackTrace();
            }catch (NoSuchFileException e){e.printStackTrace();
            }catch (IOException e){e.printStackTrace();
            }
        }

        try{
            FileWriter file = new FileWriter("../txtAvroSchemaFiles/"+ dataSpec.getTableNameEng() +".txt");
            file.write(data.toAvro(sheet).toJSONString());
            file.flush();
            file.close();
        }catch (IOException e){e.printStackTrace();}
    }
}