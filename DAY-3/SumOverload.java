public class SumOverload {

       public static int sum(int a, int b) {
        return a + b;
    }

       public static double sum(double a, double b) {
        return a + b;
    }
public static void main(String[] args) {
               int result1 = sum(10, 20);
        System.out.println("Sum of integers: " + result1);

               double result2 = sum(5.5, 4.5);
        System.out.println("Sum of doubles: " + result2);
    }
}
