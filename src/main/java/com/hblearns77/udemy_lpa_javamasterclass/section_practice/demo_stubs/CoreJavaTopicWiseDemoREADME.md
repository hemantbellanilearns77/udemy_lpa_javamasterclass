# 🎪 Core Java Demo Files: Topic Wise Demonstrations - README

Welcome to the **Core Java Demo Carnival** — a modular, topic-wise showcase curated for learning, reference, and delight. Each demo file covers a specific feature of Java, styled for clarity and powered by reusable utilities like `ConsoleStyler`. Designed and structured by Hemant, this suite blends technical precision with thematic elegance.

---

## 📁 Project Structure
com.hblearns77.udemy_lpa_javamasterclass
└── global
├── constants                  # 🔣 Shared constants (e.g., emojis, line styles)
├── utils                      # 🎨 Styling & helper utilities (e.g., ConsoleStyler)
└── libs
└── misc_demoLibs
└── topicwisedemo              # 🎯 Topic-wise core Java demo files



---

## 🎓 Demo Topics Covered

| File                      | Concept Highlights                        |
|--------------------------|-------------------------------------------|
| `DemoPrimitivesOperators` | Primitive types, operators, booleans      |
| `DemoControlFlow`         | Conditionals, loops, switch expressions   |
| `DemoOOPConcepts`         | Classes, inheritance, polymorphism        |
| `DemoStrings`             | Manipulation, comparison, formatting      |
| `DemoArrays`              | Declaration, iteration, indexing          |
| `DemoMathOperations`      | Math API, calculations, random logic      |
| `DemoDateTime`            | Local and zoned `java.time` classes       |
| `DemoCollections`         | Lists, maps, iterations                   |
| `DemoExceptionHandling`   | Try-catch-finally, runtime safety         |
| `DemoAdvancedFeatures`    | Records, pattern matching, virtual threads, streams, scoped values (JDK 16–24) |

---

## 🛠 Utilities

All demos use reusable styling helpers from:
- `ConsoleStyler.java` (in `global.utils`)
- Constants sourced from `CommonConstants.java`

These ensure consistent banners, section dividers, and improved legibility for learners and readers.

---

## 🚀 Running Demos

1. Use IntelliJ or your preferred IDE
2. Set your classpath to include the `topicwisedemo` folder
3. Run any file individually as `main()` method demos
4. For `DemoAdvancedFeatures.java`:
    - Requires JDK 19+ (Virtual Threads)
    - For JDK 24 preview: enable `--enable-preview` in VM options

---

## 🌟 Suggested Additions

- Add more domain-themed demos: `DemoEnums`, `DemoFileIO`, `DemoNetworking`
- Carnival Phase 2: REST API integration demos + Client App showcase
- Enhance README with diagrams or visual banners for concept mapping

---

Made with ❤️ and clean code discipline by Hemant.