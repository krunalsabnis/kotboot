# Kotlin Spring Boot REST API
- MySQL JPA
- Liquibase for Database version control
- gradle
- Integration tests using H2DB
- swagger pages


This is demo application
## Minimum Prerequisites

To run REST APIs only
If you wish to build and run REST APIs on your host OS

* Java 8 SDK
* MySQL 5.7.21 running on port 3306 with an existing DB schema as "kotboot" Or update the application.yml file as per your configuration. Alternatively you can also pass database details as arguments or by setting environment variables


## Build

```
> ./gradlew clean build

```

## Run

```
> ./gradlew bootRun

```

```
> gradlew.bat bootRun
```

The server will start on port 8080, navigate to [http://localhost:8080/swagger-ui.html]
(http://localhost:8080/swagger-ui.html) to review the API documentation. 
