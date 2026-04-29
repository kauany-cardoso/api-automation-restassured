# API Automation Framework with RestAssured

This project is a REST API test automation framework developed with **Java 11, RestAssured, Cucumber, JUnit, Maven, JSON Schema Validator, and GitHub Actions**.

It was created as part of a QA Automation portfolio to demonstrate professional practices in API testing, BDD, reusable architecture, contract validation, request/response validation, and CI/CD-ready automated test execution.

---

## 🚀 Technologies Used

- Java 11
- RestAssured
- Cucumber
- JUnit
- Maven
- Gherkin
- JSON Path
- JSON Schema Validator
- Hamcrest
- GitHub Actions

---

## 📌 Project Overview

This framework validates REST API endpoints using BDD scenarios written in Gherkin.

The project uses the public JSONPlaceholder API to demonstrate API testing practices, including:

- HTTP method validation
- Status code validation
- Response body validation
- JSON Path assertions
- JSON Schema contract validation
- Reusable request specification
- Separation of responsibilities between steps, clients, utils, payloads, schemas, context, and configuration

Tested API:

```text
https://jsonplaceholder.typicode.com
```

---

## ✅ Test Scenarios Covered

The project currently covers the main REST operations:

- GET post by ID successfully
- GET post not found
- GET list of posts successfully
- POST create a new post
- PUT fully update a post
- PATCH partially update a post
- DELETE a post successfully
- Validate response body fields
- Validate HTTP status codes
- Validate response contract using JSON Schema

Example scenario:

```gherkin
@smoke @get
Scenario: Validate single post search successfully
  When I send a GET request to search for post with id 1
  Then the API should return status code 200
  And the response should contain the post title "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
  And the response should contain user id 1
  And the response should match the post contract schema
```

---

## 📁 Project Structure

```text
api-automation-restassured
├── .github
│   └── workflows
│       └── api-tests.yml
├── src
│   └── test
│       ├── java
│       │   ├── clients
│       │   │   └── PostClient.java
│       │   ├── config
│       │   │   └── EnvironmentConfig.java
│       │   ├── context
│       │   │   └── TestContext.java
│       │   ├── payloads
│       │   │   └── PostPayloadFactory.java
│       │   ├── runner
│       │   │   └── RunnerTest.java
│       │   ├── steps
│       │   │   └── PostSteps.java
│       │   └── utils
│       │       ├── RequestSpecFactory.java
│       │       └── RestUtils.java
│       └── resources
│           ├── features
│           │   └── posts.feature
│           └── schemas
│               ├── post-schema.json
│               └── post-list-schema.json
├── .gitignore
├── pom.xml
└── README.md
```

---

## 🧱 Framework Architecture

This framework follows a layered architecture to keep the code clean, reusable, and maintainable.

### Feature Layer

Contains BDD scenarios written in Gherkin.

```text
src/test/resources/features
```

### Step Definitions Layer

Implements the Gherkin steps and performs assertions.

```text
src/test/java/steps
```

### Client Layer

Centralizes API endpoint calls and separates HTTP communication from test logic.

```text
src/test/java/clients
```

### Utility Layer

Contains reusable REST methods for GET, POST, PUT, PATCH, and DELETE.

```text
src/test/java/utils
```

### Request Specification Layer

Centralizes common request configuration such as base URI, content type, and accepted response format.

```text
src/test/java/utils/RequestSpecFactory.java
```

### Payload Layer

Centralizes request body creation for POST, PUT, and PATCH requests.

```text
src/test/java/payloads
```

### Context Layer

Stores and shares API responses during scenario execution.

```text
src/test/java/context
```

### Config Layer

Centralizes environment configuration such as the base URI.

```text
src/test/java/config
```

### Schema Layer

Stores JSON Schema files used for contract validation.

```text
src/test/resources/schemas
```

---

## 🧪 How to Run the Tests

### Prerequisites

Make sure you have installed:

- Java 11+
- Maven
- Git

### Run all tests

```bash
mvn clean test
```

### Run tests by tag

Run API tests:

```bash
mvn clean test -Dcucumber.filter.tags="@api"
```

Run smoke tests:

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

Run regression tests:

```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

Run negative tests:

```bash
mvn clean test -Dcucumber.filter.tags="@negative"
```

---

## 📊 Test Reports

After test execution, reports are generated in:

```text
target/cucumber-reports/
```

HTML report:

```text
target/cucumber-reports/cucumber.html
```

JSON report:

```text
target/cucumber-reports/cucumber.json
```

---

## 🔄 CI/CD

This project is configured with **GitHub Actions** to automatically execute the API test suite on:

- Push to the `main` branch
- Pull requests targeting the `main` branch

Workflow file:

```text
.github/workflows/api-tests.yml
```

The pipeline performs:

- Repository checkout
- Java 11 setup
- Maven dependency cache
- Automated test execution
- Cucumber report upload as an artifact

---

## 🔎 Good Practices Applied

- BDD with Cucumber and Gherkin
- REST API automation using RestAssured
- Layered framework architecture
- Reusable API client layer
- Centralized environment configuration
- Centralized payload factory
- Centralized request specification
- Shared test context
- JSON Path response validation
- JSON Schema contract validation
- HTTP status code validation
- Tags for selective test execution
- Cucumber HTML and JSON reports
- Git-ready structure with `.gitignore`
- CI/CD-ready execution with GitHub Actions

---

## 📌 Future Improvements

- Add environment selection using Maven profiles
- Add dynamic test data generation
- Add externalized test data files
- Add Allure Reports integration
- Add negative scenarios for invalid payloads
- Add authentication examples
- Add reusable header management
- Add parallel test execution
- Add Docker support for test execution

---

## 👩‍💻 Author

**Kauany Cardoso**  
QA Automation Engineer focused on Web, Mobile, and API testing.

---

⭐ This project is part of my QA Automation portfolio.