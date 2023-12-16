import java.util.ArrayList;
import java.util.Scanner;
import enums.Difficulty;

public class Menu {

    public static int getRoleChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static String getEmployeeId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID or enter 'q' to end the program: ");
        return scanner.nextLine();
    }

    public static void showAccessDenied() {
        System.out.println("Access Denied! Invalid option entered.");
    }

    public static void showReturnMessage(){
        System.out.println("Returning to previous menu...");
    }

    public static void showSubMenu(Manager manager) {
        System.out.println("Manager Menu:");
        System.out.println("1) Add Employee");
        System.out.println("2) Show all Employees");
        System.out.println("3) Show Employee's Quiz Status");
        System.out.println("4) Remove an Employee");
        System.out.println("5) Exit");
    }

    public static void showSubMenu(QuizMaster quizMaster) {
        System.out.println("Quiz Master Menu:");
        System.out.println("1) Create Question");
        System.out.println("2) Show all Questions");
        System.out.println("3) Remove a Question");
        System.out.println("4) Create Quiz");
        System.out.println("5) Show all Quizzes");
        System.out.println("6) Remove a Quiz");
        System.out.println("7) Exit");
    }

    public static void showSubMenu(RegularEmployee regularEmployee) {
        System.out.println("Regular Employee Menu:");
        System.out.println("1) Start a Quiz");
        System.out.println("2) See Previous Quiz Status");
        System.out.println("3) Exit");
    }

    protected static void showMenu(Company company, Manager manager) {
        while (true) {
            Menu.showSubMenu(manager);
            int choice = Menu.getRoleChoice();
            switch (choice) {
                case 1:
                    //Add Employee
                    System.out.println("Enter employee type:\n" +
                            "1) Manager\n" +
                            "2) Quiz Master\n" +
                            "3) Regular Employee\n" +
                            "4) Exit");
                    int innerChoice = Menu.getRoleChoice();
                    switch (innerChoice){
                        case 1:
                            company.createEmployee("manager");
                            break;
                        case 2:
                            company.createEmployee("quizmaster");
                            break;
                        case 3:
                            company.createEmployee("regularemployee");
                            break;
                        case 4:
                            showReturnMessage();
                            break;
                        default:
                            Menu.showAccessDenied();
                    }

                    break;
                case 2:
                    // Show all Employees
                    company.showEmployeeList();
                    break;
                case 3:
                    // Show Employee's Quiz Status
                    // Implement this based on your requirements
                    break;
                case 4:
                    // Remove an Employee
                    company.showEmployeeList();
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter employee ID to remove or enter 'q' to exit: ");
                    String delEmployeeID = scanner.nextLine();
                    if (delEmployeeID.equalsIgnoreCase("Q")){
                        break;
                    } else if (delEmployeeID.equalsIgnoreCase(manager.id)) {
                        System.out.println("You cannot remove your own registry");
                        break;
                    } else {
                        company.removeEmployee(delEmployeeID);
                    }
                    break;
                case 5:
                    System.out.println("Exiting Manager Menu");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static int getQuestionTypeChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Question Menu:");
        System.out.println("1) MCQ Question");
        System.out.println("2) Fill in the Blank Question");
        System.out.println("3) True/False Question");
        System.out.println("4) Exit");
        return scanner.nextInt();
    }

    public static String getQuestionBody() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Question Body: ");
        return scanner.nextLine();
    }

    public static String getQuestionAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Question Answer: ");
        return scanner.nextLine();
    }

    public static Difficulty getQuestionDifficulty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Question Difficulty: ");
        System.out.println("1) Easy");
        System.out.println("2) Medium");
        System.out.println("3) Hard");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return Difficulty.EASY;
            case 2:
                return Difficulty.MEDIUM;
            case 3:
                return Difficulty.HARD;
            default:
                return Difficulty.EASY;
        }
    }

    public static ArrayList<String> getMCQOptions() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<>();

        System.out.println("Enter MCQ Options (Enter 'done' when finished): ");
        while (true) {
            String option = scanner.nextLine();
            if (option.equals("done")) {
                break;
            }
            options.add(option);
        }

        return options;
    }

    protected static void showMenu(Company company, QuizMaster quizMaster) {
        while (true) {
            Menu.showSubMenu(quizMaster);
            int choice = Menu.getRoleChoice();
            switch (choice) {
                case 1:
                    // Create Question
                    Menu.showCreateQuestionSubMenu(company);
                    // Implement this based on your requirements
                    break;
                case 2:
                    // Show all Questions
                    // Implement this based on your requirements
                    QuestionBank.showQuestionList();
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
    private static void showCreateQuestionSubMenu(Company company) {
        while (true) {


            int choice = Menu.getQuestionTypeChoice();
            switch (choice) {
                case 1:
                    QuestionBank.createMCQQuestion(company);
                    break;
                case 2:
                    QuestionBank.createFillInTheBlankQuestion(company);
                    break;
                case 3:
                    QuestionBank.createTrueFalseQuestion(company);
                    break;
                case 4:
                    System.out.println("Exiting Create Question Menu");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }


    protected static void showMenu(Company company, RegularEmployee regularEmployee) {
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