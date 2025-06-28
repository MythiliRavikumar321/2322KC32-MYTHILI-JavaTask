import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

                char[] chars = input.toLowerCase().toCharArray();

                char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : chars) {
                       if (Character.isLetter(c)) {
               
                boolean isVowel = false;
                for (char v : vowels) {
                    if (c == v) {
                        isVowel = true;
                        break;
                    }
                }
                if (isVowel) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

               System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);

        scanner.close();
    }
}
