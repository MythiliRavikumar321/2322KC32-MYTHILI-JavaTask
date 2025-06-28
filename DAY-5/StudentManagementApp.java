import java.util.*;
import java.io.*;

public class StudentManagementApp {

    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<Integer, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Mini Student Management App ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course for Student");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Delete Course for Student");
            System.out.println("6. Display All Students & Courses");
            System.out.println("7. Save Courses to File");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    deleteCourse();
                    break;
                case 6:
                    displayAll();
                    break;
                case 7:
                    saveToFile();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

        private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return num;
    }

       private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        if (studentNames.contains(name)) {
            System.out.println("Student already exists.");
            return;
        }
        studentNames.add(name);
        studentCourses.put(studentNames.indexOf(name), new ArrayList<>());
        System.out.println("Student added.");
    }

       private static void addCourse() {
        System.out.print("Enter student ID (0 to " + (studentNames.size() - 1) + "): ");
        int id = readInt();
        if (!validStudentId(id)) return;

        System.out.print("Enter course name to add: ");
        String course = scanner.nextLine().trim();
        if (course.isEmpty()) {
            System.out.println("Course name cannot be empty.");
            return;
        }

        ArrayList<String> courses = studentCourses.get(id);
        if (courses.contains(course)) {
            System.out.println("Course already enrolled.");
        } else {
            courses.add(course);
            System.out.println("Course added.");
        }
    }

        private static void searchStudent() {
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine().trim();
        int id = studentNames.indexOf(name);
        if (id == -1) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student ID: " + id);
            System.out.println("Courses: " + studentCourses.get(id));
        }
    }

        private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = readInt();
        if (!validStudentId(id)) return;

        String removedName = studentNames.remove(id);
        studentCourses.remove(id);


        HashMap<Integer, ArrayList<String>> newMap = new HashMap<>();
        for (int key : studentCourses.keySet()) {
            if (key > id) {
                newMap.put(key - 1, studentCourses.get(key));
            } else if (key < id) {
                newMap.put(key, studentCourses.get(key));
            }
        }
        studentCourses = newMap;

        System.out.println("Deleted student: " + removedName);
    }

        private static void deleteCourse() {
        System.out.print("Enter student ID (0 to " + (studentNames.size() - 1) + "): ");
        int id = readInt();
        if (!validStudentId(id)) return;

        ArrayList<String> courses = studentCourses.get(id);
        if (courses.isEmpty()) {
            System.out.println("Student has no courses enrolled.");
            return;
        }

        System.out.println("Courses: " + courses);
        System.out.print("Enter course name to delete: ");
        String course = scanner.nextLine().trim();

        if (courses.remove(course)) {
            System.out.println("Course removed.");
        } else {
            System.out.println("Course not found.");
        }
    }

       private static void displayAll() {
        if (studentNames.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        System.out.println("\n--- Students & Courses ---");
        Iterator<String> nameIterator = studentNames.iterator();
        int idx = 0;
        while (nameIterator.hasNext()) {
            String name = nameIterator.next();
            System.out.println("ID: " + idx + " | Name: " + name + " | Courses: " + studentCourses.get(idx));
            idx++;
        }
    }

    private static void saveToFile() {
        System.out.print("Enter filename to save (e.g., courses.txt): ");
        String filename = scanner.nextLine().trim();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < studentNames.size(); i++) {
                writer.write("Student: " + studentNames.get(i) + " (ID: " + i + ")");
                writer.newLine();
                writer.write("Courses: " + studentCourses.get(i));
                writer.newLine();
                writer.newLine();
            }
            System.out.println("Courses saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    private static boolean validStudentId(int id) {
        if (id < 0 || id >= studentNames.size()) {
            System.out.println("Invalid student ID.");
            return false;
        }
        return true;
    }
}
