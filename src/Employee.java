import enums.EmployeeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Employee {
    protected String id;
    protected String name;
    protected EmployeeType type;

    public Employee(String name, EmployeeType type) {
        this.id = "0";
        this.name = name;
        this.type = type;

        // Add employee data to CSV file
        CsvIO csvIO = new CsvIO();
        String[] titles = {"id", "name", "type"};
        String[] values = {id, name, type.name()};
        csvIO.writeToCSV("employee.csv", titles, values);
    }
    public Employee(String  id, String name, EmployeeType type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public static ArrayList<Employee> populateEmployees(ArrayList<HashMap<String, String>> data) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (HashMap<String, String> entry : data) {
            String id = entry.get("id");
            String name = entry.get("name");
            EmployeeType type = EmployeeType.valueOf(entry.get("type"));

            switch (type) {
                case MANAGER:
                    employees.add(new Manager(id, name));
                    break;
                case QUIZ_MASTER:
                    employees.add(new QuizMaster(id, name));
                    break;
                case REGULAR_EMPLOYEE:
                    employees.add(new RegularEmployee(id, name));
                    break;
                // Add more cases for other types if needed
            }
        }

        return employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

class Manager extends Employee {
    public Manager(String name) {
        super(name, EmployeeType.MANAGER);
    }
    public Manager(String id, String name) {
        super(id, name, EmployeeType.MANAGER);
    }
}

class QuizMaster extends Employee {
    public QuizMaster(String name) {
        super(name, EmployeeType.QUIZ_MASTER);
    }
    public QuizMaster(String id, String name) {
        super(id, name, EmployeeType.QUIZ_MASTER);
    }
}

class RegularEmployee extends Employee {

    ArrayList<QuizAttempt> quizAttempts;

    public RegularEmployee(String name) {
        super(name, EmployeeType.REGULAR_EMPLOYEE);
        this.quizAttempts = new ArrayList<>();
    }
    public RegularEmployee(String id, String name) {
        super(id, name, EmployeeType.REGULAR_EMPLOYEE);
        this.quizAttempts = new ArrayList<>();
    }
    public void addQuizAttempt(QuizAttempt quizAttempt){
        this.quizAttempts.add(quizAttempt);
    }

    public ArrayList<QuizAttempt> getQuizAttempts(){
        return this.quizAttempts;
    }

    public void startQuiz(Quiz quiz) {
        if (quiz == null) {
            System.out.println("Invalid quiz. Cannot start quiz.");
            return;
        }

        // Display quiz details
        System.out.println("Starting Quiz: " + quiz.getId());
        System.out.println("Topic: " + quiz.getTopic());
        System.out.println("Difficulty: " + quiz.getDifficulty());

        int currentQuestionIndex = 0;
        int userScore = 0;

        while (currentQuestionIndex < quiz.getQuestions().size()) {
            // Get the current question
            Question question = quiz.getQuestions().get(currentQuestionIndex);

            // Display the question
            System.out.println("Question: " + question.getBody());

            // Check the type of question and handle accordingly
            if (question instanceof MCQQuestion) {
                userScore += handleMCQQuestion((MCQQuestion) question);
            } else if (question instanceof FillInBlank) {
                userScore += handleFillInBlank((FillInBlank) question);
            } else if (question instanceof TrueFalse) {
                userScore += handleTrueFalse((TrueFalse) question);
            }

            // Prompt user to save and quit or proceed to the next question
            System.out.print("Enter 's' to save and quit, or any other key to proceed to the next question: ");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("s")) {
                saveQuizProgress(quiz, currentQuestionIndex, userScore, false);
                System.out.println("Quiz progress and score saved. You can resume later.");
                return;
            }

            // Move to the next question
            currentQuestionIndex++;
        }

        System.out.println("Quiz completed! Your final score: " + userScore);
        saveQuizProgress(quiz, currentQuestionIndex, userScore, true);
    }

    private void saveQuizProgress(Quiz quiz, int currentQuestionIndex, int userScore, boolean isCompleted) {
        // Implement logic to save quiz progress and user score to a file or database
        // This is a placeholder and you should customize it based on your storage mechanism

        System.out.println("Saving quiz progress and score...");

        // Example: Save the quiz ID, index of the current question, and user score
        // You may want to use a more sophisticated method to save and retrieve progress and scores
        String[] savedProgress = {this.id,
                quiz.getId(),
                Integer.toString(currentQuestionIndex),
                Integer.toString(userScore),
                Boolean.toString(isCompleted)
        };
        String[] header = {"Employee ID", "Quiz ID", "Question Index", "Score", "Is Completed"};

        // Save to a file
        CsvIO.writeToCSV("csv/quizAttempt/quizProgress.csv", header, savedProgress);
    }

    private int handleMCQQuestion(MCQQuestion mcqQuestion) {
        // Display options for MCQ questions
        System.out.println("Options:");
        for (int i = 0; i < mcqQuestion.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + mcqQuestion.getOptions()[i]);
        }

        // Get the employee's answer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();

        // Check if the answer is correct
        if (mcqQuestion.checkAnswer(userAnswer)) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is: " + mcqQuestion.getAnswer());
            return 0;
        }
    }

    private int handleFillInBlank(FillInBlank fillInBlank) {
        // Get the employee's answer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();

        // Check if the answer is correct
        if (fillInBlank.checkAnswer(userAnswer)) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is: " + fillInBlank.getAnswer());
            return 0;
        }
    }

    private int handleTrueFalse(TrueFalse trueFalse) {
        // Display options for True/False questions
        System.out.println("Options: True or False");

        // Get the employee's answer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison

        // Check if the answer is correct
        if (trueFalse.checkAnswer(userAnswer)) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is: " + trueFalse.getAnswer());
            return 0;
        }
    }

}