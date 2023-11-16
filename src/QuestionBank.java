import java.util.ArrayList;
import java.util.List;

/**
 * Class for QuestionBank
 */
public class QuestionBank {
    private final List<Question> questions;

    /**
     * Constructor for QuestionBank
     */
    public QuestionBank() {
        this.questions = new ArrayList<>();
    }

    /**
     * Method to add a question to the question bank
     *
     * @param question The question to add
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Other methods to modify the question bank
    // ...

    /**
     * Getter method for questions in the question bank
     *
     * @return The list of questions in the question bank
     */
    public List<Question> getQuestions() {
        return questions;
    }
}