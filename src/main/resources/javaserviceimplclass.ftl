package com.example.crud_generator.demo_crud_generator.service.impl;

import com.example.crud_generator.demo_crud_generator.service.${classSpecification.name}Service;
import com.example.crud_generator.demo_crud_generator.domain.*;
import com.example.crud_generator.demo_crud_generator.repository.*;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;


/**
 * <h1>${classSpecification.name}ServiceImpl</h1>
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ${classSpecification.name}ServiceImpl implements ${classSpecification.name}Service {

    private final ${classSpecification.name}Repository repository;

    @Override
    public void delete(long ${classSpecification.name?lower_case}Id) {
        log.info("Delete ${classSpecification.name?lower_case}: {}", ${classSpecification.name?lower_case}Id);
        repository.delete(this.get${classSpecification.name?cap_first}(${classSpecification.name?lower_case}Id));
    }

    @Override
    public void update(${classSpecification.name} ${classSpecification.name?lower_case}Update) {
        log.info("Update ${classSpecification.name?lower_case}: {}", ${classSpecification.name?lower_case}Update);
        this.create(${classSpecification.name?lower_case}Update);
    }

    @Override
    public List<${classSpecification.name}> getList() {
        log.info("Get list ${classSpecification.name?lower_case}");
        return Optional
                        .ofNullable(repository.findAll())
                        .orElseThrow(() -> new RuntimeException("Not found list ${classSpecification.name?lower_case}"));
    }

    @Override
    public ${classSpecification.name} get${classSpecification.name?cap_first}(long ${classSpecification.name?lower_case}Id) {
        log.info("Get ${classSpecification.name?lower_case} for id: {}", ${classSpecification.name?lower_case}Id);
        return repository.findById(${classSpecification.name?lower_case}Id)
                        .orElseThrow(() -> new RuntimeException("Not found ${classSpecification.name} for id: " + ${classSpecification.name?lower_case}Id));
    }

    @Override
    public ${classSpecification.name} create(${classSpecification.name} ${classSpecification.name?lower_case}Create) {
        log.info("Save ${classSpecification.name?lower_case}: {}", ${classSpecification.name?lower_case}Create);
        return repository.save(${classSpecification.name?lower_case}Create);
    }

}