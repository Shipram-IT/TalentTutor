import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employeeList = new ArrayList<>();
    private List<QuizMaster> quizMasterList = new ArrayList<>();

    private List<Manager> managerList = new ArrayList<>();

    public void addEmployee(String name, EmployeeType type) {
        Employee newEmployee = new Employee(name,type);
        employeeList.add(newEmployee);
    }

    public void addQuizMaster(String name) {
        QuizMaster newQuizMaster = new QuizMaster(name);
        quizMasterList.add(newQuizMaster);
    }

    public void addManger (String name) {
        Manager newManager = new Manager(name);
        managerList.add(newManager);
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
            System.out.println();
        }
    }



}
