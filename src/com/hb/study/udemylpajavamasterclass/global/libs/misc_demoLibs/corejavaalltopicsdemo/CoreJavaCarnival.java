package com.hb.study.udemylpajavamasterclass.global.libs.misc_demoLibs.corejavaalltopicsdemo;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

/**
 * created by : heman on 16-07-2025, 02:41 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CoreJavaCarnival {

    //Object level or Static declarations here...
    //public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        //execution.setUp();

        /*
         *****************************************************
         */


        printBanner("CORE JAVA CARNIVAL");

        // 🔷 Primitives and Operators
        int a = 10, b = 5;
        System.out.println("Addition: " + (a + b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Is A greater than B? " + (a > b));

        // 📌 Control Flow
        for (int i = 0; i < 3; i++) {
            System.out.println("🎠 Loop Step " + (i + 1));
        }

        // 🧮 Arrays & Collections
        int[] nums = {5, 8, 2, 9, 4};
        System.out.println("Array: " + Arrays.toString(nums));
        List<String> animals = Arrays.asList("Tiger", "Zebra", "Panda");
        animals.forEach(animal -> System.out.println("🐾 " + animal));

        // 🧵 String ops
        String welcome = "Welcome to Java";
        System.out.println("Uppercase: " + welcome.toUpperCase());

        // 📅 Date API
        LocalDate now = LocalDate.now();
        System.out.println("Today: " + now.format(DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_STANDARD)));

        // 🧪 Exception Handling
        try {
            int result = 100 / 0;
        } catch (ArithmeticException e) {
            System.out.println("⚠️ Exception: " + e.getMessage());
        }

        // 📝 Scanner Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("👋 Hello, " + name);

        // 👨‍💼 OOP Demo
        Person p = new Employee(name, 123);
        p.introduce();

        // 🖼️ Swing UI
        //launchSwingUI();

        // 📂 File Output
        writeToFile("logs/carnival_log.txt", "Session for " + name + " completed 🎯");

        // 🗄️ DB Demo
        runDBDemo(name);

        printBanner("THANK YOU");

        /*
         *****************************************************
         */
        //execution.windDown();
    }

    public static void printBanner(String label) {
        System.out.println("\n" + "🎉 ".repeat(10));
        System.out.println("🎪 " + label.toUpperCase());
        System.out.println("🎉 ".repeat(10) + "\n");
    }

    public static void writeToFile(String fileName, String content) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(content);
            System.out.println("📂 Written to: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Write Error: " + e.getMessage());
        }
    }

    public static void launchSwingUI() {
        JFrame frame = new JFrame("🎨 Java Carnival UI");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome to Java UI Carnival!", SwingConstants.CENTER);
        JButton button = new JButton("Click Me 🎯");

        button.addActionListener(e -> label.setText("🎉 You clicked!"));

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    /*public static void runDBDemo(String name) {
        System.out.println("\n📂 Connecting to SQLite DB...");
        String url = "jdbc:sqlite:carnival.db";

        String createTable = "CREATE TABLE IF NOT EXISTS attendees (id INTEGER PRIMARY KEY, name TEXT)";
        String insertSQL = "INSERT INTO attendees(name) VALUES(?)";
        String selectSQL = "SELECT * FROM attendees";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement createStmt = conn.prepareStatement(createTable);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
             Statement selectStmt = conn.createStatement()) {

            try {
                createStmt.execute();
                System.out.println("✅ Table created or already exists.");
            } catch (SQLException e) {
                System.out.println("❌ Table creation failed: " + e.getMessage());
            }

            insertStmt.setString(1, name);
            insertStmt.executeUpdate();

            System.out.println("🎟️ Attendees:");
            ResultSet rs = selectStmt.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println(" - ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }*/

    public static void runDBDemo(String name) {
        System.out.println("\n📂 Connecting to SQLite DB...");
        String url = "jdbc:sqlite:carnival.db";

        String createTable = "CREATE TABLE IF NOT EXISTS attendees (id INTEGER PRIMARY KEY, name TEXT)";
        String insertSQL = "INSERT INTO attendees(name) VALUES(?)";
        String selectSQL = "SELECT * FROM attendees";

        try (Connection conn = DriverManager.getConnection(url)) {
            // ✅ Create table FIRST
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTable);
                System.out.println("✅ Table ready.");
            }

            // 🔽 Insert user
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                insertStmt.setString(1, name);
                insertStmt.executeUpdate();
                System.out.println("🎟️ Inserted attendee: " + name);
            }

            // 🔍 Read back attendees
            try (Statement selectStmt = conn.createStatement()) {
                ResultSet rs = selectStmt.executeQuery(selectSQL);
                System.out.println("🎟️ Attendees:");
                while (rs.next()) {
                    System.out.println(" - ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }
    static class Person {
        protected String name;

        public Person(String name) {
            this.name = name;
        }

        public void introduce() {
            System.out.println("🙋 Hi, I'm " + name);
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
            System.out.println("🧑‍💼 Hi, I'm " + name + ", Employee ID: " + id);
        }
    }

}
