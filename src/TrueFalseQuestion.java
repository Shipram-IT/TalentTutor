/**
 * Concrete class for True/False Question
 */
public class TrueFalseQuestion extends Question {
    /**
     * Constructor for TrueFalseQuestion.
     *
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     */
    public TrueFalseQuestion(String questionBody, String answer, int difficultyLevel, Department department) {
        super(questionBody, answer, difficultyLevel, department);
    }

    /**
     * Implementation of abstract method to get the question type.
     */
    @Override
    public String getQuestionType() {
        return "TrueFalse";
    }
}