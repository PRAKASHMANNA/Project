# ESOP Microservices Project

This project is a **Spring Boot Microservices Application** designed for managing **Employee Stock Option Plans (ESOP)**.  
It demonstrates microservice architecture, service communication with **Kafka**, and service discovery with **Eureka**.

---

## 🏗️ Architecture
The project is divided into multiple independent microservices:

- **API Gateway** → Entry point for all requests  
- **Discovery Gateway (Eureka Server)** → Service registry & discovery  
- **ESOP Plan Service** → Manages ESOP plans  
- **ESOP Grant Service** → Produces grant data (Kafka Producer)  
- **ESOP Allocation Service** → Consumes grant data and allocates ESOPs (Kafka Consumer + DB)

---

## ⚡ Tech Stack
- **Java 17**, **Spring Boot**  
- **Spring Cloud Netflix (Eureka, API Gateway)**  
- **Apache Kafka** (Producer & Consumer)  
- **MySQL** Database  
- **Swagger / Postman** (for API testing)  
- **Docker** (for containerization)  

---

## 🚀 Project Workflow
1. Start **Spring Boot microservices** (Plan, Grant, Allocation, API Gateway, Discovery).  
2. Start **Kafka** broker.  
3. Use **Swagger UI** or **Postman** to call REST APIs:
   - Create **Plan** data (via Plan Service).   
   or Create **Grant** data (via Grant Service).  
4. When a **Grant/plan is approved**, the event is sent to **Kafka**.  
5. **Allocation Service (Kafka Consumer)** listens to the event, processes the grant, and stores allocation data into its **MySQL table**.  

---

## 🔧 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/PRAKASHMANNA/Project.git
   ```
2. Start **Kafka** and **MySQL**.  
3. Run **Eureka Discovery Server**.  
4. Run all other services (`plan`, `grant`, `allocation`, `api_gateway`).  
5. Access **Swagger UI** or **Postman** to interact with APIs.  

---

## 📂 Project Structure
```
Project/
│── api_gateway/
│── discovery_gateway/
│── esop_plan/
│── esop_grant/
│── esop_allocation/
```

---

## 👨‍💻 Author
**Prakash Manna**  
💼 Aspiring Full Stack Java Developer  
🔗 [LinkedIn Profile](http://www.linkedin.com/in/prakash-manna-0844b1224)
