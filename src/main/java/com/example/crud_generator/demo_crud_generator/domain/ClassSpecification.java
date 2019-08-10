package com.example.crud_generator.demo_crud_generator.domain;

import lombok.Value;

import java.util.List;


@Value
public class ClassSpecification {

    private String name;

    private List<FieldSpecification> fieldSpecifications;

}
