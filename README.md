**Library Management Service**
_Overview_
  The Library Management Service is a microservices-based application that handles library operations. It consists of two main services:
  Library Service (libraryservice) → Acts as the service layer.
  Library Management (librarymanagement) → Acts as the repository layer.
  Both services communicate using Feign Clients, and the entire system is orchestrated using Docker Compose.

_Architecture_
  libraryservice (Service Layer) → Handles business logic.
  librarymanagement (Repository Layer) → Manages database interactions.
  Feign Client → Used for inter-service communication.
  Docker Compose → Used for containerized deployment.

_Technologies Used_
  Spring Boot (REST API development)
  Spring Cloud OpenFeign (Inter-service communication)
  Spring Data JPA (Database interactions)
  Oracle/H2 (Database layer)
  Docker & Docker Compose (Containerization & Orchestration)

_Setup & Installation_
  Prerequisites
    Java 17+
    Docker & Docker Compose
    Maven
