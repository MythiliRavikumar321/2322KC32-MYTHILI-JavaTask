import java.util.Scanner;

public class MenuDrivenCalculator {

        public static double add(double a, double b) {
        return a + b;
    }

       public static double subtract(double a, double b) {
        return a - b;
    }

        public static double multiply(double a, double b) {
        return a * b;
    }

        public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0; // or you can throw an exception
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nMenu-Driven Calculator");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Choose an operation (1-5): ");

            int choice = sc.nextInt();

            if (choice == 5) {
                keepRunning = false;
                System.out.println("Exiting calculator. Goodbye!");
                continue;
            }

            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            double result;

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = divide(num1, num2);
                    // If division by zero, result is 0 and error already printed.
                    if (num2 != 0) {
                        System.out.println("Result: " + result);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
        sc.close();
    }
}
