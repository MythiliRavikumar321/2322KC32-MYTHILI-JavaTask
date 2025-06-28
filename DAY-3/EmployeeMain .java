import java.util.Scanner;


class Person {
    String name;
    int age;

    void getPersonDetails(Scanner sc) {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        sc.nextLine(); 
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


class Employee extends Person {
    double basicSalary;
    String department;

    void getEmployeeDetails(Scanner sc) {
        getPersonDetails(sc); 
System.out.print("Enter department: ");
        department = sc.nextLine();
        System.out.print("Enter basic salary: ");
        basicSalary = sc.nextDouble();
    }

    double calculateSalary() {
        double hra = 0.2 * basicSalary;  
        double bonus = 0.1 * basicSalary; 
        return basicSalary + hra + bonus;
    }

    void displayEmployee() {
        displayPerson(); // base class method
        System.out.println("Department: " + department);
        System.out.println("Total Salary: ₹" + calculateSalary());
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        emp.getEmployeeDetails(sc);
        System.out.println("\n--- Employee Details ---");
        emp.displayEmployee();
    }
}
