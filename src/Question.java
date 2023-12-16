import enums.Difficulty;
import enums.QuestionType;

import java.util.ArrayList;
import java.util.HashMap;
public class Question {
    protected String id;
    protected String body;
    protected String answer;
    protected Difficulty difficulty;
    protected QuestionType type;
    protected String[] titles;
    protected String[] values;

    public Question(String body, String answer, Difficulty difficulty, QuestionType type) {
        this.id = "0";
        this.body = body;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;

        this.titles = new String[]{"id", "body", "answer", "difficulty", "type"};
        this.values = new String[]{id, body, answer, difficulty.name(), type.name()};



        // Add employee data to CSV file
        CsvIO csvIO = new CsvIO();
        csvIO.writeToCSV("questionbank.csv", titles, values);
    }

    public Question(String id, String body, String answer, Difficulty difficulty, QuestionType type) {
        this.id = id;
        this.body = body;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;
    }
    public static class QuestionPopulator {

        public static ArrayList<Question> populateQuestions(ArrayList<HashMap<String, String>> data) {
            ArrayList<Question> questions = new ArrayList<>();

            for (HashMap<String, String> entry : data) {
                String id = entry.get("id");
                String body = entry.get("body");
                String answer = entry.get("answer");
                Difficulty difficulty = Difficulty.valueOf(entry.get("difficulty"));
                QuestionType type = QuestionType.valueOf(entry.get("type"));

                switch (type) {
                    case MCQ:
                        String[] options = entry.get("options").split(",");
                        questions.add(new MCQQuestion(id, body, answer, difficulty, options));
                        break;
                    case FillInBlank:
                        questions.add(new FillInBlank(id, body, answer, difficulty));
                        break;
                    case TrueFalse:
                        questions.add(new TrueFalse(id, body, answer, difficulty));
                        break;
                    // Add more cases for other types if needed
                }
            }

            return questions;
        }
    }
}
class MCQQuestion extends Question {
    protected String[] options = new String[4];

    public MCQQuestion(String body, String answer, Difficulty difficulty, String[] options) {
        super(body, answer, difficulty, QuestionType.MCQ);
        this.options = options;
    }

    public MCQQuestion(String id, String body, String answer, Difficulty difficulty, String[] options) {
        super(id, body, answer, difficulty, QuestionType.MCQ);
        this.options = options;
        this.titles = new String[]{"id", "body", "answer", "difficulty", "option1", "option2", "option3", "option4"};
        this.values = new String[]{id, body, answer, difficulty.name(), options[0], options[1], options[2], options[3]};
    }
}
class FillInBlank extends Question{
    public FillInBlank(String body, String answer, Difficulty difficulty) {
        super(body, answer, difficulty, QuestionType.FillInBlank);
    }

    public FillInBlank(String id, String body, String answer, Difficulty difficulty) {
        super(id, body, answer, difficulty, QuestionType.FillInBlank);
    }
}
class TrueFalse extends Question{
    public TrueFalse(String body, String answer, Difficulty difficulty) {
        super(body, answer, difficulty, QuestionType.TrueFalse);
    }

    public TrueFalse(String id, String body, String answer, Difficulty difficulty) {
        super(id, body, answer, difficulty, QuestionType.TrueFalse);
    }
}
