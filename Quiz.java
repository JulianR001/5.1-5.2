
/**
 * Write a description of class Quiz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Arrays;

public class Quiz
{
    static Scanner in = new Scanner(System.in);
    static Fraction Result = new Fraction();
    static Fraction Frac1 = new Fraction();
    static Fraction Frac2 = new Fraction();
    static String Input;
    static int operand;
    static boolean GameOn = true;
    static String[] operator = {"+", "-", "x", "/"};
    static int correct = 0;
    static int  incorrect = 0;
    public static void FractionQuiz() {
        while(GameOn) {
            Frac1.RandomFraction();
            Frac2.RandomFraction();
            operand = (int) (Math.random() * 4);
            Print();
        }
        System.out.print("Game over your score was " + correct + "/" + (incorrect+correct));
    }

    public static void Print() {
        System.out.print("your current question is ");
        System.out.println(Frac1.toString() + " " + operator[operand] + " " +Frac2.toString());
        Answer();
        Input = in.nextLine();
        if(Input.equals("quit"))
            GameOn = false; else equals();
    }

    public static String Answer() {
        switch(operand) {
                case(0):
                Result = Result.add(Frac1, Frac2);
                break;
                case(1):
                Result = Result.subtract(Frac1, Frac2);
                break;
                case(2):
                Result = Result.multiply(Frac1, Frac2);
                break;
                case(3):
                Result = Result.divide(Frac1, Frac2);
                break;
        }
        System.out.println(Result.toString());
        return Result.toString();
    }

    public static void equals() {   
        if(Input.equals(Answer())) {
            System.out.println("Correct!");
            correct++;
        } else {
            System.out.println("Incorrect! the answer is " + Answer());
            incorrect++;
        }
    }
}
