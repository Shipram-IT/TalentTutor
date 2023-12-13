import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();

        if (!csvFileExists()) {
            createManager();
        }
        populateEmployeesFromCSV();
//        showEmployeeList();
    }

    private boolean csvFileExists() {
        File file = new File("employee.csv");
        return file.exists();
    }

    private void populateEmployeesFromCSV() {
        if (csvFileExists()) {
            String[] fields = {"id", "name", "type"};
            CsvIO csvIO = new CsvIO();
            ArrayList<HashMap<String, String>> data = csvIO.readFromCSV("employee.csv", fields);
            employees = Employee.populateEmployees(data);
            if(!hasManager()){
                createManager();
                populateEmployeesFromCSV();
            }
        }
    }

    private boolean hasManager() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                return true;
            }
        }
        return false;
    }
    private void createManager() {
        Scanner scanner = new Scanner(System.in);

        // Check if a manager already exists
        if (!hasManager()) {
            System.out.println("No manager found. Please enter details to create a manager:");
            System.out.print("Enter Manager Name: ");
            String name = scanner.nextLine();
            Manager manager = new Manager(name);
            employees.add(manager);
            System.out.println("Manager created successfully.");
        } else {
            System.out.println("Manager already exists.");
        }
    }

    public void showEmployeeList() {
        populateEmployeesFromCSV();
        System.out.println("Employee List for " + name + ":");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
}