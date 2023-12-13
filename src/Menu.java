import java.util.Scanner;

public class Menu {
    public static void showMainMenu() {
        System.out.println("Choose Role: ");
        System.out.println("1) Manager");
        System.out.println("2) Quiz Master");
        System.out.println("3) Regular Employee");
    }

    public static int getRoleChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static String getEmployeeId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        return scanner.nextLine();
    }

    public static void showAccessDenied() {
        System.out.println("Access Denied! Invalid ID or Role.");
    }

    public static void showManagerSubMenu(Manager manager) {
        System.out.println("Manager Menu:");
        System.out.println("1) Add Employee");
        System.out.println("2) Show all Employees");
        System.out.println("3) Show Employee's Quiz Status");
        System.out.println("4) Remove an Employee");
        System.out.println("5) Exit");
    }

    public static void showQuizMasterSubMenu(QuizMaster quizMaster) {
        System.out.println("Quiz Master Menu:");
        System.out.println("1) Create Question");
        System.out.println("2) Show all Questions");
        System.out.println("3) Remove a Question");
        System.out.println("4) Create Quiz");
        System.out.println("5) Show all Quizzes");
        System.out.println("6) Remove a Quiz");
        System.out.println("7) Exit");
    }

    public static void showRegularEmployeeSubMenu(RegularEmployee regularEmployee) {
        System.out.println("Regular Employee Menu:");
        System.out.println("1) Start a Quiz");
        System.out.println("2) See Previous Quiz Status");
        System.out.println("3) Exit");
    }
}