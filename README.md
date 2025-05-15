# 🏥 Patient Health Monitoring System

This is a full-stack backend microservices project built using Java, Spring Boot, Kafka, Docker, Redis, Spring Security, CI/CD, and deployed to AWS with Kubernetes.

---

## 🧱 Microservices Overview

| Service Name       | Description |
|--------------------|-------------|
| Patient-Service     | Handles patient registration & login (Spring Security + JWT) |
| Vitals-Service      | Consumes vitals data via Kafka, processes it using multi-threading |
| Alert-Service       | Checks vitals against thresholds, triggers alerts (REST API or Kafka) |
| Redis (Optional)    | Stores temporary alert flags or rate-limiting info |
| Kafka               | Event broker between services (Vitals data transmission) |

---

## 🛠 Tech Stack

- Java 17
- Spring Boot (Microservices)
- Spring Security (JWT)
- Kafka (Producer/Consumer)
- Docker (Containerization)
- Redis (optional)
- JUnit & Mockito (Testing)
- Git + GitHub Actions / Jenkins (CI/CD)
- AWS EC2 or EKS (Hosting)
- Kubernetes (Orchestration)
- Maven

---

## 🚦 Project Setup Steps

### 1. Clone the Repo

```bash
git clone https://github.com/your-repo/health-monitoring-system.git
cd health-monitoring-system
