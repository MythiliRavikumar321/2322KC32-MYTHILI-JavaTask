import java.util.Scanner;
    public class StringAnalyzer{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a sentence");
             String sentence=sc.nextLine();
              
              String[] words=sentence.trim().split("\\s+");
               int wordCount=words.length;

               int charCount=0;
               for(char c:sentence.toCharArray()) {
                if(c!=' '){
                    charCount++;

                }
               }
               String reversed=new StringBuilder(sentence).reverse().toString();

               String longestWord=" ";
                 for(String word :words){
                    if(word.length()>longestWord.length()){
                        longestWord=word;
                    }
                 }
                 System.out.println("wordcount"+wordCount);
                 System.out.println("charcount"+charCount);
                 System.out.println("reversed sentence"+reversed);
                 System.out.println("longest word"+longestWord);
        }
    }