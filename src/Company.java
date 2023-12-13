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
            createEmployee("manager");
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
                System.out.println("No manager found. Please enter details to create a manager:");
                createEmployee("manager");
                populateEmployeesFromCSV();
            }
        }
    }

    public Employee getEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.id.equals(id)) {
                return employee;
            }
        }
        return null;
    }

    private boolean hasManager() {
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                return true;
            }
        }
        return false;
    }

    protected void createEmployee(String role) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + role + " Name: ");
        String name = scanner.nextLine();

        switch (role.toLowerCase()) {
            case "manager":
                Manager manager = new Manager(name);
                employees.add(manager);
                System.out.println(role + " created successfully.");
                break;
            case "regularemployee":
                RegularEmployee regularEmployee = new RegularEmployee(name);
                employees.add(regularEmployee);
                System.out.println(role + " created successfully.");
                break;
            case "quizmaster":
                QuizMaster quizMaster = new QuizMaster(name);
                employees.add(quizMaster);
                System.out.println(role + " created successfully.");
                break;
            default:
                System.out.println("Invalid role.");
        }
    }


}