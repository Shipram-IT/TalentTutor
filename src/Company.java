import java.util.ArrayList;

public class Company {
    //Fields
    private ArrayList<Employee> employeeList;

    //Constructor
    public Company(){
        this.employeeList = new ArrayList<Employee>();
    }

    //Methods
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

}
