
/**
 * Creates fractions and performs functions on those fractions.
 *
 * @author Austin Lowery
 * @version 3/13/19
 */
public class Fraction
{
    private int num; // numerator
    private int den; // denominator

    /**
     * Creates a fraction with a numerator and denominator
     * @param inNum the input numerator
     * @param inDen the input denominator
     */
    public Fraction(int inNum, int inDen){
        num = (inDen != 0)?inNum:0; // if denominator is 0, make the numerator 0
        den = (inDen != 0)?inDen:1; // if denominator is 0, make the denominator 1 instead
    }
    
    public Fraction(int mix, int inNum, int inDen){
        num = (inDen != 0)?(inDen * mix)+inNum:0;
        den = (inDen != 0)?inDen:1;
    }

    /**
     * Simplifies a fraction
     */
    public Fraction simplify(){
        int candidate; // used to divide the num and den by the greatest common factor

        // absolute value of numerator and denominator
        int absNum = Math.abs(num);
        int absDen = Math.abs(den);

        // checks for the smallest between the absolute values of both the num and den
        if(absNum < absDen)
            candidate = absNum;
        else
            candidate = absDen;

        // while the numerator and denominator do not share a common multiple
        while(absNum%candidate != 0 || absDen%candidate != 0){
            candidate--;
        }

        // divides numerator and denominator by the gcf
        return new Fraction(num/candidate, den/candidate);
    }

    
    public Fraction add(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num*other.den + other.num*this.den;
        denominator = this.den * other.den;
        
        return new Fraction(numerator,denominator).simplify();
    }
    
    public Fraction add(int value){
        int numerator;
        
        numerator = value * this.den;
        
        return new Fraction(this.num + numerator,this.den).simplify();
    }
    
    
    public Fraction substract(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num*other.den - other.num*this.den;
        denominator = this.den * other.den;
        
        return new Fraction(numerator,denominator).simplify();
    }
    
    public Fraction subtract(int value){
        int numerator;
        
        numerator = value * this.den;
        
        return new Fraction(this.num - numerator,this.den).simplify();
    }
    
    
    public Fraction multiply(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num * other.num;
        denominator = this.den * other.den;
        
        return new Fraction(numerator,denominator).simplify();
    }
    
    public Fraction multiply(int multiple){
        return new Fraction(this.num*multiple,this.den).simplify();
    }
    
    
    public Fraction divide(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num * other.den;
        denominator = this.den * other.num;
        
        return new Fraction(numerator,denominator).simplify();
    }
    
    public Fraction divide(int dividend){
        return new Fraction(this.num,this.den*dividend).simplify();
    }
}
