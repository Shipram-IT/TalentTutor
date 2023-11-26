import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employeeList = new ArrayList<>();
    private List<QuizMaster> quizMaster = new ArrayList<>();

    public void addEmployee(String name, EmployeeType type) {
        Employee newEmployee = new Employee(name,type);
        employeeList.add(newEmployee);
    }

    public void addQuizMaster (String name) {
        QuizMaster newQuizMaster = new QuizMaster(name);
        quizMaster.add(newQuizMaster);
    }

}
