# Spring Demo

### A short description
This simple, RESTful api service was created to demonstrate the use of Spring Framework.
The project was created using Spring Initializr, uses Spring Security for authentication and Spring Data JPA for data management.
The project has the simple function of managing accounts for the service.

###What You Need
* JDK 1.8 or later
* Maven 3.2+


### Get started

1. Clone the repository.
2. Run the application. If on colsole, navigate to the root folder and run:
 ```bash
 ./mvnw spring-boot:run
 ```

On startup, a single user is seeded to the in-memory database. The username and password are both "user".

### Extra libraries being used in the project

* H2 - used to create an in-memory database.
 