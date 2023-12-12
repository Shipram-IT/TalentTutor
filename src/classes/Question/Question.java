package classes.Question;

import enums.Department;

// Abstract class for representing a classes.Question.Question
public abstract class Question {
    private static int nextID = 1;
    private String topic = "";
    private final String questionBody;
    private final String answer;
    private final int difficultyLevel;
    private final Department department;
    private int id;

    /**
     * Constructor for classes.Question.Question.
     *
     * @param topic           The topic of the question.
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     */
    public Question(String topic, String questionBody, String answer, int difficultyLevel, Department department) {
        this.topic = topic;
        this.questionBody = questionBody;
        this.answer = answer;
        this.difficultyLevel = difficultyLevel;
        this.department = department;
        nextID += 1;
        this.id = nextID;
    }

    /**
     * Constructor for classes.Question.Question.
     *
     * @param questionBody    The body of the question.
     * @param answer          The answer to the question.
     * @param difficultyLevel The difficulty level of the question.
     * @param department      The department associated with the question.
     */
    public Question(String questionBody, String answer, int difficultyLevel, Department department) {
        this.questionBody = questionBody;
        this.answer = answer;
        this.difficultyLevel = difficultyLevel;
        this.department = department;
        nextID += 1;
        this.id = nextID;
    }

    /**
     * Abstract method to get the question type.
     *
     * @return The question type.
     */
    public abstract String getQuestionType();

    /**
     * Getter method for the question body.
     *
     * @return The question body.
     */
    public String getQuestionBody() {
        return questionBody;
    }

    /**
     * Getter method for the answer.
     *
     * @return The answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Getter method for the difficulty level.
     *
     * @return The difficulty level.
     */
    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Getter method for the department.
     *
     * @return The department.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Getter method for the id.
     *
     * @return The id.
     */
    public int getId() {
        return id;
    }
}