
public class Main {
    public static void main(String[] args) {
        // Create a company and show the employee list
        Company company = new Company("MyCompany");

        while (true){
            // Get user input for role and ID
            Menu.showMainMenu();
            int roleChoice = Menu.getRoleChoice();
            String employeeId = Menu.getEmployeeId();

            // Access the submenu based on role and ID
            Employee employee = company.getEmployeeById(employeeId);
            if (employee != null) {
                switch (roleChoice) {
                    case 1:
                        if (employee instanceof Manager) {
                            Manager manager = (Manager) employee;
                            System.out.println("You are now Manager: " + manager.name);
                            showManagerMenu(manager);
                        } else {
                            Menu.showAccessDenied();
                        }
                        break;
                    case 2:
                        if (employee instanceof QuizMaster) {
                            QuizMaster quizMaster = (QuizMaster) employee;
                            System.out.println("You are now Quiz Master: " + quizMaster.name);
                            showQuizMasterMenu(quizMaster);
                        } else {
                            Menu.showAccessDenied();
                        }
                        break;
                    case 3:
                        if (employee instanceof RegularEmployee) {
                            RegularEmployee regularEmployee = (RegularEmployee) employee;
                            System.out.println("You are now Regular Employee: " + regularEmployee.name);
                            showRegularEmployeeMenu(regularEmployee);
                        } else {
                            Menu.showAccessDenied();
                        }
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            } else {
                Menu.showAccessDenied();
            }
        }
    }

    private static void showManagerMenu(Manager manager) {
        while (true) {
            Menu.showManagerSubMenu(manager);
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

    private static void showQuizMasterMenu(QuizMaster quizMaster) {
        while (true) {
            Menu.showQuizMasterSubMenu(quizMaster);
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

    private static void showRegularEmployeeMenu(RegularEmployee regularEmployee) {
        while (true) {
            Menu.showRegularEmployeeSubMenu(regularEmployee);
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

