import java.util.ArrayList;
import java.util.List;

public class Company {
    private static List<Employee> employeeList = new ArrayList<>();
    private static List<QuizMaster> quizMasterList = new ArrayList<>();

    private List<Manager> managerList = new ArrayList<>();

    private List<RegularEmployee> regularEmployeesList = new ArrayList<>();


    public void addQuizMaster(QuizMaster quizMaster) {
        quizMasterList.add(quizMaster);
    }


    public void addManger (String name) {
        Manager newManager = new Manager(name);
        managerList.add(newManager);
    }

    public void addRegularEmployee (String name, Department department) {
        RegularEmployee newregularEmployee = new RegularEmployee(name, department);
        regularEmployeesList.add(newregularEmployee);
    }

    public static void addQuizMaster(String name) {
        QuizMaster newQuizMaster = new QuizMaster(name);
        quizMasterList.add(newQuizMaster);
    }

    public static void addEmployee(String name, EmployeeType type) {
        Employee newEmployee = new Employee(name,type);
        employeeList.add(newEmployee);

    }

    public void printEmploeeDetails() {
        System.out.println("Employees: ");
        for (Employee employee : employeeList) {
            System.out.println("Employee Details: " + employee.getName() + " " + employee.getType());
        }

        System.out.println("\nQuizMaster: ");
        for (QuizMaster quizMaster: quizMasterList) {
            System.out.println("Quiz Details: " + quizMaster.getName() + " " + quizMaster.getType());

        }

        for (Manager manager: managerList) {
            System.out.println("Manager Details: " + manager.getName() + " " + manager.getType());
        }

        for (RegularEmployee regularEmployee: regularEmployeesList) {
            System.out.println("Regular Employee details: " + regularEmployee.getName() + " " + regularEmployee.getDepartment());
        }
    }



}
