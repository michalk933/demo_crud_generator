package com.example.crud_generator.demo_crud_generator.service.impl;

import com.example.crud_generator.demo_crud_generator.domain.ClassSpecification;
import com.example.crud_generator.demo_crud_generator.exception.PathToYmlIsEmptyException;
import com.example.crud_generator.demo_crud_generator.service.GenerateCRUD;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GenerateCRUDImpl implements GenerateCRUD {

    @Override
    public void createCRUD(final String ymlPath) throws Exception {
        if (ymlPath == null || ymlPath.isEmpty()) {
            new PathToYmlIsEmptyException(String.format("Given path is null or empty: %s", ymlPath));
        }
        log.info("Start generate CRUD, from: {}", ymlPath);

        final File ymlFile = new File(ymlPath);
        final File files = ymlFile.getParentFile();

        YmlReader reader = new YmlReader();
        List<ClassSpecification> readClassSpecifications = reader.read(ymlFile);

        JavaClassGenerator javaClassGenerator = new JavaClassGenerator();
        javaClassGenerator.generateJavaClass(readClassSpecifications, files);

        log.info("Successfully generated CRUD: {}", files.getAbsolutePath());
    }

}
