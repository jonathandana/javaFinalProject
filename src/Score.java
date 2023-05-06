public class Score {
    private String course;
    private double value;

    public Score(String course, double value) {
        this.course = course;
        this.value = value;
    }

    public String getCourse() {
        return course;
    }

    public double getValue() {
        return value;
    }
}