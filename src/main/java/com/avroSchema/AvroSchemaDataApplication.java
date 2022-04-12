package com.avroSchema;

//import com.avroSchema.data.Data;
//import com.avroSchema.service.Process;
import com.avroSchema.service.Process;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class AvroSchemaDataApplication {



	public static void main(String[] args) {
		String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";
		Process process = new Process();
		process.process(filePath);






//		XSSFWorkbook workbook;
//		XSSFSheet sheet;

//		try{
//			FileInputStream fileInputStream = new FileInputStream(filePath);
//			workbook = new XSSFWorkbook(fileInputStream);
//			sheet = workbook.getSheetAt(4);
//			System.out.println("샘플 샘플 샘플");
//			System.out.println(sheet.getRow(9).getCell(1).getStringCellValue());
//			System.out.println("샘플 샘플 샘플");
//		}catch (FileNotFoundException e){
//			e.printStackTrace();
//		}catch (IOException e){
//			e.printStackTrace();
//		}



		SpringApplication.run(AvroSchemaDataApplication.class, args);
	}
}