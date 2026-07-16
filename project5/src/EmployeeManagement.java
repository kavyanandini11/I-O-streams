
import java.io.*;
import java.util.*;

public class EmployeeManagement {

    static final String FILE_NAME = "employee.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nMain Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee(sc);
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    System.out.println("Exiting the System");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void addEmployee(Scanner sc) {

        try {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, age, salary);

            ArrayList<Employee> list = new ArrayList<>();

            File file = new File(FILE_NAME);

            if (file.exists()) {

                ObjectInputStream in =
                        new ObjectInputStream(new FileInputStream(file));

                list = (ArrayList<Employee>) in.readObject();

                in.close();
            }

            list.add(emp);

            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(list);

            out.close();

            System.out.println("Employee Added Successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void displayEmployees() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No Employee Records Found.");
                return;
            }

            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(file));

            ArrayList<Employee> list =
                    (ArrayList<Employee>) in.readObject();

            in.close();

            System.out.println("\n----- Report -----");

            for (Employee e : list) {

                System.out.println(e.getId() + " "
                        + e.getName() + " "
                        + e.getAge() + " "
                        + e.getSalary());
            }

            System.out.println("----- End of Report -----");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}