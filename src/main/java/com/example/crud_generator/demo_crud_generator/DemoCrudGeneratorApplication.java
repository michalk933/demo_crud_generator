package com.example.crud_generator.demo_crud_generator;

import com.example.crud_generator.demo_crud_generator.service.GenerateCRUD;
import com.example.crud_generator.demo_crud_generator.service.impl.GenerateCRUDImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCrudGeneratorApplication {

	public static void main(String[] args) throws Exception {
		GenerateCRUD generate = new GenerateCRUDImpl();
		generate.createCRUD("/Users/michalkuchciak/IdeaProjects/demo_crud_generator/src/main/resources/ClassTemplate.yml");

		SpringApplication.run(DemoCrudGeneratorApplication.class, args);
	}

}
