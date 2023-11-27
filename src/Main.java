import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //initialize program
        Company myCompany;
        try {
            myCompany = new Company();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //testing set a manager
        Manager m1 = new Manager("Johnny The Tester");
        myCompany.addEmployee(m1);

        //testing employee hiring
        Employee e1 = new QuizMaster("Jerry the QuizMaster");
        m1.hireEmployee(myCompany, e1);

        //show employees in list
        for (Employee e : myCompany.getEmployees()) {
            System.out.println(e.getName() + " " + e.getType());} //shows like this while toString() not implemented

        //Testing employee removal
        ArrayList<Employee> employeesList = myCompany.getEmployees();

        for (int i = 0; i < employeesList.size(); i++) {
            System.out.printf("[%d] - %s - %s\n", i, employeesList.get(i).getName(), employeesList.get(i).getType());
        }
        System.out.println("Select employee to remove: ");
        Scanner keyboard = new Scanner(System.in);
        int index = keyboard.nextInt();
        if (0 < index && index < myCompany.getEmployees().size()){
            m1.deleteEmployee(myCompany, index);
        } else{
            System.out.println("Out of index");
        }

        employeesList = myCompany.getEmployees();
        for (int i = 0; i < employeesList.size(); i++) {
            System.out.printf("[%d] - %s - %s\n", i, employeesList.get(i).getName(), employeesList.get(i).getType());
        }
    }




}