import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuizAttempt {
    private Quiz quiz;
    private ArrayList<String> answers;

    public QuizAttempt(Quiz quiz, ArrayList answers){
        this.quiz = quiz;
        this.answers = answers;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getMarks(){
        int marks = 0;
        int numberOfQuestions = quiz.getQuestions().size();
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).equals(quiz.getQuestions().get(i))){
                marks++;
            }
        }
        marks/=numberOfQuestions;
        return marks;
    }
}