# 🏥 Patient Health Monitoring System

A backend microservices project built with Java and Spring Boot, using Kafka, MongoDB, Docker, and Kubernetes. This system helps manage patient info, track vitals, and send alerts for critical health conditions.

---

## 🚀 Roadmap

1. **Patient-Service**  
   - Implement user registration, login, roles, and password encryption

2. **Vitals-Service**  
   - Build REST APIs to record patient vitals  
   - Store vitals in MongoDB  
   - Send alerts via Kafka for critical values

3. **Alert-Service**  
   - Consume Kafka messages  
   - Generate alerts (email/SMS/logging)

4. **Security**  
   - Secure all services with Spring Security and JWT authentication

5. **Resilience**  
   - Add retries and circuit breakers to handle failures gracefully

6. **Testing**  
   - Write unit and integration tests for reliability

7. **Containerization & Deployment**  
   - Dockerize all microservices  
   - Deploy using Kubernetes

8. **CI/CD Pipeline**  
   - Automate builds, tests, and deployment with GitHub Actions or Jenkins

9. **Extras (Optional)**  
   - Add Swagger API documentation  
   - Implement rate limiting, logging, and monitoring

---

## 🛠 Tech Stack

- Java 17  
- Spring Boot (Microservices)  
- Spring Security + JWT  
- Kafka  
- MongoDB  
- Docker & Kubernetes  
- JUnit + Mockito  
- GitHub Actions or Jenkins for CI/CD  

---

## 📦 How to Run

1. Clone this repo  
2. Configure MongoDB and Kafka settings in each service’s application properties  
3. Build each microservice using Maven  
4. Run microservices locally or docker-compose / Kubernetes manifests  
5. Test APIs via Postman or Swagger UI  

---

Feel free to contribute or ask questions!

