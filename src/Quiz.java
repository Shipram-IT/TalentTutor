import java.util.ArrayList;

public class Quiz {
    private static int nextId = 1;
    protected String id;
    private enums.Topic topic;
    private enums.Difficulty difficulty;
    private ArrayList<Question> questions;

    public Quiz(enums.Topic topic, enums.Difficulty difficulty, ArrayList<Question> questions) {
        boolean flag = true;
        for (Question q : questions) {
            if (!q.getTopic().equals(topic) || !q.getDifficulty().equals(difficulty)){
                flag = false;
                break;
            }
        }
        if (flag){
            this.id = String.valueOf(nextId);
            nextId++;
            this.topic = topic;
            this.difficulty = difficulty;
            this.questions = new ArrayList<>();
        } else{
            throw new IllegalArgumentException("Questions don't match");
        }
    }

    public Quiz(String id, enums.Topic topic, enums.Difficulty difficulty, ArrayList<Question> questions) {
        boolean flag = true;
        for (Question q : questions) {
            if (!q.getTopic().equals(topic) || q.getDifficulty().equals(difficulty)){
                flag = false;
                break;
            }
        }
        if (flag){
            this.id = id;
            if (Integer.valueOf(id) >= nextId){
                nextId = Integer.valueOf(id) + 1;
            }
            this.topic = topic;
            this.difficulty = difficulty;
            this.questions = new ArrayList<>();
        } else{
            throw new IllegalArgumentException("Questions don't match");
        }
    }

    public void addQuestion(Question question) {
        // Add question to the quiz
    }

    public ArrayList<Question> getQuestions(){
        return this.questions;
    }

    @Override
    public String toString(){
        return "id : "+ this.id +
                "; topic: " + this.topic +
                "; difficulty: " + this.difficulty;
    }
}