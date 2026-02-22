# 💰 Expense & Savings Tracker

A Full Stack Financial Management Application built using:

- Java
- Spring Boot
- Spring Security (JWT)
- Multiple Database Support
- Scheduler
- React
- HTML, CSS, JavaScript

---

## 🚀 Features

### 🔐 Authentication
- User Signup
- User Login
- JWT Based Security
- Password Encryption (BCrypt)

### 💵 Expense Management
- Add Expense
- Delete Expense
- Monthly Expense Summary
- Expense History

### 🎯 Savings Goals
- Create Savings Goals
- Track Target Amount
- Show Remaining Amount
- Goal Completion Status

### 🔔 Notifications
- Email Alerts
- WhatsApp Alerts
- Monthly Limit Exceeded Notification
- Scheduler Based Monitoring

---

## 🏗️ Architecture

Frontend → React  
Backend → Spring Boot REST API  
Security → JWT + Spring Security  
Database → MySQL / PostgreSQL / Oracle  
Notification → JavaMail + WhatsApp API  
Scheduler → Spring @Scheduled  

---

## 📂 Project Structure

expense-savings-tracker/
│
├── backend/
│ ├── src/
│ └── pom.xml
│
├── frontend/
│ ├── src/
│ └── package.json
│
├── docs/
│
└── README.md


---

## ⚙️ Setup Instructions

### Backend Setup

cd backend
mvn clean install
mvn spring-boot:run


### Frontend Setup

cd frontend
npm install
npm start


---

## 🔐 Environment Variables

Create application.properties:

spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
jwt.secret=
mail.username=
mail.password=


---

## 👥 Branch Strategy

- main → Production
- develop → Integration
- feature/* → Individual Modules
- hotfix/* → Emergency Fixes

---

## 🧑‍💻 Author

Neela Mohan

---

## 📌 Future Enhancements

- AI Expense Prediction
- Mobile App Version
- Admin Dashboard
- Docker Deployment

  
