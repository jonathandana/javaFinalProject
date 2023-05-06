package menu;

import java.util.List;
import java.util.Scanner;

public class MenuCreator {

    public static Object generateMenu(List<String> options, String mainMenu) {
        System.out.println(mainMenu);
        for (var option : options) {
            System.out.println(option);
        }
        System.out.println("Please Enter your choose:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return input;
        }
    }

}
