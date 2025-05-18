# 🏥 Patient Health Monitoring System

A full-stack **backend microservices** project built using Java, Spring Boot, Kafka, Docker, Redis, Spring Security, and deployed using CI/CD pipelines on AWS with Kubernetes.

---

## 🧱 Microservices Overview

| Service Name     | Description |
|------------------|-------------|
| **API Gateway**  | Central entry point that routes requests to microservices |
| **Patient-Service** | Manages patient registration, login, and authentication using Spring Security and JWT |
| **Vitals-Service**  | Accepts and stores patients’ vitals (e.g., heart rate, BP); uses Kafka to send critical vitals |
| **Alert-Service**   | Listens to Kafka for vitals, checks for threshold violations, and sends alerts |
| **Redis** *(Optional)* | Stores flags for alerts, rate-limiting, or temporary cache |
| **Kafka**         | Used for asynchronous messaging between Vitals and Alert services |

---

## 🧩 Key Features

### ✅ Authentication & Authorization
- Secure login with Spring Security and JWT
- Role-based access control for users (patients/admins)

### 📊 Vitals Management
- REST API to record vitals (POST)
- Timestamps each entry
- Multithreaded processing for high load
- Sends data to Kafka if thresholds breached

### 🚨 Real-time Alerts
- Alert service listens to `alerts-topic`
- If vitals cross critical thresholds, alerts are generated
- Option to integrate email/SMS or dashboard alerts

### 🔐 Spring Security
- JWT token generation during login
- Filters applied at gateway and service level
- Unauthorized access is restricted

### 🔄 Kafka Integration
- `vitals-service` → Producer (sends alert-worthy data)
- `alert-service` → Consumer (listens and processes alerts)

### 🐳 Docker + Kubernetes
- All services containerized using Docker
- Kubernetes YAML manifests for pods, deployments, services
- Load balancing and horizontal scaling with K8s

### ☁️ AWS Cloud Deployment
- Deployed using AWS EC2 or EKS (Elastic Kubernetes Service)
- External IP for API Gateway for external access

### 🔁 CI/CD Pipeline
- GitHub Actions or Jenkins used for:
  - Build, Test, Package
  - Docker Image creation
  - Kubernetes Deployment on AWS

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot** (Microservices)
- **Spring Security + JWT**
- **Kafka**
- **Redis (Optional)**
- **Docker**
- **Kubernetes (Minikube/EKS)**
- **AWS (EC2/EKS)**
- **JUnit + Mockito**
- **Git + GitHub Actions or Jenkins**
- **Maven**

---

## 🚦 Project Setup Steps

### 1. Clone the Repo

```bash
git clone https://github.com/your-repo/healthtrack.git
cd healthtrack
