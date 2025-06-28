import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String fileName = "output.txt"; 
      
        String[] lines = {
            "Hello, world!",
             "Goodbye!"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Adds a newline after each string
            }
            System.out.println("Strings written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to file.");
        }
    }
}
