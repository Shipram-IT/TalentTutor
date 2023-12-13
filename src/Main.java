
public class Main {
    public static void main(String[] args) {
        // Create a company and show the employee list
        Company company = new Company("MyCompany");

        while (true){
            String employeeId = Menu.getEmployeeId();
            if (employeeId.equalsIgnoreCase("Q")){
                System.out.println("Thanks for accessing TalentTutor. Program closing...");
                break;
            }
            Employee employee = company.getEmployeeById(employeeId);
            if (employee != null) {
                String employeeType = employee.getClass().getName();
                System.out.printf("Welcome, %s (%s)\n", employee.name, employeeType);
                if (employeeType.equals("Manager")) {
                    Manager manager = (Manager) employee;
                    showMenu(manager);
                }
                else if (employeeType.equals("QuizMaster")) {
                    QuizMaster quizMaster = (QuizMaster) employee;
                    showMenu(quizMaster);
                }
                else if (employeeType.equals("RegularEmployee")) {
                    RegularEmployee regularEmployee = (RegularEmployee) employee;
                    showMenu(regularEmployee);
                }
                else{
                    System.out.println("Error");
                }
            } else {
                Menu.showAccessDenied();
            }
        }

    }

    private static void showMenu(Manager manager) {
        while (true) {
            Menu.showSubMenu(manager);
            int choice = Menu.getRoleChoice();
            switch (choice) {
                case 1:
                    // Add Employee
                    // Implement this based on your requirements
                    break;
                case 2:
                    // Show all Employees
                    // Implement this based on your requirements
                    break;
                case 3:
                    // Show Employee's Quiz Status
                    // Implement this based on your requirements
                    break;
                case 4:
                    // Remove an Employee
                    // Implement this based on your requirements
                    break;
                case 5:
                    System.out.println("Exiting Manager Menu");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void showMenu(QuizMaster quizMaster) {
        while (true) {
            Menu.showSubMenu(quizMaster);
            int choice = Menu.getRoleChoice();
            switch (choice) {
                case 1:
                    // Create Question
                    // Implement this based on your requirements
                    break;
                case 2:
                    // Show all Questions
                    // Implement this based on your requirements
                    break;
                case 3:
                    // Remove a Question
                    // Implement this based on your requirements
                    break;
                case 4:
                    // Create Quiz
                    // Implement this based on your requirements
                    break;
                case 5:
                    // Show all Quizzes
                    // Implement this based on your requirements
                    break;
                case 6:
                    // Remove a Quiz
                    // Implement this based on your requirements
                    break;
                case 7:
                    System.out.println("Exiting Quiz Master Menu");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void showMenu(RegularEmployee regularEmployee) {
        while (true) {
            Menu.showSubMenu(regularEmployee);
            int choice = Menu.getRoleChoice();
            switch (choice) {
                case 1:
                    // Start a Quiz
                    // Implement this based on your requirements
                    break;
                case 2:
                    // See Previous Quiz Status
                    // Implement this based on your requirements
                    break;
                case 3:
                    System.out.println("Exiting Regular Employee Menu");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}