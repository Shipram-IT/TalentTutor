//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
//public class QuizBank {
//    private ArrayList<Quiz> quizzes;
//
//    public QuizBank(String name) {
//        this.quizzes = new ArrayList<>();
//        if (!csvFileExists()) {
//            System.out.println("No question records found. Add must questions to the bank.");
//        } else{
//            populateQuestionsFromCSV();
//        }
//    }
//
//
//    private static boolean csvFileExists() {
//        return new java.io.File("questionbank.csv").exists();
//    }
//
//    private void populateQuestionsFromCSV() {
//        if (csvFileExists()) {
//            String[] fields = {"id", "topic","body", "answer", "difficulty", "type", "option1", "option2", "option3", "option4"};
//            CsvIO csvIO = new CsvIO();
//            ArrayList<HashMap<String, String>> data = csvIO.readFromCSV("questionbank.csv", fields);
//            for (HashMap<String, String> entry : data) {
//                String id = entry.get("id");
//                enums.Topic topic = enums.Topic.valueOf(entry.get("topic"));
//                String body = entry.get("body");
//                String answer = entry.get("answer");
//                enums.Difficulty difficulty = enums.Difficulty.valueOf(entry.get("difficulty"));
//                enums.QuestionType type = enums.QuestionType.valueOf(entry.get("type"));
//                String[] options = new String[4];
//                for (int i = 1; i <= 4; i++) {
//                    options[i - 1] = entry.get("option" + i);
//                }
//                switch (type) {
//                    case MCQ:
//                        questions.add(new MCQQuestion(id, body, answer, difficulty, options, topic));
//                        break;
//                    case FillInBlank:
//                        questions.add(new FillInBlank(id, body, answer, difficulty, topic));
//                        break;
//                    case TrueFalse:
//                        questions.add(new TrueFalse(id, body, answer, difficulty, topic));
//                        break;
//                    // Add more cases for other types if needed
//                }
//            }
//        }
//    }
//
//    public Question getQuestionById(String id) {
//        for (Question question : questions) {
//            if (question.getId().equals(id)) {
//                return question;
//            }
//        }
//        return null;
//    }
//
//    public ArrayList<Question> getQuestion(enums.Topic topic, enums.Difficulty difficulty) {
//        ArrayList<Question> questionList = new ArrayList<>();
//        for (Question question : questions) {
//            if (question.getTopic().equals(topic) && question.getDifficulty().equals(difficulty)) {
//                questionList.add(question);
//            }
//        }
//        return questionList;
//    }
//
//    protected void addQuestion(Question question) {
//        questions.add(question);
//        updateCSV();
//        System.out.println("Question added successfully.");
//    }
//
//
//    public void showQuestionList() {
//        if (questions == null || questions.isEmpty()){
//            System.out.println("Question bank is empty, try to add some questions.");
//        }
//        else {
//            System.out.println("Question Bank:");
//            for (Question question : questions) {
//                System.out.println(question);
//            }
//        }
//    }
//
//    public ArrayList<Question> getQuestions() {
//        return this.questions;
//    }
//
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
//    }
//
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
//}