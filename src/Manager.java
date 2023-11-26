import java.util.List;

/**
 * Class for representing a Manager, a type of employee who can view quiz statuses.
 */
public class Manager extends Employee implements EmployeeAction {
    /**
     * Constructor for Manager.
     *
     * @param name The name of the Manager.
     */
    public Manager(String name) {
        super(name, EmployeeType.MANAGER);
    }

    /**
     * Implementation of the viewQuizStatus method from the EmployeeAction interface.
     *
     * @param employees List of employees.
     */
    @Override
    public void viewQuizStatus(List<Employee> employees) {
        // Custom logic for managers to view quiz status
        // ...
    }

    /**
     * Manager adds a Quiz Master
     */
    public QuizMaster addQuizMaster(String name) {
        QuizMaster newquizMaster = new QuizMaster(name);
        Company.addQuizMaster(name);
        return newquizMaster;
    }
}