# Training Program Service

A microservice for managing training program-related operations within the CAMS microservices platform.

## Student Information

| **Information**    | **Details**                                              |
| ------------------ | -------------------------------------------------------- |
| **Student Name**   | `Dineth Osanka Nakandala`                                |
| **Student Number** | `241711046`                                              |
| **Slack Handle**   | `https://ijse-eca-hdse-71-72.slack.com/team/U0BERT7M7PH` |
| **GCP Project ID** | `impactful-study-477106-j6`                              |

## Project Description

The **Training Program Service** is a backend microservice responsible for managing training program-related functionality within the CAMS platform.

The service uses **MongoDB** for data persistence and integrates with **Netflix Eureka** for service discovery and **Spring Cloud Config** for centralized configuration management.

It also uses **OpenFeign** for communication with other microservices and **Spring Security** for application security.

## Technology Stack

* **Java:** 23
* **Spring Boot:** 4.1.0
* **Spring Cloud:** 2025.1.2
* **MongoDB**
* **Spring Data MongoDB**
* **Spring Security**
* **Spring Cloud OpenFeign**
* **Netflix Eureka Client**
* **Spring Cloud Config**
* **Spring Boot Actuator**
* **MapStruct:** 1.6.3
* **ModelMapper:** 3.0.0
* **Lombok:** 1.18.42
* **Spring Boot Validation**
* **Maven**
* **Git & GitHub**
* **Google Cloud Platform (GCP)**

## Project Structure

```text id="y4o9zs"
Training-Program-Service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── .gitignore
├── pom.xml
└── README.md
```

## Prerequisites

* Java JDK 23
* Apache Maven
* Git
* MongoDB
* An IDE such as IntelliJ IDEA or Eclipse
* Running Config Server
* Running Service Registry

Verify the installed versions:

```bash id="5g9g0h"
java -version
mvn -version
git --version
```

## Setup / Getting Started

### 1. Clone the Repository

```bash id="q9z9ye"
git clone <GITHUB_REPOSITORY_URL>
cd Training-Program-Service
```

### 2. Database Configuration

The service uses **MongoDB** for data storage.

Configured database details:

```text id="6u4j6m"
Database: eca
Host: localhost
Port: 13500
Username: root
Authentication Database: admin
```

Make sure MongoDB is running and the required database is accessible before starting the service.

### 3. Start Required Services

Before starting the Training Program Service, make sure the following services are available:

* **Config Server**
* **Service Registry / Eureka Server**
* **MongoDB**

### 4. Build the Project

```bash id="3e8oy9"
mvn clean install
```

### 5. Run the Application

```bash id="v5d7iq"
mvn spring-boot:run
```

Alternatively, run the main Spring Boot application class directly from your IDE.


## Inter-Service Communication

The project uses **Spring Cloud OpenFeign** for communication with other microservices.

OpenFeign provides a declarative approach for making HTTP requests between services within the microservices architecture.


## Database

The service uses:

* **MongoDB**
* **Spring Data MongoDB**

MongoDB is configured to run on port `13500`.

## Actuator

Spring Boot Actuator is included for application monitoring and management.

Actuator endpoints can be configured according to the application's environment.

## Building for Deployment

To create the application JAR file:

```bash id="lyj5ob"
mvn clean package
```

The generated JAR file will be available inside:

```text id="s9m4v2"
target/
```

Run the generated application using:

```bash id="r3v5p4"
java -jar target/Training-Program-Service-0.0.1-SNAPSHOT.jar
```


## Repository Information

**Repository Name:** `Training-Program-Service`

**Repository Description / About:**

> Training program management microservice for the CAMS platform using Spring Boot, MongoDB, Eureka, OpenFeign, and Spring Cloud Config.

