import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class QuestionBank {
    private String name;
    private ArrayList<Question> questions;

    public QuestionBank(String name) {
        this.name = name;
        this.questions = new ArrayList<>();

        if (!csvFileExists()) {
            System.out.println("No question records found. Add questions to the bank.");
            // You can add some default questions here if needed
        }
        populateQuestionsFromCSV();
//        showQuestionList();
    }

    private boolean csvFileExists() {
        // Assuming your CSV file for questions is named "questions.csv"
        return new java.io.File("questions.csv").exists();
    }

    private void populateQuestionsFromCSV() {
        if (csvFileExists()) {
            String[] fields = {"id", "body", "answer", "difficulty", "type", "option1", "option2", "option3", "option4"};
            CsvIO csvIO = new CsvIO();
            ArrayList<HashMap<String, String>> data = csvIO.readFromCSV("questions.csv", fields);
            questions = Question.populateQuestions(data);
        }
    }

    public Question getQuestionById(String id) {
        for (Question question : questions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }

    protected void addQuestion(Question question) {
        questions.add(question);
        updateCSV();
        System.out.println("Question added successfully.");
    }

    public void showQuestionList() {
        populateQuestionsFromCSV();
        System.out.println("Question Bank - " + name + ":");
        for (Question question : questions) {
            System.out.println(question);
        }
        System.out.println();
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public void removeQuestion(String id) {
        Question questionToRemove = getQuestionById(id);

        if (questionToRemove != null) {
            questions.remove(questionToRemove);
            updateCSV();
            System.out.println("Question with ID " + id + " removed successfully.");
        } else {
            System.out.println("Question with ID " + id + " not found.");
        }
        populateQuestionsFromCSV();
    }

    private void updateCSV() {
        // Rewrite the CSV file with the updated question list
        CsvIO csvIO = new CsvIO();
        String[] titles = {"id", "body", "answer", "difficulty", "type", "option1", "option2", "option3", "option4"};
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        for (Question question : questions) {
            LinkedHashMap<String, String> entry = new LinkedHashMap<>();
            entry.put("id", question.getId());
            entry.put("body", question.getBody());
            entry.put("answer", question.getAnswer());
            entry.put("difficulty", question.getDifficulty().name());
            entry.put("type", question.getType().name());

            if (question instanceof MCQQuestion) {
                String[] options = ((MCQQuestion) question).getOptions();
                entry.put("option1", options[0]);
                entry.put("option2", options[1]);
                entry.put("option3", options[2]);
                entry.put("option4", options[3]);
            } else {
                // Handle other question types if needed
            }

            data.add(entry);
        }
        csvIO.overwrite("questions.csv", titles, data);
    }
}
