import enums.Difficulty;
import enums.QuestionType;
import enums.Topic;

import java.util.ArrayList;
import java.util.HashMap;
public abstract class Question {
    private static int nextId = 1;
    protected String id;
    protected String body;
    protected String answer;
    protected enums.Topic topic;
    protected enums.Difficulty difficulty;
    protected enums.QuestionType type;

    public Question(String body, String answer, Difficulty difficulty, QuestionType type, enums.Topic topic) {
        this.id = String.valueOf(nextId);
        nextId++;
        this.body = body;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;
        this.topic = topic;
    }

    public Question(String id, String body, String answer, Difficulty difficulty, QuestionType type, enums.Topic topic ) {
        this.id = id;
        if (Integer.valueOf(id) >= nextId){
            nextId = Integer.valueOf(id) + 1;
        }
        this.body = body;
        this.answer = answer;
        this.difficulty = difficulty;
        this.type = type;
        this.topic = topic;
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

    public boolean checkAnswer(String answer) {
        return this.answer.toLowerCase().equals(answer);
    }

    public enums.Difficulty getDifficulty() {
        return difficulty;
    }

    public enums.QuestionType getType() {
        return type;
    }

    public enums.Topic getTopic(){
        return topic;
    }

    @Override
    public String toString(){
        return "id: " + this.id +
                "; topic: " + this.topic +
                "; " + this.getClass().getName() +
                "; difficulty: " + this.difficulty +
                "; body: " + this.body;
    }
}
class MCQQuestion extends Question {
    protected String[] options = new String[4];

    public MCQQuestion(String body, String answer, enums.Difficulty difficulty, String[] options, enums.Topic topic ) {
        super(body, answer, difficulty, QuestionType.MCQ, topic);
        this.options = options;
    }

    public MCQQuestion(String id, String body, String answer, Difficulty difficulty, String[] options, enums.Topic topic ) {
        super(id, body, answer, difficulty, QuestionType.MCQ, topic);
        this.options = options;
   }

    public String[] getOptions() {
        return options;
    }
}
class FillInBlank extends Question{
    public FillInBlank(String body, String answer, Difficulty difficulty, enums.Topic topic) {
        super(body, answer, difficulty, QuestionType.FillInBlank, topic);
    }

    public FillInBlank(String id, String body, String answer, Difficulty difficulty, enums.Topic topic) {
        super(id, body, answer, difficulty, QuestionType.FillInBlank, topic );
    }
}
class TrueFalse extends Question{
    public TrueFalse(String body, String answer, Difficulty difficulty, enums.Topic topic) {
        super(body, answer, difficulty, QuestionType.TrueFalse, topic);
    }

    public TrueFalse(String id, String body, String answer, Difficulty difficulty, enums.Topic topic ) {
        super(id, body, answer, difficulty, QuestionType.TrueFalse, topic);
    }
}
