# 🎓 Java Masterclass Practice Suite by Hemant

A vibrant companion project built while pursuing the [_Java Programming Masterclass_ by Tim Buchalka (LPA)](https://www.udemy.com/course/java-the-complete-java-developer-course/). This Core Java app captures Hemant’s learning journey—from exercises and challenges to whimsical formatting demos and testing frameworks—with help from **Copilot by Microsoft** along the way.

---

## 🗂️ Project Structure Overview
project-root/
├── src/                          # com.hb.study.misc_utils.demo_stubs.Main Java source code
│   ├── main/                    # com.hb.study.misc_utils.demo_stubs.Main logic (if you want to mirror Maven convention)
│   └── test/                    # Test files, if applicable
├── config/                      # Configs, sample inputs, log settings, etc.
├── data/                        # Demo databases, mock data, or CSVs
├── fileio-dump/                 # Output dumps from FileIO experiments
├── reports/                     # Static analysis reports: sonar, checkstyle, PMD
│   ├── sonar/
│   ├── checkstyle/
│   └── pmd/
├── utils/                       # Utility scripts, one-off diagnostic tools
├── docs/                        # Documentation: FSD, BSD, SDD, diagrams
├── lib/                         # External JARs, if any
├── scripts/                     # CLI helpers or setup/validation scripts
├── .idea/                       # IntelliJ-specific configs (auto-generated)
├── .gitignore                   # Project-level exclusions
└── README.md                    # Overview, setup instructions, etc.
---

## ⚙️ Technologies Used

- **Java 24** or higher
- **JUnit 5 (Jupiter)** for modern unit testing
- **Swing UI** for interactive and colorful demos
- **SQLite (optional)** for embedded storage
- **IntelliJ IDEA** as primary IDE

---

## 🎪 Featured Components

### 🎭 FormatterCarnival
- Locale and timezone preview demos
- GUI combo boxes with “All” options
- Built for both creativity and utility

### 🧩 Global Utilities
- Common constants and libraries
- Reusable models and format handlers

### 📚 Section Modules
- `section3_firststeps` and `section4_basics` reflect course progression
- Each contains:
    - 💻 `coding_challenges`: Hands-on practice tasks
    - 📖 `exercises`: Guided assignments from the course
    - 🔍 `misc_codedemo`: Mini demos and experimentations

---

## 🧪 Testing Strategy

Organized using mirrored packages and themed naming:
src/global/models/           → test/global/tests/models/ src/global/utils/            → test/global/tests/utils/ src/formatterCarnival/...    → test/global/tests/formatter/


- Written in **JUnit 5**
- Naming patterns like `ZoneCarnivalTest` and `OperatorsFestTest` to match the playful theme
- Easy to extend with mock inputs and modular test utilities

> ✅ All tests are designed to be run directly in IntelliJ’s test runner.

---

## 🎯 How to Run

### 💻 With IntelliJ:
1. Clone or open the project
2. Run `DemoRunner.java` from `global/`
3. Execute test suites from the `test/` folder

### 🛠️ Manual CLI (if needed):
```bash
javac -cp "lib/*" src/com/hb/study/.../DemoRunner.java
java -cp "lib/*:src" com.hb.study.udemylpajavamasterclass.demo_stubs.misc_utils.DemoRunner
```
---
## 🌈 Evolution Timeline

| Phase         | Milestone                                                                 |
|---------------|---------------------------------------------------------------------------|
| 🎓 Learning    | Developed alongside the *Java Masterclass by Tim Buchalka (LPA)*         |
| 🤝 Integration | Integrated practice modules, coding challenges, and formatter utilities  |
| 🤖 Discovery   | Discovered **Copilot by Microsoft** to accelerate learning and structure |
| 🎡 Expansion   | Created bonus demos like **FormatterCarnival** and **CoreJavaDemoCarnival** |
| 🧪 Refactoring | Introduced **JUnit 5** for structured testing and utility verification    |
| 🏗️ Growth      | Structured sections, enhanced UI, and added thematic module separation    |
| 🔮 Future       | Planning REST API integration, locale-aware demos, and lesson mapping    |




👤 Author
Hemant is a meticulous and imaginative Java developer who combines technical mastery with expressive design. His style blends vibrant theming, modular utilities, and exploratory learning—all reflected in this app’s architecture.

💡 Future Ideas
- REST-powered version of FormatterCarnival
- Locale-aware demos with cultural formatting
- Instructor tools or lesson flow simulato
- Dashboard to toggle practice modules interactively
