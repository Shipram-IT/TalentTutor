import enums.EmployeeType;

import java.util.ArrayList;
import java.util.HashMap;

public class Employee {
    protected String id;
    protected String name;
    protected EmployeeType type;

    public Employee(String name, EmployeeType type) {
        this.id = "0";
        this.name = name;
        this.type = type;

        // Add employee data to CSV file
        CsvIO csvIO = new CsvIO();
        String[] titles = {"id", "name", "type"};
        String[] values = {id, name, type.name()};
        csvIO.writeToCSV("employee.csv", titles, values);
    }
    public Employee(String  id, String name, EmployeeType type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public static ArrayList<Employee> populateEmployees(ArrayList<HashMap<String, String>> data) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (HashMap<String, String> entry : data) {
            String id = entry.get("id");
            String name = entry.get("name");
            EmployeeType type = EmployeeType.valueOf(entry.get("type"));

            switch (type) {
                case MANAGER:
                    employees.add(new Manager(id, name));
                    break;
                case QUIZ_MASTER:
                    employees.add(new QuizMaster(id, name));
                    break;
                case REGULAR_EMPLOYEE:
                    employees.add(new RegularEmployee(id, name));
                    break;
                // Add more cases for other types if needed
            }
        }

        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

class Manager extends Employee {
    public Manager(String name) {
        super(name, EmployeeType.MANAGER);
    }
    public Manager(String id, String name) {
        super(id, name, EmployeeType.MANAGER);
    }
}

class QuizMaster extends Employee {
    public QuizMaster(String name) {
        super(name, EmployeeType.QUIZ_MASTER);
    }
    public QuizMaster(String id, String name) {
        super(id, name, EmployeeType.QUIZ_MASTER);
    }
}

class RegularEmployee extends Employee {

    ArrayList<QuizAttempt> quizAttempts;

    public RegularEmployee(String name) {
        super(name, EmployeeType.REGULAR_EMPLOYEE);
        this.quizAttempts = new ArrayList<>();
    }
    public RegularEmployee(String id, String name) {
        super(id, name, EmployeeType.REGULAR_EMPLOYEE);
        this.quizAttempts = new ArrayList<>();
    }
    public void addQuizAttempt(QuizAttempt quizAttempt){
        this.quizAttempts.add(quizAttempt);
    }

    public ArrayList<QuizAttempt> getQuizAttempts(){
        return this.quizAttempts;
    }

}