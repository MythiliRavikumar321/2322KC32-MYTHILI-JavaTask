import java.io.*;

public class ResultProcessor {
    public static void main(String[] args) {
        String inputFile = "marks.txt";
        String outputFile = "results.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];

                int total = 0;
                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                }

                double average = (double) total / (parts.length - 1);
                String result = name + ": Total = " + total + ", Average = " + String.format("%.2f", average);
                writer.write(result);
                writer.newLine();
            }

            System.out.println("Results processed successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid mark format: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
