package com.hb.study.demo_stubs.corejavaalltopicsdemo;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.*;

/**
 * created by : heman on 16-07-2025, 02:41 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CoreJavaCarnival {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();


        ConsoleStyler.printBanner("CORE JAVA CARNIVAL");
        ConsoleStyler.startSection(" \uD83D\uDD37 Primitives and Operators");
        // 🔷 Primitives and Operators
        int a = 10;
        int b = 5;

        ConsoleStyler.styleOutput("Addition: ", Integer.toString((a + b)));
        ConsoleStyler.styleOutput("Multiplication: ", Integer.toString((a * b)));
        ConsoleStyler.styleOutput("Is A greater than B? ", Boolean.toString((a > b)));
        ConsoleStyler.endSection(" \uD83D\uDD37 Primitives and Operators");


        ConsoleStyler.startSection(" \uD83D\uDCCC Control Flow");
        // 📌 Control Flow
        for (int i = 0; i < 3; i++) {
            ConsoleStyler.styleOutput("🎠 Loop Step ", Integer.toString((i + 1)));
        }
        ConsoleStyler.endSection(" \uD83D\uDCCC Control Flow");


        ConsoleStyler.startSection(" \uD83E\uDDEE Arrays & Collections");
        // 🧮 Arrays & Collections
        int[] nums = {5, 8, 2, 9, 4};
        ConsoleStyler.styleOutput("Array: " + Arrays.toString(nums));

        List<String> animals = Arrays.asList("Tiger", "Zebra", "Panda");
        animals.forEach(animal -> ConsoleStyler.styleOutput("🐾 ", animal));
        ConsoleStyler.endSection(" \uD83E\uDDEE Arrays & Collections");

        ConsoleStyler.startSection(" \uD83E\uDDF5 String ops");
        // 🧵 String ops
        String welcome = "Welcome to Java";
        ConsoleStyler.styleOutput("Uppercase: ", welcome.toUpperCase());
        ConsoleStyler.endSection(" \uD83E\uDDF5 String ops");

        ConsoleStyler.startSection(" \uD83D\uDCC5 Date API");
        // 📅 Date API
        LocalDate now = LocalDate.now();
        ConsoleStyler.styleOutput("Today: " + now.format(DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_STANDARD)));
        ConsoleStyler.endSection(" \uD83D\uDCC5 Date API");
        ConsoleStyler.startSection(" \uD83E\uDDEA Exception Handling");
        // 🧪 Exception Handling
        try {
            b = 0;
            ConsoleStyler.styleOutput(Integer.toString(a / b));
        } catch (ArithmeticException e) {
            ConsoleStyler.styleError("⚠️ Exception: " + e.getMessage());
        }
        ConsoleStyler.endSection(" \uD83E\uDDEA Exception Handling");
        ConsoleStyler.startSection(" \uD83D\uDCDD Scanner Input");

        // 📝 Scanner Input
        Scanner scanner = new Scanner(System.in);
        ConsoleStyler.styleOutput("Enter your name: ");
        String name = scanner.nextLine();
        ConsoleStyler.styleOutput("👋 Hello, " + name);
        scanner.close();
        ConsoleStyler.endSection(" \uD83D\uDCDD Scanner Input");
        ConsoleStyler.startSection(" \uD83D\uDC68\u200D\uD83D\uDCBC OOP Demo");
        // 👨‍💼 OOP Demo
        Person p = new Employee(name, 123);
        p.introduce();
        ConsoleStyler.endSection(" \uD83D\uDC68\u200D\uD83D\uDCBC OOP Demo");
        ConsoleStyler.startSection(" \uD83D\uDDBC\uFE0F Swing UI");
        // 🖼️ Swing UI
        launchSwingUI();
        ConsoleStyler.startSection(" \uD83D\uDDBC\uFE0F Swing UI");
        ConsoleStyler.startSection(" \uD83D\uDCC2 File Output");
        // 📂 File Output
        writeToFile("logs/carnival_log.txt", "Session for " + name + " completed 🎯");
        ConsoleStyler.endSection(" \uD83D\uDCC2 File Output");
        ConsoleStyler.startSection(" \uD83D\uDDC4\uFE0F DB Demo");
        // 🗄️ DB Demo
        runDBDemo();
        ConsoleStyler.endSection(" \uD83D\uDDC4\uFE0F DB Demo");
        ConsoleStyler.printBanner("THANK YOU");
        execution.finalizeExecution();
    }

    public static void writeToFile(String fileName, String content) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(content);
            ConsoleStyler.styleOutput("📂 Written to: " + fileName);
        } catch (IOException e) {
            ConsoleStyler.styleError("❌ Write Error: " + e.getMessage());
        }
    }

    public static void launchSwingUI() {
        JFrame frame = new JFrame("🎨 Java Carnival UI");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to Java UI Carnival!", SwingConstants.CENTER);
        JButton button = new JButton("Click Me 🎯");

        button.addActionListener(e -> label.setText("🎉 You clicked!"));

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void runDBDemo() {
        ConsoleStyler.styleOutput("\n📂 Connecting to SQLite DB...");
        String url = "jdbc:sqlite:db\\carnival.db";
        String firstTableName = "attendees";
        String createTable = "CREATE TABLE IF NOT EXISTS " + firstTableName + " (id INTEGER PRIMARY KEY, name TEXT)";
        String insertSQL = "INSERT INTO attendees(name) VALUES(?)";
        String selectSQL = "SELECT id, name FROM attendees";
        Scanner scanner = new Scanner(System.in);
        ConsoleStyler.styleOutput("Enter your name: ");
        String name = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(url)) {
            // ✅ Create table FIRST
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTable);
                ConsoleStyler.styleOutput("✅ Table ready.");
            }

            // 🔽 Insert user
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                insertStmt.setString(1, name);
                insertStmt.executeUpdate();
                ConsoleStyler.styleOutput("🎟️ Inserted attendee: " + name);
            }

            // 🔍 Read back attendees
            try (Statement selectStmt = conn.createStatement()) {
                ResultSet rs = selectStmt.executeQuery(selectSQL);
                ConsoleStyler.styleOutput("🎟️ Attendees:");
                while (rs.next()) {
                    ConsoleStyler.styleOutput(" - ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                }
            }
            ConsoleStyler.styleIntro(" Just Playing around");
            // Playing around
            viewTableDescription(url, firstTableName);

        } catch (SQLException e) {
            ConsoleStyler.styleOutput("❌ DB Error: " + e.getMessage());
        }
    }

    public static void viewTableDescription(String url, String tableName) {
        String query = "PRAGMA table_info(" + tableName + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ConsoleStyler.styleOutput("Table Name: " + tableName);
            ConsoleStyler.styleOutput("Column Name | Data Type | Not Null | Default Value | Primary Key");
            ConsoleStyler.halfDivider();

            while (rs.next()) {
                String columnName = rs.getString("name");
                String dataType = rs.getString("type");
                int notNull = rs.getInt("notnull");
                String defaultValue = rs.getString("dflt_value");
                int primaryKey = rs.getInt("pk");

                System.out.printf("%-12s | %-9s | %-8s | %-13s | %-11s%n",
                        columnName, dataType, (notNull == 1 ? "Yes" : "No"),
                        (defaultValue != null ? defaultValue : "None"),
                        (primaryKey == 1 ? "Yes" : "No"));
            }

        } catch (SQLException e) {
            ConsoleStyler.styleError(e.getMessage());
        }
    }

    static class Person {
        protected String name;

        public Person(String name) {
            this.name = name;
        }

        public void introduce() {
            ConsoleStyler.styleOutput("\"\\u200D\" Hi, I'm " + name);
        }
    }

    static class Employee extends Person {
        private int id;

        public Employee(String name, int id) {
            super(name);
            this.id = id;
        }

        @Override
        public void introduce() {
            ConsoleStyler.styleOutput("🧑\"\\u200D\" Hi, I'm " + name + ", Employee ID: " + id);
        }
    }

}
