import java.util.Scanner;
/**
 * Performs different operations on fractions
 *
 * @author Austin Lowery
 * @version 3/13/19
 */
public class FractionDriver
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        char contLoop = 'y';
        char choice;

        Fraction inputOne;
        Fraction inputTwo;

        while(contLoop == 'y'){
            System.out.println("Choose an operation:");
            System.out.println("\t1. Simplify");
            System.out.println("\t2. Add");
            System.out.println("\t3. Subtract");
            System.out.println("\t4. Multiply");
            System.out.println("\t5. Divide");
            System.out.println("\t6. Compare");
            System.out.println("\t7. Equals");
            System.out.println("\t8. Decimal");
            choice = in.nextLine().charAt(0);

            inputOne = makeFraction();
            System.out.println("\n");

            switch(choice){
                case '1': // simp
                System.out.println( inputOne.simplify().toString() );
                break;

                case '2': // add
                inputTwo = makeFraction();
                System.out.println( inputOne.add( inputTwo ).toString() );
                break;

                case '3': // sub
                inputTwo = makeFraction();
                System.out.println( inputOne.subtract( inputTwo ).toString() );
                break;

                case '4': // mult
                inputTwo = makeFraction();
                System.out.println( inputOne.multiply( inputTwo ).toString() );
                break;

                case '5': // div
                inputTwo = makeFraction();
                System.out.println( inputOne.divide( inputTwo ).toString() );
                break;

                case '6': // comp
                inputTwo = makeFraction();
                System.out.println( inputOne.compareTo( inputTwo ) );
                break;

                case '7': // equals
                inputTwo = makeFraction();
                System.out.println( inputOne.equals( inputTwo ) );
                break;

                case '8': // decimal
                System.out.println( inputOne.toDecimal() );
                break;

                default:
                System.err.println("FractionDriver.ChoiceOutOfBoundsException: A number must be between 1 and 7 inclusively.");
            }
            System.out.println("\nContinue? (y/n) ");
            contLoop = in.nextLine().charAt(0);
            System.out.println();
        }

    }

    public static Fraction makeFraction(){
        System.out.print("Enter the numerator (or r for random fraction): ");
        String num = in.nextLine();

        if(num.charAt(0) == 'r'){
            return Fraction.randomFraction();
        } else{
            System.out.print("Enter the denominator: ");
            int den = in.nextInt();
            in.nextLine();

            System.out.println();
            
            return new Fraction(Integer.parseInt(num),den);
        }
    }
}
