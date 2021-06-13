****Single Page Recipe App****

Single Page web Application with list of recipes information.
Recipe details can be maintained by CURD operations.
This project based on the Spring Boot, JavaScript,AngularJs, Bootstrap 

It's a Maven project and some configurations are.

Database Configuration - In build h2 in-memory database
Access in-memory database :http://localhost:8081/h2_console

user: admin password: password

To run the application locally:

mvn clean install

mvn spring-boot:run

commands run the application.

Application runs from localhost:8081

Basic authentication is in placed to access the service and swagger ui.

user: admin  password: password

Swagger UI URL: http://localhost:8081/swagger-ui.html#/

For more information about operations and services please follow the swagger ui page

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.7/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.7/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#using-boot-devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

