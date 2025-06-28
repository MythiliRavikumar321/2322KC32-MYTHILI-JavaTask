import java.util.Scanner;

public class StudentGrading {

        public static String getGrade(int marks) {
        if (marks < 0 || marks > 100) {
            return "Invalid marks";
        } else if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B+";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter student marks (0-100): ");
        int marks = sc.nextInt();
        
        String grade = getGrade(marks);
        
        if (grade.equals("Invalid marks")) {
            System.out.println("Please enter valid marks between 0 and 100.");
        } else {
            System.out.println("Grade: " + grade);
        }
        
        sc.close();
    }
}
