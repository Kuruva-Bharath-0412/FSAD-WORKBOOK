# 🚀 Quick Start Guide - Skill-14-SpringRouting

## ✅ Prerequisites Completed

- [x] Backend created with Spring Boot
- [x] Frontend created with React
- [x] All components created
- [x] Dependencies installed (axios, react-router-dom)
- [x] Database configured (skill14_db)

---

## 🔧 How to Run the Application

### Step 1: Create MySQL Database

Open MySQL and run:
```sql
CREATE DATABASE skill14_db;
```

### Step 2: Run Backend (Terminal 1)

```bash
cd C:\Users\yaswa\OneDrive\Documents\FULLSTACK\FSAD-Skills-2025\Skill-14-SpringRouting\backend
mvn spring-boot:run
```

**Expected Output:**
- Tomcat started on port 8080
- Hibernate creates the `user` table automatically
- No errors

**Verify Backend:**
Open browser: http://localhost:8080/api/users/1

---

### Step 3: Run Frontend (Terminal 2)

```bash
cd C:\Users\yaswa\OneDrive\Documents\FULLSTACK\FSAD-Skills-2025\Skill-14-SpringRouting\frontend
npm start
```

**Expected Output:**
- Starting the development server...
- Compiled successfully!
- Opens browser at http://localhost:3000

---

## 🧪 Testing the Application

### Test Flow:

1. **Register a User**
   - Go to http://localhost:3000/register
   - Fill in:
     - Username: yaswanth
     - Password: 123
     - Email: y@gmail.com
   - Click "Register"
   - ✅ Redirects to login page

2. **Login**
   - Enter credentials:
     - Username: yaswanth
     - Password: 123
   - Click "Login"
   - ✅ Redirects to /home

3. **Home Page**
   - Shows welcome message
   - Displays user info
   - Two buttons: "View Profile" and "Logout"

4. **Profile Page**
   - Shows complete user details (ID, username, email)
   - Buttons: "Back to Home" and "Logout"

5. **Logout**
   - Clears localStorage
   - Redirects to login page (/)

---

## 📝 API Endpoints to Test (Postman)

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

---

## 🎯 What You'll See

### Screenshots Expected:

1. **Login Page** (`/`)
   - Beautiful gradient purple background
   - White card with login form
   - Link to register page

2. **Register Page** (`/register`)
   - Similar design
   - Three fields: username, password, email
   - Link to login page

3. **Home Page** (`/home`)
   - Welcome message
   - User information display
   - Protected route (requires login)

4. **Profile Page** (`/profile`)
   - Complete user details
   - Professional layout
   - Navigation buttons

---

## ⚠️ Troubleshooting

### Issue 1: Port 8080 already in use
**Solution:**
```bash
# Find and kill process on port 8080
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Issue 2: Database connection error
**Check:**
- MySQL is running
- Database name is `skill14_db`
- Password is `root123` in application.properties

### Issue 3: Cannot access frontend
**Solution:**
- Ensure npm install completed
- Check if port 3000 is free
- Try: `npm start` again

### Issue 4: CORS error
**Solution:**
- @CrossOrigin("*") is already added to UserController
- Backend should be running on port 8080

---

## 📊 Project Structure Summary

```
Skill-14-SpringRouting/
├── backend/
│   ├── src/main/java/com/fsad/skill14/
│   │   ├── controller/UserController.java    ← REST API
│   │   ├── service/UserService.java          ← Business logic
│   │   ├── repository/UserRepository.java    ← Database access
│   │   ├── model/User.java                   ← Entity
│   │   └── Skill14Application.java           ← Main class
│   ├── src/main/resources/
│   │   └── application.properties            ← DB config
│   └── pom.xml                               ← Maven deps
│
└── frontend/
    ├── src/
    │   ├── components/
    │   │   ├── Login.js + Login.css          ← Login page
    │   │   ├── Register.js + Register.css    ← Registration
    │   │   ├── Home.js + Home.css            ← Home page
    │   │   └── Profile.js + Profile.css      ← Profile page
    │   └── App.js                            ← React Router
    └── package.json                          ← React deps
```

---

## 🎓 Viva Questions Ready

1. **localStorage vs sessionStorage?**
   - localStorage: Permanent storage
   - sessionStorage: Temporary (browser session only)

2. **Why store userId?**
   - To maintain user session across pages
   - Avoids re-login on every page refresh

3. **What is authentication?**
   - Verifying user credentials before granting access

4. **What are protected routes?**
   - Routes that check login status before allowing access
   - Prevents unauthorized users

5. **How does logout work?**
   - Clears localStorage
   - Redirects to login page

---

## ✅ Final Checklist

Before showing to instructor:

- [ ] MySQL database `skill14_db` created
- [ ] Backend running on port 8080
- [ ] Frontend running on port 3000
- [ ] Can register new user
- [ ] Can login with credentials
- [ ] Home page shows after login
- [ ] Profile page displays user data
- [ ] Logout works correctly
- [ ] No console errors

---

## 🎉 Success Indicators

✅ Backend console shows:
```
Tomcat started on port 8080 (http) with context path ''
Started Skill14Application in X seconds
```

✅ Frontend shows:
```
Compiled successfully!
```

✅ Browser opens to login page
✅ All navigation works
✅ Data persists in database

---

**Ready to Demo!** 🚀
