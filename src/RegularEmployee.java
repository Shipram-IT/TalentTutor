import java.util.List;

// Class for RegularEmployee
public class RegularEmployee extends Employee implements EmployeeAction {
    private Department department;

    /**
     * Constructor for RegularEmployee.
     *
     * @param name       The name of the RegularEmployee.
     * @param department The department of the RegularEmployee.
     */
    public RegularEmployee(String name, Department department) {
        super(name, EmployeeType.REGULAR_EMPLOYEE);
        this.department = department;
    }

    /**
     * Implementation of the viewQuizStatus method from the EmployeeAction interface.
     *
     * @param employees List of employees.
     */
    @Override
    public void viewQuizStatus(List<Employee> employees) {
        // Custom logic for regular employees to view quiz status
        // ...
    }

    /**
     * Getter method for retrieving the department of the RegularEmployee.
     *
     * @return The department of the RegularEmployee.
     */
    public Department getDepartment() {
        return department;
    }
}
