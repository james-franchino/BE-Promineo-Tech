# Animal Shelter Management System

## Project Overview
This project is a Spring Boot RESTful Web API for managing an animal shelter system. It provides a comprehensive solution for tracking animals, shelters, staff, adopters, and the adoption process.

## Features
- Full CRUD operations for managing animals, shelters, staff, adopters, and adoptions
- RESTful API endpoints for all entities
- Data persistence using MySQL database
- Relationship management:
  - One-to-Many: Shelters to Animals, Shelters to Staff
  - Many-to-Many: Animals to Adopters (through Adoptions)

## Technology Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok

## Entity Relationships
1. Shelter
   - Has many Animals
   - Has many Staff members
2. Animal
   - Belongs to one Shelter
   - Can have multiple Adoption records
3. Staff
   - Belongs to one Shelter
4. Adopter
   - Can have multiple Adoption records
5. Adoption
   - Links one Animal to one Adopter

    
## Getting Started
1. Clone the repository
2. Set up MySQL database and update application.yaml
3. Run the Spring Boot application

## Testing
API can be tested using Swagger, Postman, or Advanced REST Client (ARC).

## Contributors
- James Franchino
