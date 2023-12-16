import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class QuizBank {
    private ArrayList<Quiz> quizzes;

    public QuizBank(QuestionBank questionBank) {
        this.quizzes = new ArrayList<>();
        File[] files = CsvIO.loadFiles("csv/quiz");
        if (files == null) {
            System.out.println("No quiz records found. Add must quizzed to the bank.");
        } else{
            for (File f : files){
                populateQuestionsFromCSV(f, questionBank);
            }
        }
    }

    private void populateQuestionsFromCSV(File file, QuestionBank questionBank) {
        String[] fields = {"questionId"};
        //file structure [quizID_subject_difficulty]
        String[] fileNameParts = file.toString().replace(".csv", "").replace("csv\\quiz\\","").split("_");
        //System.out.println(fileNameParts[0] +
        //        " " + enums.Topic.valueOf(fileNameParts[1]) +
        //        " " +  enums.Difficulty.valueOf(fileNameParts[2]));
        CsvIO csvIO = new CsvIO();
        ArrayList<HashMap<String, String>> data = csvIO.readFromCSV(file.getAbsolutePath(), fields);
        ArrayList<Question> questionsInQuiz = new ArrayList<>();
        for (HashMap<String, String> entry : data) {
            String questionId = entry.get("questionId");
            Question question = questionBank.getQuestionById(questionId);
            // Check if the question is not null and matches the topic and difficulty
            if (question != null && question.getTopic().equals(enums.Topic.valueOf(fileNameParts[1]))
                    && question.getDifficulty().equals(enums.Difficulty.valueOf(fileNameParts[2]))) {
                questionsInQuiz.add(question);
            } else {
                System.out.println("Error: Question with ID " + questionId + " does not match the specified topic and difficulty.");
            }
        }
        quizzes.add(new
                Quiz(fileNameParts[0],
                enums.Topic.valueOf(fileNameParts[1]),
                enums.Difficulty.valueOf(fileNameParts[2]),
                questionsInQuiz));
    }
    public void showQuizzes() {
        for (Quiz q : quizzes) {
            System.out.println(q);
        }
    }


//    private void updateCSV() {
//        // Rewrite the CSV file with the updated question list
//        CsvIO csvIO = new CsvIO();
//        String[] titles = {"id", "topic","body", "answer", "difficulty", "type", "option1", "option2", "option3", "option4"};
//        ArrayList<HashMap<String, String>> data = new ArrayList<>();
//        for (Question question : questions) {
//            LinkedHashMap<String, String> entry = new LinkedHashMap<>();
//            entry.put("id", question.getId());
//            entry.put("topic", question.getTopic().name());
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
//                entry.put("option1", "-");
//                entry.put("option2", "-");
//                entry.put("option3", "-");
//                entry.put("option4", "-");
//            }
//            data.add(entry);
//        }
//        csvIO.overwrite("questionbank.csv", titles, data);
//    }
}