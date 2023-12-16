import enums.Difficulty;
import enums.QuestionType;

import java.util.ArrayList;
import java.util.HashMap;
public class Question {
    private static int nextId = 1;
    protected String id;
    protected String body;
    protected String answer;
    protected enums.Difficulty difficulty;
    protected enums.QuestionType type;

    public Question(String body, String answer, Difficulty difficulty, QuestionType type) {
        this.id = String.valueOf(nextId);
        nextId++;
        this.body = body;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;
    }

    public Question(String id, String body, String answer, Difficulty difficulty, QuestionType type) {
        this.id = id;
        if (Integer.valueOf(id) >= nextId){
            nextId = Integer.valueOf(id) + 1;
        }
        this.body = body;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;
    }

    public String getId(){
        return this.id;
    }

    public String getBody() {
        return body;
    }

    public String getAnswer() {
        return answer;
    }

    public enums.Difficulty getDifficulty() {
        return difficulty;
    }

    public enums.QuestionType getType() {
        return type;
    }

    @Override
    public String toString(){
        return "id: " + this.id +
                "; " + this.getClass().getName() +
                "; difficulty: " + this.difficulty +
                "; body: " + this.body;
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
   }

    public String[] getOptions() {
        return options;
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
