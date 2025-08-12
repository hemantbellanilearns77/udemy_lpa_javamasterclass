# 🎪 Core Java Carnival

Welcome to the **Core Java Carnival**, an all-in-one showcase of Java fundamentals — from primitives to Swing UI and JDBC connectivity — all wrapped in a joyful single-file experience.

---

## 🧱 Project Overview

### 📄 Files Included

| File                          | Description                                              |
|-------------------------------|----------------------------------------------------------|
| `CoreJavaCarnival.java`       | com.hb.study.misc_utils.demo_stubs.Main showcase file demonstrating core Java concepts      |
| `CoreJavaCarnivalPlay.java`   | Launcher file to execute the carnival program            |

---

## 💡 Concepts Covered

- 🧮 Primitive types, variables, operators
- 🔁 Control flow: loops, conditionals
- 🎭 Object-Oriented Programming:
    - Classes, inheritance, polymorphism
    - Overriding, encapsulation, interfaces
- 📦 Arrays and Collections (`Array`, `List`)
- 🧵 String manipulation and formatting
- 📅 Java Time API for date handling
- 🧪 Exception handling (`try/catch/finally`)
- 📝 User input with `Scanner`
- 🖼️ Swing GUI: basic frame with label and button
- 📂 File I/O using `PrintWriter`
- 🗄️ JDBC-based SQLite demo (connect, create, insert, select)

---

## 📚 Conceptual Guide to Core Java Topics

The **Core Java Carnival** is designed to not only show working code, but help you understand why each concept matters. Here's what you'll gain by diving in:

### 🔧 Primitives & Operators
Understand how Java handles basic data types (int, double, boolean) and performs calculations — the foundation of all logic.

### 🔄 Control Flow
With loops and conditionals, your app gains intelligence: repetition, decision-making, and branching paths.

### 🧠 OOP Principles
Create structured and maintainable code with classes, inheritance, and polymorphism. This is the architectural soul of Java.

### 🧵 Strings & Formatting
Master handling text for logs, display, user interaction, and formatted output — a key part of any real-world app.

### 📅 Date Handling
Use Java’s `LocalDate` and `DateTimeFormatter` to work with time safely and flexibly.

### 🧪 Exceptions
Guard your app against runtime errors using `try/catch`, keeping behavior robust even when surprises occur.

### 📝 User Input
Take live data from users and respond to it — from names to commands, interactivity adds life to your app.

### 🖼️ UI with Swing
Create basic windows and buttons to introduce GUI programming — perfect stepping stone to richer desktop apps.

### 📂 File Output
Log results or messages to files — enabling persistence and traceability in your programs.

### 🗄️ DB Access via JDBC
Connect to a SQLite database using standard JDBC API. Create a table, insert a row, and fetch results — all in one session.

---

## ▶️ How to Run This Project

### ✅ Step 1: Compile

```bash
  javac CoreJavaCarnival.java CoreJavaCarnivalPlay.java

```
### ✅ Step 2: Run
```bash
  java CoreJavaCarnivalPlay
```
---
### ✅ Step 3: Enable JDBC (for DB access) and Run with JDBC driver:
🔽 Download the SQLite JDBC Driver:
Choose one of these sources:
- GitHub: https://github.com/xerial/sqlite-jdbc/releases
- SourceForge: https://sourceforge.net/projects/sqlite-jdbc-driver.mirror/
- Maven Central: https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc 

Save the file (example: sqlite-jdbc-3.50.2.0.jar ) in your project directory.

Ensure you have the jar downloaded and added to your classpath:
```bash
  java -cp ".;sqlite-jdbc-3.36.0.3.jar" CoreJavaCarnivalPlay

```
---

## 🖼️ What the GUI Shows
- A Swing window titled “Java Carnival UI”
- A label greeting the user
- A button which, when clicked, updates the label to a celebratory message

---

## 📂 Files Created During Execution
- carnival_log.txt: logs the session info
- carnival.db: SQLite database with user info table

---

## ️ ️️Sample Console Output

🎪 CORE JAVA CARNIVAL
Addition: 15
Multiplication: 50
🐾 Tiger
🐾 Zebra
🐾 Panda
⚠️ Exception: / by zero
👋 Hello, Hemant
🧑‍💼 Hi, I'm Hemant, Employee ID: 123
📂 Written to: carnival_log.txt
🎟️ Attendees:
- ID: 1, Name: Hemant

---

##  ❤️ License & Credits
Created with passion by Hemant and powered by Microsoft Copilot
Use freely for learning, remixing, and extending — let the Carnival never end! 🎠

---