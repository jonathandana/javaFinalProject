package menu;

import java.util.List;
import java.util.Scanner;

public class MenuCreator {

    public static Integer generateMenu(List<String> options,String mainMenu){
        System.out.println(mainMenu);
        for (var option : options){
            System.out.println(option);
        }
        System.out.println("Please Enter your choose:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();

    }
}
