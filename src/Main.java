import menu.MenuCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

enum ShowAllPeoplesOptions{
    ALL,
    STUDENT,
    TEACHER

}
public class Main {
    private static final List<Person> PEOPLE = new ArrayList<>();
    public static final Scanner IN  = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
        System.out.println("Good By");
    }

    public static void mainMenu(){
        boolean isRunning = true;
        while (isRunning) {
            List<String> options = new ArrayList<>();
            options.add("1) Add Teacher");
            options.add("2) Add Student");
            options.add("3) Show All People");
            options.add("4) Show All Teacher");
            options.add("5) Show All Students");
            options.add("6) Show Teacher by ID");
            options.add("7) Show Student by ID");
            options.add("8) Show Students by score range");
            options.add("9) Quit");

            Object userResponse = MenuCreator.generateMenu(options, "Please choose your option:");
            int result = (Integer) userResponse;
            switch (result) {
                case 1 -> {
                    var teacher = new Teacher();
                    teacher.input();
                    PEOPLE.add(teacher);
                }
                case 2 -> {
                    var student = new Student();
                    student.input();
                    PEOPLE.add(student);
                }
                case 3 -> showAllPeoples(ShowAllPeoplesOptions.ALL);
                case 4 -> showAllPeoples(ShowAllPeoplesOptions.TEACHER);
                case 5 -> showAllPeoples(ShowAllPeoplesOptions.STUDENT);
                case 6 -> showTeacherByID();
                case 7 -> showStudentByID();
                case 8 -> showStudentsByScoreRange();
                case 9 -> isRunning = false;
                default -> System.err.println("Error: invalid option");
            }
        }
    }


    public static void showAllPeoples(ShowAllPeoplesOptions option){
        for (var person : PEOPLE){
            switch (option){
                case ALL -> System.out.println(person);
                case TEACHER -> {if(person instanceof Teacher) System.out.println(person);}
                case STUDENT -> {if(person instanceof Student) System.out.println(person);}
            }
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void showTeacherByID(){
        System.out.println("Please Enter the Teacher ID: ");
        int id = IN.nextInt();
        boolean found = false;
        for (var person : PEOPLE){
            if(id == person.id){
                found = true;
                if(person instanceof Teacher){
                    System.out.println(person);
                }else{
                    System.out.println("Not a teacher");
                }
                break;
            }
        }
        if(!found){
            System.out.println("Doesn't exists");
        }
    }


    public static void showStudentByID(){
        System.out.println("Please Enter the Student ID: ");
        int id = IN.nextInt();
        boolean found = false;

        for (var person : PEOPLE){
            if(id == person.id){
                found = true;
                if(person instanceof Student){
                    System.out.println(person);
                    subMenuStudent((Student) person);
                }else{
                    System.out.println("Not a student");
                }
                break;
            }
        }
        if(!found){
            System.out.println("Doesn't exists");
        }
    }

    private static void subMenuStudent(Student student) {

        boolean isRunning = true;
        while (isRunning) {
            List<String> options = new ArrayList<>();
            options.add("a) Show All Scores");
            options.add("b) Insert New Score");
            options.add("c) Show Average Score");
            options.add("d) Return to the Main Menu");

            Object userResponse = MenuCreator.generateMenu(options, "Please choose your option:");
            String result = (String) userResponse;

            switch (result){
                case "a" -> student.showAllScores();
                case "b" -> student.addScore();
                case "c" -> System.out.println("your average is: "+student.getAverageScore());
                case "d" -> isRunning = false;
            }
        }
    }

    public static void showStudentsByScoreRange(){
        System.out.print("Enter the minimum score: ");
        double minScore = IN.nextDouble();

        System.out.print("Enter the maximum score: ");
        double maxScore = IN.nextDouble();

        ArrayList<Student> studentsInRange = new ArrayList<>();


        for (Person person : PEOPLE) {
            if (person instanceof Student) {
                Student student = (Student) person;
                double averageScore = student.getAverageScore();
                if (averageScore >= minScore && averageScore <= maxScore) {
                    studentsInRange.add(student);
                }
            }
        }

        if (studentsInRange.isEmpty()) {
            System.out.println("No students found in the specified score range.");
        }
        else {
            System.out.printf("Students with average score between %.2f and %.2f:\n", minScore, maxScore);
            for (Student student : studentsInRange) {
                System.out.printf("%s (ID %d) - Average Score: %.2f\n", student.getFullName(), student.getId(), student.getAverageScore());
            }
        }


    }
}