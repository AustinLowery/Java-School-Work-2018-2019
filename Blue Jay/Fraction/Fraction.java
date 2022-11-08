
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
        
        return (numerator != 0)?new Fraction(numerator,denominator).simplify():new Fraction(0,1);
    }
    
    
    public Fraction subtract(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num*other.den - other.num*this.den;
        denominator = this.den * other.den;
        
        return (numerator != 0)?new Fraction(numerator,denominator).simplify():new Fraction(0,1);
    }
    
    
    public Fraction multiply(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num * other.num;
        denominator = this.den * other.den;
        
        return new Fraction(numerator,denominator).simplify();
    }
    
    public Fraction divide(Fraction other){
        int numerator;
        int denominator;
        
        numerator = this.num * other.den;
        denominator = this.den * other.num;
        
        return new Fraction(numerator,denominator).simplify();
    }
    
    public String compareTo(Fraction other){
        int numerator1;
        int numerator2;
        String compareValue;
        
        numerator1 = this.num * other.den;
        numerator2 = other.num * this.den;
        
        if(numerator1 > numerator2)
            compareValue = " > ";
        else if(numerator1 == numerator2)
            compareValue = " = ";
        else
            compareValue = " < ";
            
        return this.toString() + compareValue + other.toString();
    }
    
    
    public static Fraction randomFraction(){
        int numerator = (int)(Math.random()*9)+1;
        return new Fraction(numerator, numerator + (int)(Math.random()*(9-numerator) + 1));
    }
    
    
    public boolean equals(Fraction other){
        return (this.compareTo(other).contains("="))?true:false;
    }
    
    public double toDecimal(){
        return (double)(num) / den;
    }
    
    public String toString(){
        return num + "/" + den;
    }
}
