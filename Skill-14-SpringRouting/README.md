# Skill-14-SpringRouting 🚀

Complete Full-Stack Authentication Application with Spring Boot + React

## 📋 Features

- ✅ User Registration
- ✅ User Login
- ✅ Protected Routes
- ✅ Profile Management
- ✅ Session Management (localStorage)
- ✅ MySQL Database
- ✅ REST API
- ✅ React Router

## 🛠️ Tech Stack

### Backend
- Spring Boot 3.2.0
- Spring Data JPA
- MySQL Driver
- REST API

### Frontend
- React 18
- React Router DOM
- Axios
- localStorage for session

## 📁 Project Structure

```
Skill-14-SpringRouting/
├── backend/
│   ├── src/main/java/com/fsad/skill14/
│   │   ├── controller/
│   │   │   └── UserController.java
│   │   ├── service/
│   │   │   └── UserService.java
│   │   ├── repository/
│   │   │   └── UserRepository.java
│   │   ├── model/
│   │   │   └── User.java
│   │   └── Skill14Application.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
└── frontend/
    ├── src/
    │   ├── components/
    │   │   ├── Register.js
    │   │   ├── Login.js
    │   │   ├── Home.js
    │   │   └── Profile.js
    │   └── App.js
    └── package.json
```

## 🔧 Setup Instructions

### 1. Database Setup
```sql
CREATE DATABASE skill14_db;
```

### 2. Backend Configuration
File: `backend/src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skill14_db
spring.datasource.username=root
spring.datasource.password=root123
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

### 3. Run Backend
```bash
cd backend
mvn spring-boot:run
```

Verify: Check http://localhost:8080/api/users/1

### 4. Run Frontend
```bash
cd frontend
npm install axios react-router-dom
npm start
```

## 🧪 Testing with Postman

### 1. Register User
**POST** → `http://localhost:8080/api/users/register`
```json
{
  "username": "yaswanth",
  "password": "123",
  "email": "y@gmail.com"
}
```

### 2. Login User
**POST** → `http://localhost:8080/api/users/login`
```json
{
  "username": "yaswanth",
  "password": "123"
}
```

### 3. Get User by ID
**GET** → `http://localhost:8080/api/users/1`

## 🎯 Complete Flow

1. User registers → stored in MySQL
2. User logs in → validated from DB
3. userId stored in localStorage
4. Home page checks login status
5. Profile fetches data using ID
6. Logout clears storage + redirect

## 📝 Viva Questions

### Q1: localStorage vs sessionStorage?
**A:** 
- localStorage → permanent (until manually cleared)
- sessionStorage → temporary (cleared when browser closes)

### Q2: Why store userId?
**A:** To maintain user session across pages without requiring re-login.

### Q3: What is authentication?
**A:** Process of verifying user credentials (username/password) before granting access.

### Q4: What are protected routes?
**A:** Routes that check if user is logged in before allowing access. Prevents unauthorized access.

### Q5: How does logout work?
**A:** Clears localStorage/sessionStorage and redirects to login page.

## 🔍 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/users/register | Register new user |
| POST | /api/users/login | Login user |
| GET | /api/users/{id} | Get user by ID |

## 🖥️ Screenshots Expected

1. **Register Page** - Form with username, password, email
2. **Login Page** - Form with username and password
3. **Home Page** - Welcome message after login
4. **Profile Page** - User details fetched from database

## ⚠️ Common Issues & Solutions

### Issue 1: Port 8080 already in use
**Solution:** Kill the process or change port in application.properties

### Issue 2: Database connection error
**Solution:** 
- Ensure MySQL is running
- Check database name is `skill14_db`
- Verify password is `root123`

### Issue 3: CORS error
**Solution:** @CrossOrigin annotation is already added to controller

### Issue 4: React Router not working
**Solution:** Ensure react-router-dom is installed: `npm install react-router-dom`

## 🎓 Learning Outcomes

- ✅ Spring Boot project setup
- ✅ REST API creation
- ✅ React Router implementation
- ✅ Authentication flow
- ✅ Session management
- ✅ Protected routes
- ✅ API integration with Axios
- ✅ localStorage usage

## 📌 Important Code Snippets

### Login Logic (Frontend)
```javascript
axios.post("http://localhost:8080/api/users/login", login)
.then(res => {
  if(res.data){
    localStorage.setItem("userId", res.data.id);
    navigate("/home");
  }
});
```

### Protected Route Logic
```javascript
useEffect(() => {
  const user = localStorage.getItem("userId");
  if (!user) {
    navigate("/");
  }
}, []);
```

### Profile Fetch
```javascript
const id = localStorage.getItem("userId");
axios.get(`http://localhost:8080/api/users/${id}`)
  .then(res => setUser(res.data));
```

### Logout
```javascript
localStorage.removeItem("userId");
window.location.href = "/";
```

## 🚀 Quick Start Commands

### Terminal 1 (Backend):
```bash
cd backend
mvn spring-boot:run
```

### Terminal 2 (Frontend):
```bash
cd frontend
npm start
```

### Test:
Open http://localhost:3000

---

**Created by:** Yaswanth  
**Date:** March 2026  
**Skill:** Spring Routing & Authentication
