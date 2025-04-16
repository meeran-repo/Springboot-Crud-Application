# Customer Management Service (Spring Boot CRUD Application)

This is a simple **Customer Management** CRUD application built using **Spring Boot**. The application exposes RESTful APIs to perform Create, Read, Update, and Delete (CRUD) operations on customer records using an in-memory H2 database.

---

## Features

- Create new customers
- View a customer by ID
- List all customers
- Update existing customer details
- Delete a customer
- Input validation using Jakarta Bean Validation
- Negative testing using JUnit and MockMvc
- Test coverage reporting using JaCoCo
- Performance testing with Gatling (load simulation)

---

## Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Web (REST APIs)
- Spring Data JPA
- H2 In-Memory Database
- Maven
- JUnit 5
- MockMvc
- JaCoCo
- Gatling for performance/load testing

---

## How to Run the Application

1. **Clone the repository:**
   ```bash
   git clone https://github.com/<your-username>/customer-management-service.git
   cd customer-management-service

2. **Run the application:**
   ```./mvnw spring-boot:run```

3. **Access the REST APIs:**
   ```http://localhost:8080/api/customers```

---

## Sample API Endpoints
**Method	Endpoint	Description:**

- POST	/api/customers	Create new customer
- GET	/api/customers	Get all customers
- GET	/api/customers/{id}	Get customer by ID
- PUT	/api/customers/{id}	Update customer
- DELETE	/api/customers/{id}	Delete customer

---

## Validation
Input validation is applied using Jakarta Bean Validation in the DTO layer.

**Validation Rules:**
- @NotBlank and @Size for first and last name
- @Email for email format
- @Pattern for phone number (10 digits)
- The controller uses @Valid to trigger validation on incoming requests.


---

## Testing
**Unit and integration tests are written using:**

- JUnit 5
- MockMvc for controller-level tests
- Mockito (ready to use for service layer)

**Negative Test Coverage:**

- Invalid email format
- Blank first name
- Invalid phone number

**Junit Test Results:**
<img width="1159" alt="junit-test-pass" src="https://github.com/user-attachments/assets/29eb9efd-802a-44b4-b6b7-fdbff35f89f3" />

---

## Code Coverage
Code coverage is reported using JaCoCo and integrated with Maven.

**To generate a coverage report:**
```mvn clean verify```

**View the report at:**
target/site/jacoco/index.html

**Code Coverage Screenshot:**
<img width="1325" alt="jacoco-coverage-report" src="https://github.com/user-attachments/assets/a0f750e1-56a4-41be-ac17-ae502941795f" />

---

## Performance Testing with Gatling
Integrated Gatling for load testing using Scala simulations

Simulated:

- 10 requests/sec for Create, Update, Delete

- 100 requests/sec for Get by ID

- Duration: 1 minute per endpoint

**Report:**
```gatling-maven-plugin-demo/target/gatling/customercrudsimulation*/index.html```

**Sample Report Screenshot:**
<img width="1524" alt="Gatling-report" src="https://github.com/user-attachments/assets/dcd31e22-b73b-4e8e-a618-b25bfa940bdd" />


