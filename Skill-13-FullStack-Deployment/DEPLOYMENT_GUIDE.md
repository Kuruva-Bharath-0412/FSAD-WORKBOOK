# 🚀 Skill-13 Full-Stack Deployment Guide

Complete deployment guide for React + Spring Boot full-stack application.

---

## 📁 Project Structure

```
Skill-13-FullStack-Deployment/
│
├── backend/   (Spring Boot - Port 8080)
│   ├── src/main/java/com/fsad/backend/
│   │   ├── controller/
│   │   │   ├── StudentController.java
│   │   │   └── ViewController.java
│   │   ├── service/
│   │   │   └── StudentService.java
│   │   ├── repository/
│   │   │   └── StudentRepository.java
│   │   ├── model/
│   │   │   └── Student.java
│   │   └── BackendApplication.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── static/  (React build files go here)
│   ├── pom.xml
│   └── target/
│       └── backend-0.0.1-SNAPSHOT.jar
│
└── frontend/  (React - Port 3000 dev)
    ├── src/
    │   ├── components/
    │   │   ├── StudentList.jsx
    │   │   ├── AddStudent.jsx
    │   │   └── *.css
    │   ├── App.js
    │   └── index.js
    ├── .env
    ├── public/
    └── package.json
```

---

## 🔷 DEPLOYMENT METHOD 1: Spring Boot Static Resources (EASIEST)

### Step 1: Build React Frontend

```bash
cd frontend
npm install
npm run build
```

**Output**: `frontend/dist/` folder with optimized production build

### Step 2: Copy React Build to Backend

Copy ALL contents from:
```
frontend/dist/
```

Paste into:
```
backend/src/main/resources/static/
```

### Step 3: Build Spring Boot JAR

```bash
cd backend
mvn clean package
```

**Output**: `target/backend-0.0.1-SNAPSHOT.jar`

### Step 4: Run the Application

