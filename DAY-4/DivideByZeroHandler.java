import java.io.*;

public class DivideByZeroHandler {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(" ");
                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);

                try {
                    int result = numerator / denominator;
                    writer.write("Result: " + result);
                } catch (ArithmeticException e) {
                    writer.write("Error: Division by zero is not allowed.");
                }
            } else {
                writer.write("Error: Input file is empty.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input file.");
        }
    }
}
