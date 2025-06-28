import java.util.Scanner;
  public class AddressBook{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String[] names=new String[5];
        String[] phones=new String[5];
        String[] emails=new String[5];
 System.out.println("Enter the contacts details");

 for(int i=0;i<5;i++){
  System.out.println("Contact"+(i+1));
   System.out.println(" enter name:");
     names[i]=sc.nextLine();

     System.out.println(" enter phone:");
     phones[i]=sc.nextLine();

     System.out.println("enter email:");
    emails[i]=sc.nextLine();

    } 
System.out.println("Address Book");
    for(int i=0;i<5;i++){

    
System.out.println("Contact"+(i+1));

System.out.println("name:"+names[i]);
System.out.println("phone:"+phones[i]);
System.out.println("email:"+emails[i]);
  }}
}