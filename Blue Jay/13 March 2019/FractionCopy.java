
/**
 * Creates FractionCopys and performs functions on those FractionCopys.
 *
 * @author Austin Lowery
 * @version 3/13/19
 */
public class FractionCopy
{
    private int num; // numerator
    private int den; // denominator

    /**
     * Creates a FractionCopy with a numerator and denominator
     * @param inNum the input numerator
     * @param inDen the input denominator
     */
    public FractionCopy(int inNum, int inDen){
        num = (inDen != 0)?inNum:0; // if denominator is 0, make the numerator 0
        den = (inDen != 0)?inDen:1; // if denominator is 0, make the denominator 1 instead
    }
    
    public FractionCopy(int mix, int inNum, int inDen){
        num = (inDen != 0)?(inDen * mix)+inNum:0;
        den = (inDen != 0)?inDen:1;
    }

    /**
     * Simplifies a FractionCopy
     */
    public FractionCopy simplify(){
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
        return new FractionCopy(num/candidate, den/candidate);
    }

    
    public FractionCopy add(FractionCopy other){
        int numerator;
        int denominator;
        
        numerator = this.num*other.den + other.num*this.den;
        denominator = this.den * other.den;
        
        return new FractionCopy(numerator,denominator).simplify();
    }
    
    public FractionCopy add(int value){
        int numerator;
        
        numerator = value * this.den;
        
        return new FractionCopy(this.num + numerator,this.den).simplify();
    }
    
    
    public FractionCopy substract(FractionCopy other){
        int numerator;
        int denominator;
        
        numerator = this.num*other.den - other.num*this.den;
        denominator = this.den * other.den;
        
        return new FractionCopy(numerator,denominator).simplify();
    }
    
    public FractionCopy subtract(int value){
        int numerator;
        
        numerator = value * this.den;
        
        return new FractionCopy(this.num - numerator,this.den).simplify();
    }
    
    
    public FractionCopy multiply(FractionCopy other){
        int numerator;
        int denominator;
        
        numerator = this.num * other.num;
        denominator = this.den * other.den;
        
        return new FractionCopy(numerator,denominator).simplify();
    }
    
    public FractionCopy multiply(int multiple){
        return new FractionCopy(this.num*multiple,this.den).simplify();
    }
    
    
    public FractionCopy divide(FractionCopy other){
        int numerator;
        int denominator;
        
        numerator = this.num * other.den;
        denominator = this.den * other.num;
        
        return new FractionCopy(numerator,denominator).simplify();
    }
    
    public FractionCopy divide(int dividend){
        return new FractionCopy(this.num,this.den*dividend).simplify();
    }
    
    public static int Check(){
        return 5;
    }
}
