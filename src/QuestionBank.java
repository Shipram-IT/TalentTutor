import enums.Difficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class QuestionBank {
    private static ArrayList<Question> questions;

    public QuestionBank() {
        this.questions = new ArrayList<>();

        if (!csvFileExists()) {
            System.out.println("No question records found. Add questions to the bank.");
            // You can add some default questions here if needed
        }
        populateQuestionsFromCSV();
//        showQuestionList();
    }

    private static boolean csvFileExists() {
        // Assuming your CSV file for questions is named "questions.csv"
        return new java.io.File("questionbank.csv").exists();
    }

    private static void populateQuestionsFromCSV() {
        if (csvFileExists()) {
            String[] fields = {"id", "body", "answer", "difficulty", "type", "option1", "option2", "option3", "option4"};
            CsvIO csvIO = new CsvIO();
            ArrayList<HashMap<String, String>> data = csvIO.readFromCSV("questionbank.csv", fields);
            questions = Question.populateQuestions(data);
        }
    }

//    public Question getQuestionById(String id) {
//        for (Question question : questions) {
//            if (question.getId().equals(id)) {
//                return question;
//            }
//        }
//        return null;
//    }

//    protected void addQuestion(Question question) {
//        questions.add(question);
//        updateCSV();
//        System.out.println("Question added successfully.");
//    }

    public static void showQuestionList() {
        populateQuestionsFromCSV();
        System.out.println("Question Bank:");
        for (Question question : questions) {
            System.out.println(question);
        }
        System.out.println();
    }
//
//    public ArrayList<Question> getQuestions() {
//        return this.questions;
//    }

//    public void removeQuestion(String id) {
//        Question questionToRemove = getQuestionById(id);
//
//        if (questionToRemove != null) {
//            questions.remove(questionToRemove);
//            updateCSV();
//            System.out.println("Question with ID " + id + " removed successfully.");
//        } else {
//            System.out.println("Question with ID " + id + " not found.");
//        }
//        populateQuestionsFromCSV();
//    }

//    private void updateCSV() {
//        // Rewrite the CSV file with the updated question list
//        CsvIO csvIO = new CsvIO();
//        String[] titles = {"id", "body", "answer", "difficulty", "type", "option1", "option2", "option3", "option4"};
//        ArrayList<HashMap<String, String>> data = new ArrayList<>();
//        for (Question question : questions) {
//            LinkedHashMap<String, String> entry = new LinkedHashMap<>();
//            entry.put("id", question.getId());
//            entry.put("body", question.getBody());
//            entry.put("answer", question.getAnswer());
//            entry.put("difficulty", question.getDifficulty().name());
//            entry.put("type", question.getType().name());
//
//            if (question instanceof MCQQuestion) {
//                String[] options = ((MCQQuestion) question).getOptions();
//                entry.put("option1", options[0]);
//                entry.put("option2", options[1]);
//                entry.put("option3", options[2]);
//                entry.put("option4", options[3]);
//            } else {
//                // Handle other question types if needed
//            }
//
//            data.add(entry);
//        }
//        csvIO.overwrite("questions.csv", titles, data);
//    }

    public static void createMCQQuestion(Company company) {
        String body = Menu.getQuestionBody();
        String answer = Menu.getQuestionAnswer();
        Difficulty difficulty = Menu.getQuestionDifficulty();
        ArrayList<String> options = Menu.getMCQOptions();

        // Create an MCQ Question object and do something with it
        MCQQuestion mcqQuestion = new MCQQuestion(body, answer, difficulty, options.toArray(new String[0]));
    }

    public static void createFillInTheBlankQuestion(Company company) {
        String body = Menu.getQuestionBody();
        String answer = Menu.getQuestionAnswer();
        Difficulty difficulty = Menu.getQuestionDifficulty();

        // Create a Fill in the Blank Question object and do something with it
        FillInBlank fillInBlank = new FillInBlank(body, answer, difficulty);
    }

    public static void createTrueFalseQuestion(Company company) {
        String body = Menu.getQuestionBody();
        String answer = Menu.getQuestionAnswer();
        Difficulty difficulty = Menu.getQuestionDifficulty();

        // Create a True/False Question object and do something with it
        TrueFalse trueFalse = new TrueFalse(body, answer, difficulty);
    }
}
