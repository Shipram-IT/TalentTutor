import classes.Question.Question;
import enums.Department;

import java.util.ArrayList;
import java.util.List;

// Class for Quiz
public class Quiz {
    private final String quizNumber;
    private final List<Question> quizQuestions;
    private final List<QuizResult> quizResults;  // Composition
    private final Department department;

    /**
     * Constructor for Quiz.
     *
     * @param quizNumber    The unique identifier for the quiz.
     * @param quizQuestions The list of questions in the quiz.
     * @param department    The department associated with the quiz.
     */
    public Quiz(String quizNumber, List<Question> quizQuestions, Department department) {
        this.quizNumber = quizNumber;
        this.quizQuestions = quizQuestions;
        this.quizResults = new ArrayList<>();
        this.department = department;
    }

    /**
     * Method to add a quiz result to the quiz.
     *
     * @param employee The employee who took the quiz.
     * @param score    The score achieved in the quiz.
     */
    public void addQuizResult(Employee employee, int score) {
        QuizResult result = new QuizResult(employee, score);
        quizResults.add(result);
    }

    // Other methods for quiz functionality
    // ...

    /**
     * Getter method for retrieving the unique identifier of the quiz.
     *
     * @return The quiz number.
     */
    public String getQuizNumber() {
        return quizNumber;
    }

    /**
     * Getter method for retrieving the list of questions in the quiz.
     *
     * @return The list of questions in the quiz.
     */
    public List<Question> getQuizQuestions() {
        return quizQuestions;
    }

    /**
     * Getter method for retrieving the list of quiz results associated with the quiz.
     *
     * @return The list of quiz results.
     */
    public List<QuizResult> getQuizResults() {
        return quizResults;
    }

    /**
     * Getter method for retrieving the department associated with the quiz.
     *
     * @return The department of the quiz.
     */
    public Department getDepartment() {
        return department;
    }
}