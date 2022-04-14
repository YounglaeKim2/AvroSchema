package com.avroSchema;

//import com.avroSchema.data.Process;
import com.avroSchema.data.Data;
import com.avroSchema.data.Sheet;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AvroSchemaDataApplication {

	public static final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

	public static void main(String[] args) throws IOException {
		Sheet sheet = new Sheet(filePath);
		Data data = new Data(sheet.getSheetAt(5));
//		try {
//			Process process = new Process();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
}