DEMO TO CREATE CRUD GENERATOR
====================

Application generate CRUD. 
Data model get from file yml.
Parse to java class.
Based on the freemarker template generate dto, repository, service and controller.
System using lombok and spring data.
Currently CRUD generate for postgres. 


- ##### Required dependency to pom.xml
```xml
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<optional>true</optional>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>org.freemarker</groupId>
	<artifactId>freemarker</artifactId>
	<version>${freemarker.version}</version>
</dependency>
<dependency>
	<groupId>org.yaml</groupId>
	<artifactId>snakeyaml</artifactId>
	<version>${yaml.version}</version>
</dependency>
```
