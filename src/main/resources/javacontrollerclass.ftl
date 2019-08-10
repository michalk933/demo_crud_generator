package com.example.crud_generator.demo_crud_generator.domain;

import com.example.crud_generator.demo_crud_generator.domain.*;
import com.example.crud_generator.demo_crud_generator.service.*;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.*;

/**
 * <h1>${classSpecification.name}Controller</h1>
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/${classSpecification.name?lower_case}")
public class ${classSpecification.name}Controller{

    private final ${classSpecification.name}Service service;

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @PutMapping("/update")
    ${classSpecification.name} update(@RequestBody ${classSpecification.name} update) {
        service.update(update);
    }

    @GetMapping("/list")
    List<${classSpecification.name}> get${classSpecification.name}s() {
         return service.getList();
    }

    @GetMapping("/{id}")
    ${classSpecification.name} get${classSpecification.name}(@PathVariable("id") long id) {
        return service.get${classSpecification.name?cap_first}(id);
    }

    @PostMapping("/create")
    ${classSpecification.name} create(@RequestBody ${classSpecification.name} create) {
        return service.create(create);
    }

}