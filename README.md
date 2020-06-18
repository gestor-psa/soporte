# Gestor-PSA

[![Build Status](https://travis-ci.com/seblaz/Gestor-PSA.svg?token=ztzmYxxiK9M4zZcGZZzZ&branch=master)](https://travis-ci.com/seblaz/Gestor-PSA)

Software desarrollado por la empresa PSA para gestionar proyectos, incidencias, imputación de horas y facturación.

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

### Comandos disponibles

#### Iniciar el servicio

    $ ./gradlew bootRun
    
#### Ejecutar los tests con modificaciones
    
    $ ./gradlew test
    
#### Ejecutar todos los tests
        
    $ ./gradlew cleanTest test
        