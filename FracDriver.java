import java.util.Scanner;
public class FracDriver
{
    public static void main (String[] args) {
        System.out.println("Testing constructors.../n");

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(1,2);
        Fraction f3 = new Fraction("3/4");
        Fraction f4 = new Fraction(f2);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

        System.out.println("arithmetic methods");

        System.out.println( f3 + " + " + f4 + " = " + Fraction.add(f3, f4) );
        System.out.println( f3 + " - " + f4 + " = " + Fraction.subtract(f3, f4) );
        System.out.println( f3 + " x " + f4 + " = " + Fraction.multiply(f3, f4) );
        System.out.println( f3 + " ÷ " + f4 + " = " + Fraction.divide(f3, f4) );

        System.out.println("denominator zero tests");

        Fraction f5 = new Fraction(1,0);
        Fraction f6 = new Fraction("1/0");
        Fraction f7 = new Fraction("0/1");

        System.out.println( f4 + " ÷ " + f7 + " = " + Fraction.divide(f4, f7) );
        
        System.out.println("extra Testing");

        Fraction f8 = new Fraction("-1/-2");
        System.out.println( f4 + " + " + f8 + " = " + Fraction.add(f4, f8) );
        Fraction.PI();   
        Quiz game = new Quiz();
        System.out.println();
        System.out.println("lets start a fraction quiz, type 'quit' to leave");
        game.FractionQuiz();
    }
}
   