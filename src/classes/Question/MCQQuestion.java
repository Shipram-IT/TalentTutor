package classes.Question;

import classes.Question.Question;
import enums.Department;

import java.util.List;

/**
 * Concrete class for Multiple Choice classes.Question.Question
 */
public class MCQQuestion extends Question {
    private final List<String> options;

    /**
     * Constructor for classes.Question.MCQQuestion.
     *
     * @param topic           The topic of the question
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     * @param options         The options for the MCQ question.
     */
    public MCQQuestion(String topic, String questionBody, String answer, int difficultyLevel, Department department,
                       List<String> options) {
        super(topic, questionBody, answer, difficultyLevel, department);
        this.options = options;
    }

    /**
     * Constructor for classes.Question.MCQQuestion.
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