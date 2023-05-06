import menu.MenuCreator;
import java.util.ArrayList;
import java.util.List;

public class Main {
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
                    var person = new Person();
                    person.input();
                }
                case 2 -> System.out.println("Add Student");
                case 3 -> System.out.println("Show All People");
                case 4 -> System.out.println("Show All Student");
                case 5 -> System.out.println("Show Teacher by ID");
                case 6 -> System.out.println("Show Teacher by ID");
                case 7 -> System.out.println("Show Student by ID");
                case 8 -> System.out.println("Show Students by score range");
                case 9 -> isRunning = false;
                default -> System.err.println("Error: invalid option");
            }
        }
    }
}