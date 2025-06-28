import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
               HashMap<String, Integer> studentMarks = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name and marks (type 'exit' to stop):");

        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter marks for " + name + ": ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // consume newline

            studentMarks.put(name, marks); // Store in HashMap
        }

               System.out.println("\nStudent Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

                int totalMarks = 0;
        for (int marks : studentMarks.values()) {
            totalMarks += marks;
        }

        double average = studentMarks.isEmpty() ? 0 : (double) totalMarks / studentMarks.size();
        System.out.println("\nAverage Marks: " + average);

        scanner.close();
    }
}
