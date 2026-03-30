#  FixItNow Backend

A Spring Boot backend system for an on-demand emergency mechanic service platform.

##  Features

- User Management (CRUD)
- Service Request System
- Mechanic Management
- Auto Mechanic Assignment
- Request Lifecycle Handling (PENDING → ACCEPTED → COMPLETED)

##  Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

##  API Endpoints

###  Users
- GET /users
- POST /users
- PUT /users/{id}
- DELETE /users/{id}

###  Service Requests
- POST /requests/{userId}
- GET /requests
- PUT /requests/{id}?status=COMPLETED
- DELETE /requests/{id}

### Mechanics
- GET /mechanics
- POST /mechanics

##  How it Works

1. User creates a service request
2. System auto-assigns an available mechanic
3. Mechanic status becomes BUSY
4. When completed → mechanic becomes AVAILABLE again

##  Author
Vishal Raj