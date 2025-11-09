# 🧠 SmartDB Handler

### A Java-Based MySQL Database Management Console using JDBC

**SmartDB Handler** is a simple yet powerful command-line application built using **Java** and **MySQL (JDBC)** that lets you interact with databases easily — without writing SQL commands manually.  
It’s designed for learning, student record management, and demonstrating JDBC operations like **connection handling, table creation, insertion, and data retrieval**.

---

## 🚀 Features
- 🎓 Create and manage student tables dynamically  
- 🗃️ Insert student marks (5 subjects) with auto-calculated **total** and **percentage**  
- 🔍 Display data neatly in a formatted table  
- 🧩 Smart validation for database and table existence  
- ⚙️ Fully implemented using **JDBC (PreparedStatement, ResultSet, Statement)**  
- 🧠 Modular structure for scalability (`App`, `connect`, `marks` classes)

---

## 🧩 Tech Stack
| Component | Technology |
|------------|-------------|
| **Language** | Java |
| **Database** | MySQL |
| **Driver** | MySQL Connector/J |
| **IDE** | IntelliJ IDEA / Eclipse / VS Code |

---


## 📊 Database Schema (Auto-Generated)
| Column Name | Type | Description |
|--------------|------|-------------|
| `student_id` | INT (PK, AI) | Unique Student ID |
| `student_name` | VARCHAR(100) | Name of the student |
| `subject1`–`subject5` | INT | Marks for each subject (0–100) |
| `total` | INT (Generated) | Sum of all 5 subjects |
| `percentage` | DECIMAL(5,2) | Average of 5 subjects |

---

## 🧠 Future Improvements
- ✏️ Update or Delete student details  
- 🔍 Search by name or ID  
- 📊 Sort by total or percentage  
- 📤 Export data to CSV  
- 🖥️ Add GUI using Swing or JavaFX  

---

## 👨‍💻 Author
**Vasanth Raj**  
💡 Passionate about Java and Databases  
🔗 GitHub: [github.com/iamvasanthraj](https://github.com/iamvasanthraj)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)

---


> 🏷️ *“SmartDB Handler — A console-based student record management system built using Java and MySQL (JDBC).”*
