import java.util.EnumSet;
import java.util.Scanner;

enum MaritalStatus{
    SINGLE,
    MARRIED,
    DIVORCED
}

public class Person {
    public int id;
    protected String firstName;

    public String getFullName() {
        return firstName+" "+lastName;
    }

    protected String lastName;
    private MaritalStatus status;

    protected final Scanner in  = new Scanner(System.in);

    public int getId() {
        return id;
    }

    public void input(){
        Scanner in  = new Scanner(System.in);

        enterId();

        System.out.print("Enter the first name: ");
        firstName = in.nextLine();

        System.out.print("Enter the last name: ");
        lastName = in.nextLine();

        enterStatus();
    }

    private void enterId(){
        String enter_id = "Enter the ID: ";
        System.out.print(enter_id);
        while (!in.hasNextInt()) {
            System.out.println("Invalid id!");
            System.out.print(enter_id);
            in.nextLine();
        }

        id = in.nextInt();
        in.nextLine();
    }


    private void enterStatus(){
        boolean isValidStatus = false;
        String enter_status = "Enter the marital status (SINGLE/MARRIED/DIVORCED): ";
        while (!isValidStatus) {
            System.out.print(enter_status);
            String statusStr = in.next().toUpperCase();
            for (MaritalStatus ms : EnumSet.allOf(MaritalStatus.class)) {
                if (ms.name().equals(statusStr)) {
                    status = ms;
                    isValidStatus = true;
                    break;
                }
            }
            if (!isValidStatus) {
                System.out.println("Invalid input!");
                System.out.println();
            }
        }
    }


    @Override
    public String toString() {
        return String.format("ID:%d first name:%s last name: %s status: %s", id, firstName, lastName, status);
    }


}
