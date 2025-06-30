import java.sql.*;


import java.util.Scanner;

public class StudentDBManager{
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student DB Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.print("ID: ");
            ps.setInt(1, sc.nextInt());
            sc.nextLine();
            System.out.print("Name: ");
            ps.setString(2, sc.nextLine());
            System.out.print("Age: ");
            ps.setInt(3, sc.nextInt());
            sc.nextLine();
            System.out.print("Course: ");
            ps.setString(4, sc.nextLine());
            ps.executeUpdate();
            System.out.println("Student added.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewStudents() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("age") + " | " +
                                   rs.getString("course"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void searchStudent() {
        try {
            Connection conn = DBConnection.getConnection();
            System.out.print("Enter ID to search: ");
            int id = sc.nextInt();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Found: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age") +
                                   ", Course: " + rs.getString("course"));
            } else {
                System.out.println("No student found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

