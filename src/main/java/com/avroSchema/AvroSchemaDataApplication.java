package com.avroSchema;

//import com.avroSchema.data.Data;
//import com.avroSchema.service.Process;
import com.avroSchema.data.Data;
import com.avroSchema.data.DataSpec;
import com.avroSchema.service.Process;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class AvroSchemaDataApplication {



	public static void main(String[] args) {
		String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";
//		Data dt = new Data();
//		dt.eachColData(dt.getSheet(5));
//		System.out.println("xxxxxxxxxxxx");
//		System.out.println(dt.eachColData(dt.sheet));

//		System.out.println();
//		for(int i = 0; i < 10; i++){
//			dt.columns.get(i).getColumnName();
//		}
//		System.out.println();
//		dt.columns.get(0).setColumnName("sdfdsf");
		DataSpec dts = new DataSpec();
		dts.sheet = dts.getSheet(5);
		Data dt = new Data(dts.sheet);
//		System.out.println(dt.eachColData(dts.sheet));
//		for(Data.Column_ d : dt.columns){
//			System.out.println(d.toString());
//			System.out.println("tt");
//		}

		dt.toAvro(dts.sheet);

		SpringApplication.run(AvroSchemaDataApplication.class, args);
	}
}