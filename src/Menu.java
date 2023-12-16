import java.util.ArrayList;
import java.util.Scanner;
import enums.Difficulty;
import enums.Topic;

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

    public static int chooseQuestionTypeChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Question Menu:");
        System.out.println("1) MCQ Question");
        System.out.println("2) Fill in the Blank Question");
        System.out.println("3) True/False Question");
        return scanner.nextInt();
    }

    public static String defineQuestionBody() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Question Body: ");
        return scanner.nextLine();
    }

    public static String defineQuestionAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Question Answer: ");
        return scanner.nextLine();
    }

    public static enums.Topic chooseQuestionTopic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Topic: ");
        System.out.println("1) LaborLaw");
        System.out.println("2) GenerativeAi");
        System.out.println("3) Cybersecurity");
        System.out.println("4) Ethics");
        System.out.println("5) Accounting");
        System.out.println("6) CustomerOrientation");
        System.out.print("Enter your choice or any other number to quit: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return enums.Topic.LaborLaw;
            case 2:
                return enums.Topic.GenerativeAi;
            case 3:
                return enums.Topic.Cybersecurity;
            case 4:
                return enums.Topic.Ethics;
            case 5:
                return enums.Topic.Accounting;
            case 6:
                return enums.Topic.CustomerOrientation;
            default:
                return null;
        }
    }

    public static enums.Difficulty setQuestionDifficulty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Question Difficulty: ");
        System.out.println("1) Easy");
        System.out.println("2) Medium");
        System.out.println("3) Hard");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return enums.Difficulty.EASY;
            case 2:
                return enums.Difficulty.MEDIUM;
            case 3:
                return enums.Difficulty.HARD;
            default:
                return Difficulty.EASY;
        }
    }

    public static ArrayList<String> setMCQOptions() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<>();

        System.out.println("Enter MCQ Options: ");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Option " + i + ": " );
            String option = scanner.nextLine();
            options.add(option);
        }

        return options;
    }

    protected static void showMenu(QuizMaster quizMaster, QuestionBank questionBank, QuizBank quizBank) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.showSubMenu(quizMaster);
            int choice = Menu.getRoleChoice();
            switch (choice) {
                case 1:
                    // Create Question
                    Menu.showCreateQuestionSubMenu(questionBank);
                    break;
                case 2:
                    // Show all Questions
                    questionBank.showQuestionList();
                    break;
                case 3:
                    // Remove a Question
                    questionBank.showQuestionList();
                    System.out.print("Enter the question ID you want to remove or enter 'q' to exit: ");
                    String questionId = scanner.nextLine();
                    if (questionId.equalsIgnoreCase("Q")){
                        break;
                    } else {
                        questionBank.removeQuestion(questionId);
                    }
                    break;
                case 4:
                    // Create Quiz
                    enums.Topic topic = chooseQuestionTopic();
                    enums.Difficulty difficulty = setQuestionDifficulty();
                    ArrayList<Question> questionByTopic = questionBank.getQuestion(topic, difficulty);
                    ArrayList<Question> selectedQuestions = new ArrayList<>();
                    for (Question question : questionByTopic) {
                        System.out.println(question);
                    }
                    while (true){
                        System.out.println("Enter the Id of the question you want to have in your quiz or enter -1 to finish");
                        Scanner keyboard = new Scanner(System.in);
                        String id = keyboard.nextLine();
                        if (id.equals("-1")){
                            break;
                        } else{
                            selectedQuestions.add(questionBank.getQuestionById(id));
                        }

                    }
                    if (!selectedQuestions.isEmpty()) {
                        try {
                            Quiz quiz = new Quiz(topic, difficulty, selectedQuestions);
                            System.out.println("Created quiz: " + quiz);
                            quizBank.addNewQuiz(quiz);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("No questions selected. Quiz creation aborted.");
                    }
                    break;
                case 5:
                    // Show all Quizzes
                    quizBank.showQuizzes();
                    break;
                case 6:
                    // Remove a Quiz
                    // Implement this based on your requirements
                    System.out.println("Enter Quiz Id of quiz you want to remove: ");
                    String quizId = scanner.nextLine();
                    quizBank.removeQuiz(quizId);
                    break;
                case 7:
                    System.out.println("Exiting Quiz Master Menu");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    private static void showCreateQuestionSubMenu(QuestionBank questionBank) {
        while (true) {
            enums.Topic topic = Menu.chooseQuestionTopic();
            if (topic == null){
                System.out.println("Exiting Create Question Menu");
                return;
            }
            String body = Menu.defineQuestionBody();
            enums.Difficulty difficulty = Menu.setQuestionDifficulty();
            String answer;
            int choice = Menu.chooseQuestionTypeChoice();
            switch (choice) {
                case 1:
                    ArrayList<String> options = Menu.setMCQOptions();
                    answer = Menu.defineQuestionAnswer();
                    questionBank.addQuestion(new MCQQuestion(body, answer, difficulty, options.toArray(new String[0]), topic));
                    break;
                case 2:
                    answer = Menu.defineQuestionAnswer();
                    questionBank.addQuestion(new FillInBlank(body, answer, difficulty, topic));
                    break;
                case 3:
                    answer = Menu.defineQuestionAnswer();
                    questionBank.addQuestion(new TrueFalse(body, answer, difficulty, topic));
                    break;

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