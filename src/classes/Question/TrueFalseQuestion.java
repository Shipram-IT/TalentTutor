package classes.Question;

import enums.Department;

/**
 * Concrete class for True/False classes.Question.Question
 */
public class TrueFalseQuestion extends Question {
    /**
     * Constructor for classes.classes.Question.Question.TrueFalseQuestion.
     *
     * @param topic           The topic of the question.
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     */
    public TrueFalseQuestion(String topic, String questionBody, String answer, int difficultyLevel, Department department) {
        super(topic, questionBody, answer, difficultyLevel, department);
    }

    /**
     * Constructor for classes.classes.Question.Question.TrueFalseQuestion.
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