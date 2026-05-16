
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        Student student =
            new Student(id, name, age, course);

        students.add(student);

        System.out.println("Student Added Successfully");
    }

    static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No Students Found");
            return;
        }

        for (Student student : students) {

            student.displayStudent();
        }
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID to Delete: ");

        int id = scanner.nextInt();

        boolean removed = false;

        for (Student student : students) {

            if (student.id == id) {

                students.remove(student);

                removed = true;

                System.out.println("Student Deleted Successfully");

                break;
            }
        }

        if (!removed) {

            System.out.println("Student Not Found");
        }
    }
}
