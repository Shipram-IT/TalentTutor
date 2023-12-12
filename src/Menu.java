import java.util.Scanner;

// Base class for Menu
public class Menu {
    protected Scanner scanner = new Scanner(System.in);
    protected Company company;

    public Menu(Company company) {
        this.company = company;
    }

    public void displayMenu() {
        System.out.println("1) MANAGER");
        System.out.println("2) QUIZMASTER");
        System.out.println("3) REGULAR EMPLOYEE");
        System.out.println("4) Exit program");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                ManagerMenu managerMenu = new ManagerMenu(company);
                managerMenu.displayMenu();
                break;
            case 2:
                QuizMasterMenu quizMasterMenu = new QuizMasterMenu(company);
                quizMasterMenu.displayMenu();
                break;
            case 3:
                RegularEmployeeMenu regularEmployeeMenu = new RegularEmployeeMenu(company);
                regularEmployeeMenu.displayMenu();
                break;
            case 4:
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

// ManagerMenu class
class ManagerMenu extends Menu {
    public ManagerMenu(Company company) {
        super(company);
    }

    public void displayMenu() {
        System.out.println("MANAGER MENU");
        System.out.println("Enter Employee ID:");
        int employeeId = scanner.nextInt();

        if (company.containsEmployee(employeeId, Manager.class)) {
            System.out.println("Access granted for Manager with ID " + employeeId);
            ManagerSubMenu managerSubMenu = new ManagerSubMenu();
            managerSubMenu.displayMenu();
        } else {
            System.out.println("Invalid Manager ID. Access denied.");
        }
    }
}

// ManagerSubMenu class
class ManagerSubMenu {
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Create Employee");
        System.out.println("2) Show Employees");
        System.out.println("3) Show Quiz Status of Employee");
        System.out.println("4) Remove Employee");
        System.out.println("5) Exit");

        int choice = scanner.nextInt();

        // Implement the submenu logic based on the user's choice
        // Add corresponding methods or call relevant classes
        switch (choice) {
            case 1:
                // Implement create employee logic
                break;
            case 2:
                // Implement show employees logic
                break;
            case 3:
                // Implement show quiz status of employee logic
                break;
            case 4:
                // Implement remove employee logic
                break;
            case 5:
                System.out.println("Exiting Manager SubMenu");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

// QuizMasterMenu class
class QuizMasterMenu extends Menu {
    public QuizMasterMenu(Company company) {
        super(company);
    }

    public void displayMenu() {
        System.out.println("QUIZMASTER MENU");
        System.out.println("Enter Employee ID:");
        int employeeId = scanner.nextInt();

        if (company.containsEmployee(employeeId, QuizMaster.class)) {
            System.out.println("Access granted for QuizMaster with ID " + employeeId);
            QuizMasterSubMenu quizMasterSubMenu = new QuizMasterSubMenu();
            quizMasterSubMenu.displayMenu();
        } else {
            System.out.println("Invalid QuizMaster ID. Access denied.");
        }
    }
}

// QuizMasterSubMenu class
class QuizMasterSubMenu {
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Create Question");
        System.out.println("2) Show all Questions");
        System.out.println("3) Edit Question");
        System.out.println("4) Remove Question");
        System.out.println("5) Exit");

        int choice = scanner.nextInt();

        // Implement the submenu logic based on the user's choice
        // Add corresponding methods or call relevant classes
        switch (choice) {
            case 1:
                // Implement create question logic
                break;
            case 2:
                // Implement show all questions logic
                break;
            case 3:
                // Implement edit question logic
                break;
            case 4:
                // Implement remove question logic
                break;
            case 5:
                System.out.println("Exiting QuizMaster SubMenu");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

// RegularEmployeeMenu class
class RegularEmployeeMenu extends Menu {
    public RegularEmployeeMenu(Company company) {
        super(company);
    }

    public void displayMenu() {
        System.out.println("REGULAR EMPLOYEE MENU");
        System.out.println("Enter Employee ID:");
        int employeeId = scanner.nextInt();

        if (company.containsEmployee(employeeId, RegularEmployee.class)) {
            System.out.println("Access granted for Regular Employee with ID " + employeeId);
            RegularEmployeeSubMenu regularEmployeeSubMenu = new RegularEmployeeSubMenu();
            regularEmployeeSubMenu.displayMenu();
        } else {
            System.out.println("Invalid Regular Employee ID. Access denied.");
        }
    }
}

// RegularEmployeeSubMenu class
class RegularEmployeeSubMenu {
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Start Quiz");
        System.out.println("2) Show all quiz history");
        System.out.println("3) Exit");

        int choice = scanner.nextInt();

        // Implement the submenu logic based on the user's choice
        // Add corresponding methods or call relevant classes
        switch (choice) {
            case 1:
                // Implement start quiz logic
                break;
            case 2:
                // Implement show quiz history logic
                break;
            case 3:
                System.out.println("Exiting Regular Employee SubMenu");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}