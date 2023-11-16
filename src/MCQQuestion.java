import java.util.List;

/**
 * Concrete class for Multiple Choice Question
 */
public class MCQQuestion extends Question {
    private final List<String> options;

    /**
     * Constructor for MCQQuestion.
     *
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     * @param options         The options for the MCQ question.
     */
    public MCQQuestion(String questionBody, String answer, int difficultyLevel, Department department,
                       List<String> options) {
        super(questionBody, answer, difficultyLevel, department);
        this.options = options;
    }

    /**
     * Implementation of abstract method to get the question type.
     */
    @Override
    public String getQuestionType() {
        return "MCQ";
    }

    /**
     * Getter method for the options.
     *
     * @return The options for the MCQ question.
     */
    public List<String> getOptions() {
        return options;
    }
}