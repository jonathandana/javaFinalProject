import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    public final List<Score> SCORES = new ArrayList<>();

    public void input(){
        System.out.println("'New Student'");
        super.input();
    }
    public void addScore(){
        System.out.print("Please enter the course: ");
        in.nextLine();
        String course = in.nextLine();



        String enter_value = "Please enter the value: ";
        System.out.print(enter_value);

        while (!in.hasNextDouble()) {
            System.out.println("Invalid input!");
            System.out.print(enter_value);
            in.nextLine();
        }
        double value = in.nextDouble();
        Score score = new Score(course,value);
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

    public void showAllScores(){
        if (SCORES.isEmpty()) {
            System.out.println("There are no scores to show.");
            return;
        }
        for (var score : SCORES) {
            int index = SCORES.indexOf(score);
            System.out.printf("Position:%d, Course:%s, Value:%.2f\n", index, score.getCourse(), score.getValue());
        }
    }


}
