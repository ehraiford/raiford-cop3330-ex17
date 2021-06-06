package ex17;

import java.util.Scanner;


public class App {
    static double checkingNumber(Scanner in, String prompt) {
        System.out.print(prompt);
        String input;
        while(!in.hasNextDouble())
        {
           System.out.println("Input must be numeric.");
           System.out.print(prompt);
           input = in.nextLine();
        }
        input = in.nextLine();
        double value = Double.parseDouble(input);
        return value;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        double weight = checkingNumber(in,"Please enter your weight. ");

        System.out.print("What is your gender? (male or female) ");
        double ratio = 0;
        while (ratio != .73 && ratio != .66)
        {
            String gender = in.nextLine();

            if (gender.compareTo("male") == 0) {
                ratio = .73;
            } else if (gender.compareTo("female") == 0) {
                ratio = .66;
            } else {
                System.out.println("Unexpected input. Please answer either male or female.");
                System.out.print("What is your gender? (male or female) ");
            }
        }

        double alcoholConsumed = checkingNumber(in, "What is the total amount of alcohol you have consumed (in ounces)? ");
        double hourssince = checkingNumber(in, "How many hours has it been since your last drink? ");

        double bac = (((alcoholConsumed * 5.14) / (weight * ratio)) - (.015 * hourssince));
        System.out.println(String.format("Your BAC is %.2f", bac));

        if(bac >= .08)
            System.out.println("It is not legal for you to drive.");
        else
            System.out.println("It is legal for you to drive.");
    }
}
