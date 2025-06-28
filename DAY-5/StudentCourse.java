import java.util.*;

class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id == s.id && name.equalsIgnoreCase(s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), id);
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}

public class StudentCourse {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        HashMap<Student, ArrayList<String>> courseMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Course Enrollment System");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Course for Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display All Students & Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();             
switch (choice) {

                case 1: 
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();                     
                      Student newStudent = new Student(name, id);
                    if (!studentList.contains(newStudent)) {
                        studentList.add(newStudent);
                        courseMap.put(newStudent, new ArrayList<>());
                        System.out.println("Student added.");
                    } else {
                        System.out.println("Student already exists.");
                    }
                    break;

                case 2: 
                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Student s : studentList) {
                        if (s.id == searchId) {
                            System.out.print("Enter course name to enroll: ");
                            String course = scanner.nextLine();
                            ArrayList<String> courses = courseMap.get(s);
                            if (!courses.contains(course)) {
                                courses.add(course);
                                System.out.println("Course added.");
                            } else {
                                System.out.println("Student already enrolled in this course.");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                    break;

                case 3:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    Iterator<Student> iterator = studentList.iterator();
                    boolean removed = false;
                    while (iterator.hasNext()) {
                        Student s = iterator.next();
                        if (s.id == removeId) {
                            iterator.remove();
                            courseMap.remove(s);
                            System.out.println("Student removed.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) System.out.println("Student not found.");
                    break;

                case 4: 
                    System.out.println("\n--- Student Enrollments ---");
                    Iterator<Student> stuIterator = studentList.iterator();
                    while (stuIterator.hasNext()) {
                        Student s = stuIterator.next();
                        System.out.println(s + " → Courses: " + courseMap.get(s));
                    }
                    break;

                case 5: 
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

