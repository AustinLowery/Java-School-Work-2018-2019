import java.util.Scanner;
/**
 * Performs different operations on fractions
 *
 * @author Austin Lowery
 * @version 3/13/19
 */
public class FractionDriver
{
    public static void main(String[] args){
        Scanner in;
        in = new Scanner(System.in);

        char contLoop = 'y';
        char choice;

        int mix;
        int num;
        int den;

        Fraction input;
        Fraction output;

        while(contLoop == 'y'){
            System.out.println("Fraction or Mixed Number: ");
            System.out.println("\t1. Fraction");
            System.out.println("\t2. Mixed Number");
            System.out.println("\t3. Quit");
            System.out.print("\nResponse: ");

            choice = in.nextLine().charAt(0);

            switch(choice){
                case '1':
                System.out.print("\nEnter the numerator: ");
                num = in.nextInt();
                in.nextLine();

                System.out.print("\nEnter the denominator: ");
                den = in.nextInt();
                in.nextLine();

                input = new Fraction(num,den);
                System.out.println("\n"+input.toString()+"\n\n");
                break;

                case '2':
                System.out.print("\nEnter the whole number: ");
                mix = in.nextInt();
                in.nextLine();

                System.out.print("\nEnter the numerator: ");
                num = in.nextInt();
                in.nextLine();

                System.out.print("\nEnter the denominator: ");
                den = in.nextInt();
                in.nextLine();

                input = new Fraction(mix,num,den);
                System.out.println("\n"+input.toString()+"\n\n");
                break;
                
                case '3':
                contLoop = 'n';
                continue;
                
                default:
                System.err.println("FractionDriver.InvalidEntryException: Must choose number 1 or 2.");
                System.out.println();
                continue;
            }

            System.out.println("Choose an operation to perform on the fraction: ");
        }
    }
}
