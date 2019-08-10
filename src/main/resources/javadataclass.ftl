package com.example.crud_generator.demo_crud_generator.domain;

import lombok.*;
import javax.persistence.*;


/**
 * <h1>${classSpecification.name}</h1>
 *
 * @author michalkuchciak
 * @since 2019-08-10
 */
@Data
@Entity
@Table(name = "${classSpecification.name?lower_case}")
public class ${classSpecification.name}{

<#list classSpecification.fieldSpecifications as field>
    <#if field.name == "id">
        @Id
        @GeneratedValue
        private ${field.type} ${field.name};
    <#elseif field.type?contains("List")>
        @ManyToMany(cascade = {CascadeType.ALL})
        @OneToMany(mappedBy = "${field.name?lower_case}Id")
        private ${field.type} ${field.name};
    <#else>
	    private ${field.type} ${field.name};
	</#if>
</#list>

}