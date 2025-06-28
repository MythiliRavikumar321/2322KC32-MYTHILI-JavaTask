import java.util.ArrayList;
import java.util.Iterator;

class Student {
    String name;
    int rollNumber;

    
    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    
    void display() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber);
    }
}

public class StudentList {
    public static void main(String[] args) {
       
        ArrayList<Student> students = new ArrayList<>();

        
        students.add(new Student("myu", 1));
        students.add(new Student("ravi", 2));
        students.add(new Student("nithiya", 3));

        
        Iterator<Student> iterator = students.iterator();
        System.out.println("Student List:");
        while (iterator.hasNext()) {
            Student s = iterator.next();
            s.display(); 
        }
    }
}
