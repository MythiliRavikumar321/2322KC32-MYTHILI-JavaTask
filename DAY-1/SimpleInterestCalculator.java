import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest (per annum): ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();

                if (principal > 0 && rate > 0 && time > 0) {
            double simpleInterest = (principal * rate * time) / 100;
            System.out.println("Simple Interest = " + simpleInterest);
        } else {
            System.out.println("Error: All values must be positive.");
        }

        sc.close();
    }
}
