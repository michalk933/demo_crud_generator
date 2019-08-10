package com.example.crud_generator.demo_crud_generator.repository;


import com.example.crud_generator.demo_crud_generator.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * <h1>${classSpecification.name}Repository</h1>
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
@Repository
public interface ${classSpecification.name}Repository extends JpaRepository<${classSpecification.name}, Long> {}