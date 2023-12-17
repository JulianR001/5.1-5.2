
/**
 * represents a fraction with a numerator and denominator
 *
 * @author Julian
 * @version 1.0
 */

public class Fraction
{
    //intance variable
    private int numerator, denominator;  
    //constructors
    public Fraction() {
        numerator = 1;
        denominator = 1;
    }
    public void RandomFraction() {
        numerator = (int) (Math.random() * 10);
        denominator = (int) (Math.random() * 9 + 1);
    }

    public Fraction(int n, int d) {
        if(d == 0) {
            System.out.println("Error denominator cannot be 0");
            d = 1;
        }
        numerator = n;
        denominator = d;
        CheckDenom();
    }

    public Fraction(String str) {
        int n = str.indexOf("/");
        if(n > 0) {
            numerator = Integer.parseInt(str.substring(n - 1, n));
            denominator = Integer.parseInt(str.substring(n + 1));
        } else System.out.print("invalid input");
    }

    public Fraction(Fraction myFraction) {
        numerator = myFraction.numerator;
        denominator = myFraction.denominator;
    }
    //accessor methods
    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }
    //behaivor
    public void CheckDenom() {
        if(denominator == 0) {
            denominator = 1;
            System.out.print("invalid denominator, cannot be 0");
        }
    }
    //mutator
    public void setNum(int n) {
        numerator = n;
    }

    public void setDenom(int d) {
        denominator = d;
    }

    public void reduce() {
        int x = GCF();
        numerator /= x;
        denominator /= x;
    }

    public int GCF() {
        int a = numerator;
        int b = denominator;
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static Fraction add (Fraction a, Fraction b) {
        //returns a new fraction that is the sum of the parameter fractions.

        int newNum = a.numerator * b.denominator + b.numerator * a.denominator;
        int newDen = a.denominator * b.denominator;
        Fraction newFrac = new Fraction(newNum, newDen);
        newFrac.reduce();

        return newFrac;
    }

    public static Fraction subtract (Fraction a, Fraction b) {      
        //returns a fraction that is the difference of the parameter fractions.

        int newNum = a.numerator * b.denominator - b.numerator * a.denominator;
        int newDen = a.denominator * b.denominator;
        Fraction ans = new Fraction(newNum, newDen);
        ans.reduce();

        return ans;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        int newNum = a.numerator * b.numerator;
        int newDen = a.denominator * b.denominator;
        Fraction ans = new Fraction(newNum , newDen);
        ans.reduce();
        return ans;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        Fraction reciprocal = b.getReciprocal();
        Fraction ans = Fraction.multiply(a, reciprocal);
        ans.reduce();
        return ans;
    }

    //Helper Methods
    private Fraction getReciprocal() {
        Fraction reciprocal = new Fraction(denominator, this.numerator);
        return reciprocal;
    }

    public int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == 0 || y == 0)
            return 1;

        while (x != y) {
            if (x > y) x -= y;
            else  y -= x;    
        }
        return x;
    }

    public static void PI() {
        Fraction MILU = new Fraction( 355, 113 );
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble() );
        double a = 1;
        double b = 1;
        double NewEstimate = a/b;
        boolean PIE = false;
        while(Math.abs( Math.PI - NewEstimate ) >= EPSILON) {
            NewEstimate = a/b;
            if(NewEstimate > Math.PI) {
                b++;
            }
            else {
                a++;
            }
        }
        Fraction NewPi = new Fraction((int)a - 1, (int)b - 1);
        System.out.println("the next closest fraction is " + NewPi);
    }
}
  

