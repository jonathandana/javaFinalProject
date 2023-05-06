public class Teacher extends Person {
    private double wage;

    public void  input(){
        System.out.println("New Teacher");
        super.input();
        String enter_wage = "Enter the teacher's wage: ";
        System.out.print(enter_wage);

        while (!in.hasNextDouble()) {
            System.out.println("Invalid input!");
            System.out.print(enter_wage);
            in.nextLine(); // Consume the invalid input
        }
        wage = in.nextDouble();


    }

    @Override
    public String toString() {
        return String.format("%s Wage: %.2f", super.toString(), wage);
    }
}