```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

### Step 5: Access Application

Open browser: **http://localhost:8080**

✅ Your full-stack app is now deployed!

---

## 🔷 DEPLOYMENT METHOD 2: Separate Deployment

### Frontend Deployment (Vercel/Netlify)

1. **Build React**:
   ```bash
   cd frontend
   npm run build
   ```

2. **Deploy dist folder** to Vercel/Netlify

3. **Update API URL** in `.env`:
   ```
   VITE_API_URL=https://your-backend-url.com
   ```

### Backend Deployment (Heroku/AWS/Railway)

1. **Build JAR**:
   ```bash
   mvn clean package
   ```

2. **Deploy JAR** to cloud platform

3. **Configure environment variables**:
   - DATABASE_URL
   - DB_USERNAME
   - DB_PASSWORD

---

## 🔷 DEPLOYMENT METHOD 3: Nginx Reverse Proxy (ADVANCED)

### Step 1: Install Nginx

```bash
sudo apt update
sudo apt install nginx
```

### Step 2: Copy React Build

```bash
sudo cp -r dist/* /var/www/html/
```

### Step 3: Configure Nginx

Edit `/etc/nginx/sites-available/default`:

```nginx
server {
    listen 80;
    server_name your-domain.com;

    # Frontend
    location / {
        root /var/www/html;
        index index.html;
        try_files $uri /index.html;
    }

    # Backend API Proxy
    location /api {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }
}
```

### Step 4: Restart Nginx

```bash
sudo systemctl restart nginx
```

---

## 🔷 ENVIRONMENT VARIABLES

### Frontend (.env)

```env
VITE_API_URL=http://localhost:8080
```

**Usage in code**:
```javascript
const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/students';
```

### Backend (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skill13db
spring.datasource.username=root
spring.datasource.password=YourPassword
server.port=8080
```

---

## 🔷 TESTING CHECKLIST

### ✅ Backend APIs

Test using Postman or curl:

1. **GET all students**:
   ```
   GET http://localhost:8080/students
   ```

2. **POST new student**:
   ```
   POST http://localhost:8080/students
   Content-Type: application/json
   
   {
     "name": "John Doe",
     "email": "john@example.com",
     "course": "Computer Science"
   }
   ```

3. **PUT update student**:
   ```
   PUT http://localhost:8080/students/1
   Content-Type: application/json
   
   {
     "name": "Updated Name",
     "email": "updated@example.com",
     "course": "Physics"
   }
   ```

4. **DELETE student**:
   ```
   DELETE http://localhost:8080/students/1
   ```

### ✅ Frontend UI

1. Open http://localhost:8080
2. Add a student using form
3. Verify student appears in table
4. Edit student and save
5. Delete student
6. Verify UI updates without page reload

---

## 🔷 COMMON ISSUES & FIXES

### ❌ CORS Error

**Problem**: Frontend can't access backend

**Solution**: Already fixed in `StudentController.java`:
```java
@CrossOrigin(origins = "*")
```

### ❌ API Not Working After Build

**Problem**: Hardcoded localhost URL

**Solution**: Use environment variable:
```javascript
const API_URL = import.meta.env.VITE_API_URL;
```

### ❌ React Routing Issue (404 on refresh)

**Problem**: Refresh gives 404 error

**Solution**: Already fixed in `ViewController.java`:
```java
@RequestMapping("/{path:[^\\.]*}")
public String redirect() {
    return "forward:/";
}
```

### ❌ Database Connection Failed

**Problem**: Can't connect to MySQL

**Solution**: 
1. Check MySQL is running
2. Verify credentials in application.properties
3. Ensure database exists: `CREATE DATABASE skill13db;`

### ❌ Port Already in Use

**Problem**: Port 8080 is occupied

**Solution**: Change port in application.properties:
```properties
server.port=8081
```

---

## 🔷 FINAL CHECKLIST FOR LAB EVALUATION

### ✔ Development Phase

- [ ] React app runs on `http://localhost:3000`
- [ ] Spring Boot runs on `http://localhost:8080`
- [ ] All CRUD operations work
- [ ] CORS configured properly

### ✔ Production Build

- [ ] React build generated (`npm run build`)
- [ ] Backend JAR created (`mvn clean package`)
- [ ] React files copied to `backend/src/main/resources/static/`
- [ ] Final JAR rebuilt after copying React files

### ✔ Deployment

- [ ] Application accessible via `http://localhost:8080`
- [ ] All APIs working
- [ ] Frontend + Backend integrated
- [ ] No console errors
- [ ] UI updates without page reload

### ✔ GitHub Submission

- [ ] Complete project pushed to GitHub
- [ ] Repository name: `Skill-13-FullStack-Deployment`
- [ ] Contains both frontend and backend folders
- [ ] README.md included

---

## 🔷 VIVA QUESTIONS & ANSWERS

### Q1: What's the difference between development and production build?

**Development Build**:
- Fast compilation with hot-reload
- Unminified code for debugging
- Source maps included
- Larger bundle size

**Production Build**:
- Optimized and minified
- Tree-shaking removes unused code
- Smaller bundle size
- Faster loading times

### Q2: What is a Spring Boot executable JAR?

A self-contained JAR file that includes:
- Application code
- Embedded Tomcat server
- All dependencies
- Can run with `java -jar` command

### Q3: Why use environment variables?

- Store configuration outside code
- Different settings for dev/prod
- Secure storage of API keys
- No hardcoding of URLs/passwords

### Q4: What does Nginx do as a reverse proxy?

- Routes requests to backend
- Load balancing
- SSL termination
- Caching static content
- Security layer

### Q5: Why test after deployment?

- Ensures real-world functionality
- Verifies API connectivity
- Confirms database connection
- Validates user experience

### Q6: How does Spring Boot serve React files?

- React files placed in `static/` folder
- Spring Boot serves them as static resources
- Single Page Application routing handled by ViewController
- All routes forward to `index.html`

### Q7: What is the purpose of @CrossOrigin?

- Enables CORS (Cross-Origin Resource Sharing)
- Allows frontend (port 3000) to call backend (port 8080)
- Required during development
- Not needed when served from same origin

---

## 🔷 DEPLOYMENT COMMANDS SUMMARY

### Quick Deploy (Method 1):

```bash
# Frontend
cd frontend
npm install
npm run build

# Copy files (manual step)
# Copy frontend/dist/* → backend/src/main/resources/static/

# Backend
cd ../backend
mvn clean package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

### Access:
```
http://localhost:8080
```

---

## 🎉 SUCCESS INDICATORS

✅ **Backend Console Shows**:
```
Started BackendApplication in X seconds
Tomcat started on port(s): 8080 (http)
Hibernate: create table students...
```

✅ **Browser Shows**:
- Beautiful gradient background
- "Skill-13 Full-Stack Deployment" header
- Add Student form visible
- Student List table visible
- No console errors (F12)

✅ **All Operations Work**:
- Add student → Success message
- View students → Table populated
- Edit student → Inline editing works
- Delete student → Confirmation and removal

---

## 📚 ADDITIONAL RESOURCES

- **Spring Boot Documentation**: https://spring.io/projects/spring-boot
- **React Documentation**: https://react.dev
- **Vite Environment Variables**: https://vitejs.dev/guide/env-and-mode.html
- **Nginx Configuration**: https://nginx.org/en/docs/

---

## 👨‍💻 AUTHOR

Created as part of FSAD Skills training program.

## 📄 LICENSE

This project is for educational purposes.

---

**🚀 Congratulations! Your full-stack application is now production-ready!**
