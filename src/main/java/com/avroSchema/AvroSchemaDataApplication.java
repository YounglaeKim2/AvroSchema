package com.avroSchema;

import com.avroSchema.data.Data;
import com.avroSchema.data.DataSpec;
import com.avroSchema.service.Process;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvroSchemaDataApplication {

	public static final String filePath = "C:/Users/220209/Desktop/서산_테이블정의서_20220315.xlsx";

	public static void main(String[] args) {
		Process pcs = new Process(filePath);
		DataSpec dts = new DataSpec(pcs.sheet);
		pcs.sheet = pcs.getSheetAt(5);
		Data dt = new Data(pcs.sheet);

//		SpringApplication.run(AvroSchemaDataApplication.class, args);
	}
}