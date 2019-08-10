package com.example.crud_generator.demo_crud_generator.service.impl;

import com.example.crud_generator.demo_crud_generator.domain.ClassSpecification;
import com.example.crud_generator.demo_crud_generator.domain.FieldSpecification;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
 * <h1>YmlReader.</h1>
 * <p>
 * Class read yml file and download class specification.
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
class YmlReader {

    /**
     * Method read yml file and return class specification.
     *
     * @param ymlFile
     * @return Class specification
     * @throws FileNotFoundException
     */
    List<ClassSpecification> read(File ymlFile) throws FileNotFoundException {
        FileReader reader = new FileReader(ymlFile);
        Map<String, Map<String, String>> ymlTemplateClassSpecification = readYmlFile(reader);
        return changeYmlTemplateClassSpecificationsToClassSpecification(ymlTemplateClassSpecification);
    }

    private Map<String, Map<String, String>> readYmlFile(Reader reader) {
        return (Map<String, Map<String, String>>) new Yaml().load(reader);
    }

    private List<ClassSpecification> changeYmlTemplateClassSpecificationsToClassSpecification(
            Map<String, Map<String, String>> yamlClassSpecifications
    ) {
        return separateToClass(yamlClassSpecifications)
                .entrySet()
                .stream()
                .map(e -> new ClassSpecification(e.getKey(), e.getValue()))
                .collect(toList());
    }

    private Map<String, List<FieldSpecification>> separateToClass(
            Map<String, Map<String, String>> ymlClassSpecifications
    ) {
        return Optional
                .of(ymlClassSpecifications
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                this::getClassNameFromClassSpecification,
                                this::getFiledClassFromClassSpecification
                        )))
                .orElse(Map.of());
    }

    private String getClassNameFromClassSpecification(Map.Entry<String, Map<String, String>> classSpecification) {
        return classSpecification.getKey();
    }

    private List<FieldSpecification> getFiledClassFromClassSpecification(
            Map.Entry<String, Map<String, String>> classSpecification
    ) {
        return Optional
                .of(classSpecification
                        .getValue()
                        .entrySet()
                        .stream()
                        .map(field -> new FieldSpecification(field.getKey(), field.getValue()))
                        .collect(Collectors.toList()))
                .orElse(List.of());
    }

}
