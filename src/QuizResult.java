/**
 * Class for representing a QuizResult, composed within the Quiz class.
 */
public class QuizResult {
    private Employee employee;
    private int score;

    /**
     * Constructor for QuizResult.
     *
     * @param employee The employee who took the quiz.
     * @param score    The score achieved in the quiz.
     */
    public QuizResult(Employee employee, int score) {
        this.employee = employee;
        this.score = score;
    }

    /**
     * Getter method for retrieving the employee associated with the quiz result.
     *
     * @return The employee who took the quiz.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Getter method for retrieving the score achieved in the quiz.
     *
     * @return The score achieved in the quiz.
     */
    public int getScore() {
        return score;
    }
}