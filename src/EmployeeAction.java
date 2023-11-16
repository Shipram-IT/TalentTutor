import java.util.List;

/**
 * Interface for common actions by employees
 */
interface EmployeeAction {
    /**
     * Method to view quiz status
     *
     * @param employees List of employees
     */
    void viewQuizStatus(List<Employee> employees);
}