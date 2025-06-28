import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmailList {
    public static void main(String[] args) {
                HashSet<String> emailSet = new HashSet<>();

        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email addresses (type 'exit' to stop):");

        while (true) {
            String email = scanner.nextLine();

                        if (email.equalsIgnoreCase("exit")) {
                break;
            }

                        if (emailSet.add(email)) {
                System.out.println("Added: " + email);
            } else {
                System.out.println("Duplicate email, not added: " + email);
            }
        }

               System.out.println("\nUnique Email Addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }

        scanner.close();
    }
}
