# ConnectWithMe

ConnectWithMe is a microservices-based platform that enables users to create profiles, share projects, and connect with others based on skills, education, and interests. The platform implements clean architecture principles with a hexagonal approach, focusing on domain-driven design and clear separation of concerns.

## Architecture Overview

This project uses a microservices architecture with the following components:

- **API Gateway**: Routes requests to the appropriate microservices
- **Service Discovery**: Registers and discovers services using Netflix Eureka
- **Auth Service**: Handles user authentication, registration, and profile management
- **Feed Service**: Manages user feeds and content delivery
- **Infrastructure**: Shared components and utilities

### Architectural Diagrams

#### Complete System Architecture

![System Architecture](https://i.imgur.com/sYl9v4I.png)

The architecture includes:
- Ingress Gateway for client requests
- Service Discovery using Eureka
- Multiple specialized microservices (Auth, Feed)
- Apache Kafka for event streaming
- Centralized logging and monitoring

## Technology Stack

- **Java 17**: Core programming language
- **Spring Boot 3.2.5**: Application framework
- **Spring Cloud**: Microservices ecosystem
- **Spring Security + JWT**: Authentication and authorization
- **Spring Data JPA**: Data access layer
- **PostgreSQL**: Relational database
- **Maven**: Dependency management and build tool
- **Kafka**: Event-driven messaging between services
- **Docker**: Containerization (for development and deployment)

## Project Structure
