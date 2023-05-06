import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private final List<Score> SCORES = new ArrayList<>();

    public void input(){
        System.out.println("'New Student'");
        super.input();
    }
    public void addScore(Score score){
        SCORES.add(score);
    }

    public double getAverageScore() {
        if (SCORES.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Score score : SCORES) {
            sum += score.getValue();
        }
        return sum / SCORES.size();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Average Score: %.2f", getAverageScore());
    }


}
