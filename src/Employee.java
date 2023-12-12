import java.util.List;

/**
 * Class for Employee
 */
public class Employee implements EmployeeAction {
    //This is a class Id controller yielded after each object instantiated
    private static int nextID = 1;

    //Object fields
    private String name;
    private EmployeeType type;
    private int employee_id;


    /**
     * Constructor for Employee
     *
     * @param name The name of the employee
     * @param type The type of the employee (QuizMaster, Manager, RegularEmployee)
     */
    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
        this.employee_id = nextID++;
    }

    /**
     * Getter method for the name of the employee
     *
     * @return The name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the type of the employee
     *
     * @return The type of the employee
     */
    public EmployeeType getType() {
        return type;
    }

    /**
     * Implementation of viewQuizStatus from EmployeeAction interface
     */
    @Override
    public void viewQuizStatus(List<Employee> employees) {
        // Logic to view quiz status
        // ...
    }
}