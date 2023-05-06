import menu.MenuCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            options.add("4) Show All Student");
            options.add("5) Show Teacher by ID");
            options.add("7) Show Student by ID");
            options.add("8) Show Students by score range");
            options.add("9) Quit");

            var userResponse = MenuCreator.generateMenu(options, "Please choose your option:");

            switch (userResponse) {
                case 9 -> isRunning = false;
                default -> System.err.println("Error: invalid option");
            }
        }
    }
}