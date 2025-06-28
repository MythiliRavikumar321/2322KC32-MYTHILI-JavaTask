import java.util.Scanner;
 public class NumberReverse{
      public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        System.out.print("Array size:");
        int size=sc.nextInt();
        int[] a=new int[size];

        System.out.print("Array elements:");
        for(int j=0;j<size;j++){
            a[j]=sc.nextInt();

        }
        System.out.print("Reversed array:");
        for(int j=size-1;j>=0;j--){
            System.out.println(a[j]+"");
        }
        sc.close();
      }
 }
  