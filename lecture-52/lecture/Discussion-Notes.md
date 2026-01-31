## POJO and DTO

### POJO (Plain Old Java Object)

A POJO is a normal Java class. No special rules, no required base classes, no framework magic needed.

**Typical traits**

* Fields, constructors, getters and setters (or immutable fields)
* Can include methods (logic), but often kept simple
* Does not need framework annotations to exist (it can still have annotations when used with frameworks)

**Where do we use POJOs?**

* Domain or model objects (core business concepts)
* Entities (for database persistence, e.g., JPA)
* DTOs (a DTO is usually implemented as a POJO or a Java record)
* Anywhere you need a plain data structure

**Example POJO**

```java
public class Student {
  private String name;
  private String email;

  public Student() {}

  public Student(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
```


### DTO (Data Transfer Object)

A DTO is a data carrier used to move data between layers or systems, especially across a boundary like client <-> controller or service <-> service.

**Common use cases**

* Request DTO: what your API accepts (example: POST /students)
* Response DTO: what your API returns (example: 200 OK payload)

**Why DTOs exist**

* Keep your API contract separate from your internal model/entities
* Control what fields are exposed (security and clarity)
* Keep request/response stable even if your internal model changes

**Example DTOs**
Request:

```java
public class CreateStudentRequest {
  private String name;
  private String email;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
```

Response:

```java
public class StudentResponse {
  private String id;
  private String name;
  private String email;

  public StudentResponse(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public String getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
}
```

**API example**

* POST /students
* Body: `{ "name": "Test", "email": "a@ex.com" }`
* Response: `{ "id": "S123", "name": "Test", "email": "a@ex.com" }`

Note: In modern Java, DTOs are often written as `record`s to reduce boilerplate.


### POJO vs DTO

* POJO is a style of class (plain Java)
* DTO is a role or purpose (data transfer across boundaries)
* Most DTOs are POJOs, but not all POJOs are DTOs

## Spring Framework vs Spring Boot

### Spring Framework (the foundation)

Spring Framework is the core framework that provides the IoC container and the programming model for building applications.

What it gives you:

* Inversion of Control (IoC) and Dependency Injection (DI)
* Bean lifecycle, scopes, and configuration (how objects are created and wired)
* Component scanning (finds annotated components like @Component, @Service, etc.)
* A large ecosystem of modules (Spring MVC, Spring JDBC, Spring Security, etc.)

Important correction:

* Maven or Gradle is not a Spring Framework feature. They are build tools used across Java projects.
* Spring works with either Maven or Gradle. Spring Boot makes dependency management easier, but it does not force Maven.


### Spring Boot (Spring Framework plus sensible defaults)

Spring Boot sits on top of Spring Framework and focuses on faster setup, sensible defaults, and production-friendly features.

What it adds:

* Starter dependencies (curated dependency bundles like spring-boot-starter-web)
* Auto-configuration (configures common beans based on what is on the classpath)
* A simple entry point via @SpringBootApplication
* Embedded server for web apps (Tomcat by default for starter-web, can be swapped)
* Curated dependency management (compatible versions chosen for you)
* Production features via Actuator (health, metrics, and more)

### Health checks and metrics

With Spring Boot Actuator:

* Health endpoint is usually `/actuator/health`
* Metrics endpoint is usually `/actuator/metrics`

These can be configured, but those are the typical defaults.
