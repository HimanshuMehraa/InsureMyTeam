Insurance Management System
This project is an insurance management system that allows users to manage clients, insurance policies, and insurance claims. It provides RESTful APIs for performing CRUD operations on clients, policies, and claims.

Technologies Used
Java 17
Spring Boot
Spring Data JPA
H2 InMemory Database
Maven

Installation
Clone the repository
Build the project using Maven: mvn clean install
Run the application: java -jar target/insurance-management-system-0.0.1-SNAPSHOT.jar

Usage

The API documentation can be accessed at /swagger-ui.html. The following API endpoints are available:

Clients
GET /api/clients: Fetch all clients.
GET /api/clients/{id}: Fetch a specific client by ID.
POST /api/clients: Create a new client.
PUT /api/clients/{id}: Update a client's information.
DELETE /api/clients/{id}: Delete a client.

Insurance Policies
GET /api/policies: Fetch all insurance policies.
GET /api/policies/{id}: Fetch a specific insurance policy by ID.
POST /api/policies: Create a new insurance policy.
PUT /api/policies/{id}: Update an insurance policy.
DELETE /api/policies/{id}: Delete an insurance policy.

Claims
GET /api/claims: Fetch all claims.
GET /api/claims/{id}: Fetch a specific claim by ID.
POST /api/claims: Create a new claim.
PUT /api/claims/{id}: Update a claim's information.
DELETE /api/claims/{id}: Delete a claim.