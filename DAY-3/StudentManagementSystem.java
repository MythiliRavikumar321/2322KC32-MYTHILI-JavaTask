import java.util.Scanner;

class Student {
        private int rollNo;
    private String name;
    private int[] marks = new int[3];  // Array for 3 subjects
    private int total;
    private double average;

       public void createStudent(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
        sc.nextLine();         
System.out.print("Enter Name: ");
        name = sc.nextLine();
    }

       public void assignMarks(Scanner sc) {
        total = 0;
        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }
        average = total / 3.0;
    }

   
    public void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        for (int i = 0; i < 3; i++) {
            System.out.println("Subject " + (i + 1) + " Marks: " + marks[i]);
        }
        System.out.println("Total Marks: " + total);
        System.out.printf("Average: ", average);
        if (average >= 50) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        Student student = new Student();

                student.createStudent(sc);

               student.assignMarks(sc);

                student.displayResult();

        sc.close();
    }
}
