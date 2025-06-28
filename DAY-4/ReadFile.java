import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        String fileName = "input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("Contents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + fileName);
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file.");
        }
    }
}
