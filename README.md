# Gestor-PSA

[![Build Status](https://travis-ci.com/gestor-psa/soporte.svg?token=ztzmYxxiK9M4zZcGZZzZ&branch=master)](https://travis-ci.com/gestor-psa/soporte)

Módulo de gestión de soporte del gestor PSA. Este permite la creación y administración de tickets sobre distintos proyectos.

### Prerequisitos
- [Java 14](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
- [Gradle 6](https://gradle.org/install/)
- [Postgresql 12](https://www.postgresql.org/)

Asegurarse de configurar las variables de conexión a la base de datos. Una opción es crear un archivo properties en `~.spring-boot-devtools.properties` que contenga:

``` properties
spring.datasource.url=jdbc:postgresql://localhost:5432/psa
spring.datasource.username=<DB_USERNAME>
spring.datasource.password=<DB_PASSWORD>
```

### OpenApi

Automáticamente se generan endpoints con la especificación de la api en [localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs) y se puede visualizar con Swagger en [localhost:8080/swagger-ui/index.html?url=/v3/api-docs](http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs).

### Comandos disponibles

#### Iniciar el servicio

    $ ./gradlew bootRun

#### Ejecutar los tests
    
    $ ./gradlew test
        
#### Ejecutar solo los tests de aceptación
        
    $ ./gradlew cucumber
