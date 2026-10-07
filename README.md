<div align="center">

# 💼 Job Microservice Backend

### Job Portal Backend using Spring Boot Microservices

A scalable job board backend built with **Spring Boot Microservices**, featuring API Gateway, Service Discovery, Centralized Configuration, inter-service communication, and Docker-based deployment.

<br>

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</div>

---

## 📜 Table of Contents

- [📌 Project Overview](#-project-overview)
- [🧰 Tech Stack](#-tech-stack)
- [🏗️ System Architecture](#️-system-architecture)
- [📂 Project Structure](#-project-structure)
- [✨ Features](#-features)
- [🧩 Microservices Overview](#-microservices-overview)
- [🔗 API Gateway](#-api-gateway)
- [🔄 Request Flow](#-request-flow)
- [⚙️ Configuration](#️-configuration)
- [🐳 Docker Deployment](#-docker-deployment)
- [🗄️ Databases](#️-databases)
- [🚀 Getting Started](#-getting-started)
- [📘 API Documentation](#-api-documentation)
- [📸 Screenshots](#-screenshots)
- [📈 Future Enhancements](#-future-enhancements)
- [👨‍💻 Author](#-author)

---

## 📌 Project Overview

This project is a **Job Portal Backend** built using **Spring Boot Microservices Architecture**.

Instead of one monolithic application, the system is split into independent services that communicate over REST APIs. Companies can post jobs, and users can view jobs and leave reviews for companies.

The architecture includes:

- API Gateway
- Eureka Service Discovery
- Spring Cloud Config Server
- Company Service
- Job Service
- Review Service
- Dockerized deployment

The system demonstrates how modern backend applications are designed for **scalability**, **maintainability**, and **fault isolation**.

---

## 🧰 Tech Stack

<p align="center">
  <img src="https://skillicons.dev/icons?i=java,spring,maven,postgres,docker,git,github,idea" />
</p>

| Category | Technologies |
|---|---|
| **Backend** | Java 21, Spring Boot, Spring Web, Spring Data JPA, Spring Cloud |
| **Microservices** | API Gateway, Eureka Discovery, Config Server, OpenFeign |
| **Database** | PostgreSQL |
| **DevOps** | Docker, Docker Compose |
| **Build Tool** | Maven |
| **IDE** | IntelliJ IDEA |

---

## 🏗️ System Architecture

```
                      +----------------+
                      |     Client     |
                      +-------+--------+
                              |
                         API Requests
                              |
                              v
                     +------------------+
                     |    API Gateway   |
                     +--------+---------+
                              |
        ------------------------------------------
        |                     |                  |
        v                     v                  v
+----------------+   +----------------+   +----------------+
| Company Service|   |  Job Service   |   | Review Service |
+--------+-------+   +--------+-------+   +--------+-------+
        |                     |                  |
        v                     v                  v
   PostgreSQL            PostgreSQL         PostgreSQL

   Job Service  ---->  Company Service  (inter-service call)
   Review Service ---> Company Service  (inter-service call)

              Eureka Discovery Server
                       |
                  Config Server
```

---

## 📂 Project Structure

```
Job_Microservice/
├── api-gateway/                   # Single entry point, request routing
│   ├── src/
│   └── pom.xml
├── config-server/                 # Centralized externalized configuration
│   ├── src/
│   └── pom.xml
├── service-registry/              # Eureka service registration & discovery
│   ├── src/
│   └── pom.xml
├── company-service/               # Company management
│   ├── src/
│   └── pom.xml
├── job-service/                   # Job posting management
│   ├── src/
│   └── pom.xml
├── review-service/                # Company reviews
│   ├── src/
│   └── pom.xml
├── docker-compose.yml             # Multi-container orchestration
├── images/                        # Screenshots
└── README.md
```

> 📌 *Adjust folder names to match your actual project.*

---

## ✨ Features

<table>
<tr>
<td width="50%" valign="top">

### 🧩 Architecture
- Microservices Architecture
- API Gateway Routing
- Eureka Service Discovery
- Centralized Configuration Server
- Inter-service communication

</td>
<td width="50%" valign="top">

### 📦 Domain Capabilities
- Company Management
- Job Posting & Listing
- Company Reviews & Ratings
- RESTful APIs

</td>
</tr>
<tr>
<td width="50%" valign="top">

### 🗄️ Data & Persistence
- PostgreSQL Integration
- Spring Data JPA
- Database per service

</td>
<td width="50%" valign="top">

### 🐳 Deployment
- Docker containers
- Docker Compose orchestration

</td>
</tr>
</table>

---

## 🧩 Microservices Overview

| Service | Description | Database |
|---|---|---|
| **API Gateway** | Single entry point for all client requests. Handles routing and load balancing | — |
| **Config Server** | Provides centralized, externalized configuration for all services | — |
| **Service Registry (Eureka)** | Handles service registration and dynamic discovery | — |
| **Company Service** | Manages companies — create, update, delete, and view company details | PostgreSQL |
| **Job Service** | Manages job postings — create, update, delete, and list jobs with company details | PostgreSQL |
| **Review Service** | Manages company reviews and ratings | PostgreSQL |

### 🏢 Company Service
**Features:** Add Company · Update Company · Delete Company · Get Company · List Companies
**Database:** PostgreSQL

### 💼 Job Service
**Features:** Create Job · Update Job · Delete Job · Get Job · List Jobs
**Database:** PostgreSQL

### ⭐ Review Service
**Features:** Add Review · Update Review · Delete Review · Get Reviews by Company
**Database:** PostgreSQL

### ⚙️ Config Server
Provides centralized configuration for all microservices.
**Benefits:** Externalized configuration · Easy environment management · Single source of configuration

### 🔍 Eureka Discovery Server
Handles service registration and discovery.
**Benefits:** Automatic registration · Dynamic service lookup · Load balancing support

---

## 🔗 API Gateway

All client requests pass through the API Gateway.

**Responsibilities:**
- Request Routing
- Load Balancing
- Central Entry Point
- Security Integration *(future enhancement)*
- Rate Limiting *(future enhancement)*

---

## 🔄 Request Flow

```
Client
  ↓
API Gateway
  ↓
Microservices (Company / Job / Review)
  ↓
Database
```

1. The **Client** sends a request to the system.
2. The **API Gateway** receives it and routes it to the correct microservice via Eureka.
3. The target **microservice** processes the business logic.
4. If needed, services call each other (e.g., Job Service fetches company details from Company Service).
5. The service reads from or writes to its dedicated **database**.

---

## ⚙️ Configuration

Example `application.properties`:

```properties
spring.application.name=job-service

server.port=8082

spring.datasource.url=jdbc:postgresql://localhost:5432/jobdb
spring.datasource.username=postgres
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

---

## 🐳 Docker Deployment

The project is containerized using **Docker**. All services communicate over a shared Docker network — each registers with **Eureka**, pulls configuration from the **Config Server**, and is reachable through the **API Gateway**.

**Services deployed via Docker Compose:**
- Config Server
- Eureka Server
- API Gateway
- Company Service
- Job Service
- Review Service
- PostgreSQL

**Run the project:**
```bash
docker-compose up --build
```

**Stop the project:**
```bash
docker-compose down
```

---

## 🗄️ Databases

| Service | Database |
|---|---|
| Company Service | PostgreSQL |
| Job Service | PostgreSQL |
| Review Service | PostgreSQL |

---

## 🚀 Getting Started

### Step 1 — Clone the repository
```bash
git clone https://github.com/thulasiram1380/Job_Microservice.git
cd Job_Microservice
```

### Step 2 — Build the project
```bash
mvn clean install
```

### Step 3 — Run with Docker
```bash
docker-compose up --build
```

### Step 4 — Or start services individually
1. Config Server
2. Eureka Server
3. Company Service
4. Job Service
5. Review Service
6. API Gateway

### Step 5 — Verify
- Eureka Dashboard → `http://localhost:8761`
- API Gateway → `http://localhost:8084`

---

## 📘 API Documentation

All endpoints are accessible through the API Gateway.

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/companies` | Add a company |
| `GET` | `/companies` | List all companies |
| `GET` | `/companies/{id}` | Get a company |
| `PUT` | `/companies/{id}` | Update a company |
| `DELETE` | `/companies/{id}` | Delete a company |
| `POST` | `/jobs` | Create a job |
| `GET` | `/jobs` | List all jobs |
| `GET` | `/jobs/{id}` | Get a job |
| `PUT` | `/jobs/{id}` | Update a job |
| `DELETE` | `/jobs/{id}` | Delete a job |
| `POST` | `/reviews?companyId={id}` | Add a review |
| `GET` | `/reviews?companyId={id}` | Get reviews of a company |
| `PUT` | `/reviews/{id}` | Update a review |
| `DELETE` | `/reviews/{id}` | Delete a review |

> 📌 *Update endpoints to match your controllers.*


---

## 📈 Future Enhancements

| Enhancement | Description |
|---|---|
| 🔐 **JWT Authentication** | Token-based authentication for secured endpoints |
| 🛡️ **Spring Security** | Role-based access (Admin / Employer / Job Seeker) |
| 🧵 **Distributed Tracing (Zipkin)** | End-to-end request tracing across services |
| 📨 **RabbitMQ / Kafka** | Event-driven communication (e.g., update company rating on new review) |
| 🛑 **Resilience4j** | Circuit breaker, retry, and rate limiting |
| 📊 **Prometheus & Grafana** | Metrics and monitoring dashboards |
| ☸️ **Kubernetes Deployment** | Container orchestration beyond Docker Compose |
| 🔄 **CI/CD Pipeline** | Automated build, test, and deployment |

---

## 👨‍💻 Author

**Thulasiram P**
Backend Developer | Java | Spring Boot | Microservices | Docker | PostgreSQL

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/thulasiram1380)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/thulasiram-java)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:thulasiramp06@gmail.com)

---

<div align="center">

**Made with ☕ and Spring Boot**

</div>
