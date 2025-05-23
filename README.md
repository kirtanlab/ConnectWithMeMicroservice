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

![image](https://github.com/user-attachments/assets/6939555a-d00c-4d00-9493-437690cd9a53)

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
```
ConnectWithMe/
├── APIGateway/
├── AuthService/
│   ├── Auth_Application/
│   ├── Auth_Container/
│   ├── Auth_DataAccess/
│   ├── Auth_Domain/
│   │   ├── Auth_Application_Service/
│   │   └── Auth_Domain_Core/
│   └── Auth_Messaging/
├── FeedService/
│   ├── Feed_Application/
│   ├── Feed_Container/
│   ├── Feed_DataAccess/
│   ├── Feed_Domain/
│   │   ├── Feed_Application_Service/
│   │   └── Feed_Domain_Core/
│   └── Feed_Messaging/
├── Infrastructure/
└── ServiceDiscovery/
```

The architecture follows Domain-Driven Design (DDD) and Hexagonal Architecture principles, with clear separation between domain logic, application services, and infrastructure components. This architecture was chosen for its high security, maintainability, and abstraction capabilities.

![image](https://github.com/user-attachments/assets/09f5040f-5142-408d-af36-182b8ae7c9ec)

The application implements the ports and adapters pattern where:
- **Domain Layer**: Contains core business logic and entities
- **Application Layer**: Orchestrates use cases using domain objects
- **Infrastructure Layer**: Handles external concerns like databases and messaging

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- PostgreSQL database
- Kafka (for messaging between services)

### Setup and Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ConnectWithMe.git
   cd ConnectWithMe
2. **Build the project**
   mvn clean install
3. **Configure the databases**
   The application is configured to use a Neon PostgreSQL database. For local development, you may want to update the database configuration in each service's   
   application.yml file.
4. **Start the services (in order)**
    a. **Service Discovery**
        cd ServiceDiscovery
        mvn spring-boot:run
    b. **Auth Service**
        cd AuthService/Auth_Container
        mvn spring-boot:run
    c. **Feed Service**
        cd FeedService/Feed_Container
        mvn spring-boot:run
    d. **API Gateway**
        cd APIGateway
        mvn spring-boot:run

### Service Ports

Service Discovery: 8182
Auth Service: 8181
Feed Service: 8184
API Gateway: 8183

### API Endpoints
**Auth Service** (/Auth/v1/api/)

**POST /SignUp/**: Register a new user
**POST /Login/**: Authenticate a user
**POST /Country/**: Add a country
**POST /State/**: Add a state
**POST /City/**: Add a city
**POST /CollegeInfo/**: Add college information
**POST /Skill/**: Add a skill
**POST /UserProject/**: Create a user project

**Feed Service** (/Feed/v1/api/)

**GET /**: Test endpoint
**GET /jwtTester**: JWT authentication test endpoint

### Security
The application uses JWT (JSON Web Tokens) for authentication. The token needs to be included in the Authorization header for protected endpoints: Authorization: Bearer <your-jwt-token>

## Database Schema
The application uses several entities including:
Users
Countries, States, Cities
CollegesInfo
Skills, UserSkills
UserProjects, ProjectSkills
Education

The database schema was designed with careful consideration of relationships between entities to support the user profile, project sharing, and recommendation features.

![image](https://github.com/user-attachments/assets/2dd4c338-86bd-4741-95b9-dfc66a17b7e2)

## Event-Driven Architecture
The system uses Kafka for event-driven communication between services. Events like user registration trigger messages that are consumed by other services to update their state.
Event Flow Example
When a user registers or updates their profile:
1. Auth Service saves the user data and publishes a UserUpdatedEvent containing
    public class UserUpdatedEvent {
        private String userId;
        private List<Integer> skillIDs;
        private Integer locationID;
        private List<Integer> educationIDs;
        private List<Integer> projectSkillIDs;
    }
2. Feed Service consumes this event and:
    Updates its PostgreSQL document store with user information
    Processes data to find users with similar skills, education, or location
    Publishes a RecommendationEvent with recommended user IDs
3. The system maintains loose coupling between services while ensuring data consistency through this event-driven approach.

## Service Communication Diagrams
**User Feed Generation**
![image](https://github.com/user-attachments/assets/14d60d80-55f7-4945-911c-96b360380b49)

These sequence diagrams illustrate how the services interact to generate feeds. The Feed Service communicates with Auth Service to gather necessary data for generating personalized user feeds.

## Development Notes
The project uses Spring Security for authentication and authorization
JWT tokens are configured to expire after 1 hour
The API Gateway routes requests based on path prefixes to the appropriate services
The Service Discovery uses Netflix Eureka for service registration and discovery

## Future Enhancements
Implement better error handling and validation
Add comprehensive unit and integration tests
Set up CI/CD pipeline
Add monitoring and logging
Implement front-end applications (web and mobile)
Add social features like comments, likes, and shares

## Development History
The project was developed following a systematic approach:
1. Initial focus on clean architecture principles and their application to microservices
2. Database design for user/auth service
3. Implementation of hexagonal architecture with domain-driven design
4. Development of key APIs for user management, project sharing, and skill management
5. Integration of Kafka for event-driven communication
6. Implementation of JWT token authentication
7. Setup of service discovery using Netflix Eureka
8. Configuration of API Gateway for request routing

## License
This project is licensed under the MIT License
