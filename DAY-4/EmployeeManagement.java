import java.io.*;
import java.util.*;

public class EmployeeManagement {

    static final String FILE_NAME = "employees.txt";

        public static void createEmployee(int id, String name, String position, double salary) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(id + "," + name + "," + position + "," + salary);
            bw.newLine();
            System.out.println("Employee added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

      public static void readEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Employee Records:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.println("ID: " + parts[0] + ", Name: " + parts[1] +
                            ", Position: " + parts[2] + ", Salary: " + parts[3]);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found. No employees to display.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

        public static void updateEmployee(int id, String newName, String newPosition, double newSalary) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) == id) {
                    bw.write(id + "," + newName + "," + newPosition + "," + newSalary);
                    found = true;
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }

            if (found) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }

        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            System.err.println("Error replacing original file.");
        }
    }

        public static void deleteEmployee(int id) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) != id) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }

        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            System.err.println("Error replacing original file.");
        }
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    createEmployee(id, name, position, salary);
                    break;
                case 2:
                    readEmployees();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Position: ");
                    String newPos = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    updateEmployee(uid, newName, newPos, newSalary);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    deleteEmployee(did);
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
