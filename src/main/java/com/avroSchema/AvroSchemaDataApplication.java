package com.avroSchema;

import com.avroSchema.data.Process;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AvroSchemaDataApplication {

	public static final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

	public static void main(String[] args) {
		try {
			Process process = new Process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}