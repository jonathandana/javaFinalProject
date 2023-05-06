import menu.MenuCreator;
import java.util.ArrayList;
import java.util.List;

enum ShowAllPeoplesOptions{
    ALL,
    STUDENT,
    TEACHER

}
public class Main {
    private static final List<Person> PEOPLE = new ArrayList<>();
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

            var userResponse = MenuCreator.generateMenu(options, "Please choose your option:");

            switch (userResponse) {
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
                case 6 -> System.out.println("Show Teacher by ID");
                case 7 -> System.out.println("Show Student by ID");
                case 8 -> System.out.println("Show Students by score range");
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
}