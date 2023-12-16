import enums.Topic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                populateDataFromCSV(f, questionBank);
            }
        }
    }

    private void populateDataFromCSV(File file, QuestionBank questionBank) {
        String[] fields = {"questionId"};
        String[] fileNameParts = file.toString().replace(".csv", "").replace("csv\\quiz\\","").split("_");
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

    public void showFilteredQuizzes(Topic topic) {
        for (Quiz q : quizzes) {
            if (q.getTopic() == topic) {
                System.out.println(q);
            }
        }
    }

    public Quiz getQuizById(String quizId) {
        for (Quiz quiz : quizzes) {
            if (quiz.getId().equals(quizId)) {
                return quiz;
            }
        }
        return null; // Quiz with the given ID not found
    }

    public void addNewQuiz(Quiz quiz){
        quizzes.add(quiz);
        updateCSV(quiz);
    }

    private void updateCSV(Quiz quiz) {
            // Create the CSV file path based on quiz ID, topic, and difficulty
            String filePath = "csv/quiz/" + quiz.getId() + "_" + quiz.getTopic().name() + "_" + quiz.getDifficulty().name() + ".csv";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Write the header
                //System.out.println(quiz.getQuestions());
                writer.write("questionId;");
                writer.newLine();
                // Write each question ID to the CSV file
                for (Question question : quiz.getQuestions()) {
                    writer.write(question.getId() + ";");
                    writer.newLine();
                }

                System.out.println("Quiz saved to " + filePath + " successfully!");
            } catch (IOException e) {
                System.out.println("Error saving quiz to CSV: " + e.getMessage());
            }
    }
}