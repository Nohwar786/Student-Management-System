import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    Student student = new Student(
                            0, name, age, gender,
                            course, email, phone, address
                    );

                    dao.addStudent(student);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    dao.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Gender: ");
                    String newGender = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();

                    Student updatedStudent = new Student(
                            updateId, newName, newAge, newGender,
                            newCourse, newEmail, newPhone, newAddress
                    );

                    dao.updateStudent(updatedStudent);
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}