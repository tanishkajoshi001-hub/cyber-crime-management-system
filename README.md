🛡️ Cyber Crime Management System

A simple, console-based Java application that helps organize and manage cyber crime cases more efficiently.
It brings together case tracking, evidence management, investigator assignment, and status updates into one easy-to-use system.

✨ Key Features

📁 Register and manage cyber crime cases

🔎 Search and view detailed case information

🚨 Set case priority and automatically calculate risk scores

👮 Assign investigators to specific cases

🧾 Add, view, and track digital evidence

🔄 Update case status as investigations progress

⚠️ Highlight critical or high-risk cases

📊 View case statistics using a simple ASCII graph

💾 Store all data using basic file handling

🛠️ Built With

 1.Java

2. Object-Oriented Programming (OOP)

3. File Handling

4. Collections Framework

5. Console-based User Interface

🚀 Setup & Run

✨Clone the repository

➡️ bash
git clone [https://github.com/tanishkajoshi001-hub/cyber-crime-management-system.git)

✨Open the project folder

➡️ bash
cd cyber-crime-management-system

✨Compile the Java files

➡️ bash
javac -d out src/*.java

✨Run the application

➡️ bash
java -cp out Main


## 📂 Project Structure

```text

cyber-crime-management-system/
│
├── src/
│   ├── Main.java
│   ├── Case.java
│   ├── CaseManager.java
│   ├── Evidence.java
│   ├── Investigator.java
│   ├── Person.java
│   ├── Suspect.java
│   ├── Victim.java
│   └── FileManager.java
│
├── data/
│   ├── cases.txt
│   ├── evidence.txt
│   └── investigators.txt
│
├── out/
│
├── README.md
└── STATEMENT.md
```

### 📝 File Overview

* `Main.java` → Main program, login, dashboard, and user interaction
* `Case.java` → Stores case details, priority, risk score, status, and investigator
* `CaseManager.java` → Handles case operations and case statistics
* `Evidence.java` → Stores and manages evidence details
* `Investigator.java` → Stores investigator information
* `Person.java` → Parent class for common personal information
* `Suspect.java` → Stores suspect-related information
* `Victim.java` → Stores victim-related information
* `FileManager.java` → Handles saving and loading data from files
* `cases.txt` → Stores registered case records
* `evidence.txt` → Stores evidence records
* `investigators.txt` → Stores investigator records

```



🔐 Default Login

⭐ Username: admin

⭐ Password: 1234

✨ Make sure you have the Java JDK installed and added to your system PATH before running the project.

📌 Project Purpose
This project was created as a practical way to apply core Java concepts—like Object-Oriented Programming, file handling, and collections—to a real-world scenario: managing cyber crime cases.
It’s designed to be a learning project that demonstrates how basic software engineering principles can support structured, efficient case management.

<img width="218" height="299" alt="Screenshot 2026-09-12 114229" src="https://github.com/user-attachments/assets/2ad1fab9-4d5d-4034-8e6e-0d69ea9a094d" />

<img width="143" height="285" alt="Screenshot 2026-09-13 214417" src="https://github.com/user-attachments/assets/1919d5e4-0346-41fc-8faa-5d2ed1126d9f" />

<img width="559" height="298" alt="Screenshot 2026-09-12 114121" src="https://github.com/user-attachments/assets/6d053f38-9f6e-42eb-9cc9-e94b63dfcf00" />

