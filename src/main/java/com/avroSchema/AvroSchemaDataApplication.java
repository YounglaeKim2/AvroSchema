package com.avroSchema;

import com.avroSchema.data.Process;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvroSchemaDataApplication {

	public static final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

	public static void main(String[] args) {
		Process process = new Process(filePath);

	}
}