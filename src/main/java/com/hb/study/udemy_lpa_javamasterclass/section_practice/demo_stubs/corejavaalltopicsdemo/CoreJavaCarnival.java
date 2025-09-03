package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs.corejavaalltopicsdemo;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

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
import java.util.Set;

/**
 * created by : heman on 16-07-2025, 02:41 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CoreJavaCarnival {

    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String FORMAT_STRING_PREFIX_ONE = "\uD83D\uDD37";
    private static final String FORMAT_STRING_PREFIX_TWO = "\uD83D\uDCCC";
    private static final String FORMAT_STRING_PREFIX_THREE = "\uD83E\uDDEE";
    private static final String FORMAT_STRING_PREFIX_FOUR = "\uD83E\uDDF5";
    private static final String FORMAT_STRING_PREFIX_FIVE = "\uD83D\uDCC5";
    private static final String FORMAT_STRING_PREFIX_SIX = "\uD83E\uDDEA";
    private static final String FORMAT_STRING_PREFIX_SEVEN = "\uD83D\uDCDD";
    private static final String FORMAT_STRING_PREFIX_EIGHT = "\uD83D\uDC68\u200D\uD83D\uDCBC";
    private static final String FORMAT_STRING_PREFIX_NINE = "\uD83D\uDDBC\uFE0F";
    private static final String FORMAT_STRING_PREFIX_TEN = "\uD83D\uDCC2";
    private static final String FORMAT_STRING_PREFIX_ELEVEN = "\uD83D\uDDC4\uFE0F";

    public static void main(String[] ignoredignoredUnusedArgs) {
        execution.initialize();


        ConsoleStyler.printBanner("CORE JAVA CARNIVAL");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_ONE + " Primitives and Operators");
        // 🔷 Primitives and Operators
        int a = 10;
        int b = 5;

        ConsoleStyler.styleOutput("Addition: ", Integer.toString((a + b)));
        ConsoleStyler.styleOutput("Multiplication: ", Integer.toString((a * b)));
        ConsoleStyler.styleOutput("Is A greater than B? ", Boolean.toString((a > b)));
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_ONE + " Primitives and Operators");

        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_TWO + " Control Flow");
        // 📌 Control Flow
        for (int i = 0; i < 3; i++) {
            ConsoleStyler.styleOutput("🎠 Loop Step ", Integer.toString((i + 1)));
        }
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_TWO + " Control Flow");


        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_THREE + " Arrays & Collections");
        // 🧮 Arrays & Collections
        int[] nums = {5, 8, 2, 9, 4};
        ConsoleStyler.styleOutput("Array: " + Arrays.toString(nums));

        List<String> animals = Arrays.asList("Tiger", "Zebra", "Panda");
        animals.forEach(animal -> ConsoleStyler.styleOutput("🐾 ", animal));
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_THREE + " Arrays & Collections");

        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_FOUR + " String ops");
        // 🧵 String ops
        String welcome = "Welcome to Java";
        ConsoleStyler.styleOutput("Uppercase: ", welcome.toUpperCase());
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_FOUR + " String ops");

        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_FIVE + " Date API");
        // 📅 Date API
        LocalDate now = LocalDate.now();
        ConsoleStyler.styleOutput("Today: " + now.format(DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_STANDARD)));
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_FIVE + " Date API");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_SIX + " Exception Handling");
        // 🧪 Exception Handling
        try {
            b = 0;
            ConsoleStyler.styleOutput(Integer.toString(a / b));
        } catch (ArithmeticException e) {
            ConsoleStyler.styleError("⚠️ Exception: " + e.getMessage());
        }
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_SIX + " Exception Handling");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_SEVEN + " Scanner Input");

        // 📝 Scanner Input
        Scanner scanner = new Scanner(System.in);
        ConsoleStyler.styleOutput("Enter your name: ");
        String name = scanner.nextLine();
        ConsoleStyler.styleOutput("👋 Hello, " + name);
        scanner.close();
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_SEVEN + " Scanner Input");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_EIGHT + " OOP Demo");
        // 👨‍💼 OOP Demo
        Person p = new Employee(name, 123);
        p.introduce();
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_EIGHT + " OOP Demo");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_NINE + " Swing UI");
        // 🖼️ Swing UI
        launchSwingUI();
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_NINE + " Swing UI");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_TEN + " File Output");
        // 📂 File Output
        writeToFile("logs/carnival_log.txt", "Session for " + name + " completed 🎯");
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_TEN + " File Output");
        ConsoleStyler.startSection(" " + FORMAT_STRING_PREFIX_ELEVEN + " DB Demo");
        // 🗄️ DB Demo
        runDBDemo();
        ConsoleStyler.endSection(" " + FORMAT_STRING_PREFIX_ELEVEN + " DB Demo");
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

        // ✅ Whitelist table names
        String firstTableName = "attendees";
        Set<String> allowedTables = Set.of("attendees");

        if (!allowedTables.contains(firstTableName)) {
            throw new IllegalArgumentException("Invalid table name: " + firstTableName);
        }

        // ✅ Use a fixed, safe SQL string (no concatenation in query text)
        final String createTableSQL = "CREATE TABLE IF NOT EXISTS attendees (id INTEGER PRIMARY KEY, name TEXT)";
        final String insertSQL = "INSERT INTO attendees(name) VALUES(?)";
        final String selectSQL = "SELECT id, name FROM attendees";

        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleStyler.styleOutput("Enter your name: ");
            String name = scanner.nextLine();

            try (Connection conn = DriverManager.getConnection(url)) {

                // ✅ Create table
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("CREATE TABLE IF NOT EXISTS attendees (id INTEGER PRIMARY KEY, name TEXT)");
                    ConsoleStyler.styleOutput("✅ Table ready.");
                }

                // ✅ Insert user safely with PreparedStatement
                try (PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO attendees(name) VALUES(?)")) {
                    insertStmt.setString(1, name);
                    insertStmt.executeUpdate();
                    ConsoleStyler.styleOutput("🎟️ Inserted attendee: " + name);
                }

                // ✅ Safe SELECT query
                try (Statement selectStmt = conn.createStatement();
                     ResultSet rs = selectStmt.executeQuery("SELECT id, name FROM attendees")) {
                    ConsoleStyler.styleOutput("🎟️ Attendees:");
                    while (rs.next()) {
                        ConsoleStyler.styleOutput(" - ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                    }
                }

                ConsoleStyler.styleIntro(" Just Playing around");
                viewTableDescription(url);

            } catch (SQLException e) {
                ConsoleStyler.styleError("❌ DB Error: " + e.getMessage());
            }
        }
    }

    public static void viewTableDescription(String url) {
        String query = "PRAGMA table_info( attendees );";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ConsoleStyler.styleOutput("Table Name: attendees");
            ConsoleStyler.styleOutput("Column Name | Data Type | Not Null | Default Value | Primary Key");
            ConsoleStyler.halfDivider();

            while (rs.next()) {
                String columnName = rs.getString("name");
                String dataType = rs.getString("type");
                int notNull = rs.getInt("notnull");
                String defaultValue = rs.getString("dflt_value");
                int primaryKey = rs.getInt("pk");
                ConsoleStyler.styleOutput(("%-12s | %-9s | %-8s | %-13s | %-11s%n").formatted(
                        columnName, dataType, (notNull == 1 ? "Yes" : "No"),
                        (defaultValue != null ? defaultValue : "None"),
                        (primaryKey == 1 ? "Yes" : "No")));
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
