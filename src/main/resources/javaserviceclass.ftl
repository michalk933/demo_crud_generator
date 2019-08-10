package com.example.crud_generator.demo_crud_generator.service;

import java.util.*;
import com.example.crud_generator.demo_crud_generator.domain.*;


/**
 * <h1>${classSpecification.name}Service</h1>
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
public interface ${classSpecification.name}Service {

    /**
     * Method delete ${classSpecification.name}
     *
     * @param ${classSpecification.name?lower_case}Id ${classSpecification.name?lower_case} Id
     */
    void delete(long ${classSpecification.name?lower_case}Id);

    /**
     * Method update ${classSpecification.name}
     *
     * @param ${classSpecification.name?lower_case}Update ${classSpecification.name?lower_case} Id
     */
    void update(${classSpecification.name} ${classSpecification.name?lower_case}Update);

    /**
     * Method return list ${classSpecification.name}
     *
     * @return List of ${classSpecification.name}
     */
    List<${classSpecification.name}> getList();

    /**
     * Method return ${classSpecification.name}
     *
     * @return ${classSpecification.name}
     */
    ${classSpecification.name} get${classSpecification.name?cap_first}(long ${classSpecification.name?lower_case}Id);

    /**
     * Method create ${classSpecification.name}
     *
     * @return ${classSpecification.name}
     */
    ${classSpecification.name} create(${classSpecification.name} ${classSpecification.name?lower_case}Create);

}