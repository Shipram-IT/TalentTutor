import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    //Fields
    private ArrayList<Employee> employeeList;
    private File employeeStorage = new File("employees.csv");

    //Constructor
    public Company() throws IOException {
        if(!employeeStorage.isFile() || employeeStorage.length() == 0){ //if not exists, create first manager and save into file
            System.out.print("Your company needs a manager. Please insert his name: ");
            String name = new Scanner(System.in).nextLine();
            Manager firstManager = new Manager(name);
            employeeList = new ArrayList<Employee>();
            this.employeeList.add(firstManager); //add to collection
            writeEmployeeList(employeeList); //calls the method to create a csv from scratch
        } else{
            this.employeeList = readEmployeeList(); //if exists read from file and store instances into employeeList
        }
    }

    /**
     * Check with id if comany contains the employee
     * @param id
     * @param employeeType
     * @return
     */
    public boolean containsEmployee(int id, Class<? extends Employee> employeeType) {
        for (Employee employee : employeeList) {
            if (employeeType.isInstance(employee) && employee.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //Methods
    /**
     * this method adds employees to the collection and saves it into the csv file.
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        writeEmployeeList(employee);
    }

    /**
     * this method removes the employee from the collection and saves the new list of employess into the csv file
     * @param employee
     */
    public void removeEmployee(Employee employee){
        employeeList.remove(employee);
        writeEmployeeList(employeeList); //call the method to override the csv file
    }

    /**
     * Method to return all employees in the collection
     * @return a list of employees that is stored in the instance of Company
     */
    public ArrayList<Employee> getEmployees() {
        return (ArrayList<Employee>) employeeList.clone(); //Cloning to not grant access to the internal collection
    }

    /**
     * Method to read the csv file and instantiate objects according to the data stored.
     * @return a list of employees that is stored in the instance of Company
     */
    public ArrayList<Employee> readEmployeeList() {
        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        String[] line;
        Scanner scanner = null;
        try {
            scanner = new Scanner(employeeStorage);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.nextLine();//ignores header and goes to the next line
        while (scanner.hasNext()) {
            line = scanner.nextLine().split(";");
            //System.out.println(line.length);
            String name = line[0];
            EmployeeType type = EmployeeType.valueOf(line[1]);
            Department department = null;
            if ((line.length > 2)){
                department = Department.valueOf(line[2]);
            }
            //call the constructor according to the type
            switch (type) {
                case MANAGER -> employeesList.add(new Manager(name));
                case QUIZ_MASTER -> employeesList.add(new QuizMaster(name));
                case REGULAR_EMPLOYEE -> employeesList.add(new RegularEmployee(name, department));
            }
        }
        return employeesList;
    }

    /**
     * this method overrides the whole employees.csv
     * this is going to be called when company is started without any employees or when an employee is removed
     * @param employeesList
     */
    public void writeEmployeeList(ArrayList<Employee> employeesList){
        try {
            FileWriter fileWriter = new FileWriter(employeeStorage);
            PrintWriter outputFile = new PrintWriter(fileWriter);
            outputFile.println("name;type;department");//HEADER
            for (Employee employee : employeesList) {
                outputFile.println(employee.toCsv());
            }
            outputFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to add employees to the csv, maintaining previous records.
     * @param employeeAdded
     */
    public void writeEmployeeList(Employee employeeAdded){
        try {
            FileWriter fileWriter = new FileWriter(employeeStorage, true);
            PrintWriter outputFile = new PrintWriter(fileWriter);
            outputFile.println(employeeAdded.toCsv());
            outputFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
