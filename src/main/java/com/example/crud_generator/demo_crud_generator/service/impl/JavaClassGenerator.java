package com.example.crud_generator.demo_crud_generator.service.impl;

import com.example.crud_generator.demo_crud_generator.domain.ClassSpecification;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class JavaClassGenerator {

    private Configuration configuration;

    JavaClassGenerator() throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
    }

    void generateJavaClass(Collection<ClassSpecification> classSpecifications, File yamlFileDirectory) throws Exception {
        Map<String, Object> freemarkerDataModel = new HashMap<>();

        for (ClassSpecification classSpecification : classSpecifications) {
            createDtoJavaClass(yamlFileDirectory, freemarkerDataModel, classSpecification);
            createRepositoryJavaClass(yamlFileDirectory, freemarkerDataModel, classSpecification);
            createServiceInterface(yamlFileDirectory, freemarkerDataModel, classSpecification);
            createServiceImplInterface(yamlFileDirectory, freemarkerDataModel, classSpecification);
            createControllerlInterface(yamlFileDirectory, freemarkerDataModel, classSpecification);
        }
    }

    private void createDtoJavaClass(
            File yamlFileDirectory,
            Map<String, Object> freemarkerDataModel,
            ClassSpecification classSpecification
    ) throws IOException, TemplateException {
        Template template = configuration.getTemplate("javadataclass.ftl");
        freemarkerDataModel.put("classSpecification", classSpecification);
        File javaSourceFile = new File(yamlFileDirectory, classSpecification.getName() + ".java");
        Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
        template.process(freemarkerDataModel, javaSourceFileWriter);
    }

    private void createRepositoryJavaClass(
            File yamlFileDirectory,
            Map<String, Object> freemarkerDataModel,
            ClassSpecification classSpecification
    ) throws Exception {
        Template template = configuration.getTemplate("javarepoclass.ftl");
        freemarkerDataModel.put("classSpecification", classSpecification);
        File javaSourceFile = new File(yamlFileDirectory, classSpecification.getName() + "Repository" + ".java");
        Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
        template.process(freemarkerDataModel, javaSourceFileWriter);
    }

    private void createServiceInterface(
            File yamlFileDirectory,
            Map<String, Object> freemarkerDataModel,
            ClassSpecification classSpecification
    ) throws Exception {
        Template template = configuration.getTemplate("javaserviceclass.ftl");
        freemarkerDataModel.put("classSpecification", classSpecification);
        File javaSourceFile = new File(yamlFileDirectory, classSpecification.getName() + "Service" + ".java");
        Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
        template.process(freemarkerDataModel, javaSourceFileWriter);
    }

    private void createServiceImplInterface(
            File yamlFileDirectory,
            Map<String, Object> freemarkerDataModel,
            ClassSpecification classSpecification
    ) throws Exception {
        Template template = configuration.getTemplate("javaserviceimplclass.ftl");
        freemarkerDataModel.put("classSpecification", classSpecification);
        File javaSourceFile = new File(yamlFileDirectory, classSpecification.getName() + "ServiceImpl" + ".java");
        Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
        template.process(freemarkerDataModel, javaSourceFileWriter);
    }

    private void createControllerlInterface(
            File yamlFileDirectory,
            Map<String, Object> freemarkerDataModel,
            ClassSpecification classSpecification
    ) throws Exception {
        Template template = configuration.getTemplate("javacontrollerclass.ftl");
        freemarkerDataModel.put("classSpecification", classSpecification);
        File javaSourceFile = new File(yamlFileDirectory, classSpecification.getName() + "Controller" + ".java");
        Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
        template.process(freemarkerDataModel, javaSourceFileWriter);
    }

}
