package classes.Question;

import enums.Department;

// Concrete class for Fill in the Blanks classes.Question.Question
public class FillInTheBlanksQuestion extends Question {
    /**
     * Constructor for classes.Question.FillInTheBlanksQuestion.
     *
     * @param topic           The topic of the question.
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     */
    public FillInTheBlanksQuestion(String topic, String questionBody, String answer, int difficultyLevel, Department department) {
        super(topic, questionBody, answer, difficultyLevel, department);
    }

    /**
     * Constructor for classes.Question.FillInTheBlanksQuestion.
     *
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     */
    public FillInTheBlanksQuestion(String questionBody, String answer, int difficultyLevel, Department department) {
        super(questionBody, answer, difficultyLevel, department);
    }

    /**
     * Implementation of abstract method to get the question type.
     */
    @Override
    public String getQuestionType() {
        return "FillInTheBlanks";
    }
}