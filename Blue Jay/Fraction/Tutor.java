import java.util.*;
/**
 * Write a description of class Tutor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tutor
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char contLoop = 'y';
        char choice;
        StringTokenizer tokenizer;

        Fraction fractionOne;
        Fraction fractionTwo;
        Fraction userAnswer;

        int userNum;
        int userDen;

        while(contLoop == 'y'){
            System.out.println("Choose an operation to practice:");
            System.out.println("\tA(dd)");
            System.out.println("\tS(ubtract)");
            System.out.println("\tM(ultiply)");
            System.out.println("\tD(ivide)");
            System.out.println("\tQ(ivide)");

            choice = in.nextLine().toUpperCase().charAt(0);
            
            System.out.println("\n");
            switch(choice){
                case 'A':
                for(int i = 0; i < 5; i++){
                    fractionOne = Fraction.randomFraction();
                    fractionTwo = Fraction.randomFraction();
                    System.out.print(fractionOne + " + " + fractionTwo + " = ");
                    tokenizer = new StringTokenizer(in.nextLine(), "/");

                    userNum = Integer.parseInt(tokenizer.nextToken());
                    if(tokenizer.hasMoreTokens())
                        userDen = Integer.parseInt(tokenizer.nextToken());
                    else
                        userDen = 1;

                    userAnswer = new Fraction(userNum, userDen);

                    if(userAnswer.equals(fractionOne.add(fractionTwo)))
                        System.out.println("Correct!");
                    else
                        System.out.println("Good effort! But " + fractionOne + " + " + fractionTwo + " = " + fractionOne.add(fractionTwo));
                    System.out.println("\n");
                }
                break;
                
                case 'S':
                for(int i = 0; i < 5; i++){
                    fractionOne = Fraction.randomFraction();
                    fractionTwo = Fraction.randomFraction();
                    System.out.print(fractionOne + " - " + fractionTwo + " = ");
                    tokenizer = new StringTokenizer(in.nextLine(), "/");

                    userNum = Integer.parseInt(tokenizer.nextToken());
                    if(tokenizer.hasMoreTokens())
                        userDen = Integer.parseInt(tokenizer.nextToken());
                    else
                        userDen = 1;

                    userAnswer = new Fraction(userNum, userDen);

                    if(userAnswer.equals(fractionOne.subtract(fractionTwo)))
                        System.out.println("Correct!");
                    else
                        System.out.println("Good effort! But " + fractionOne + " - " + fractionTwo + " = " + fractionOne.subtract(fractionTwo));
                    System.out.println("\n");
                }
                break;
                
                case 'M':
                for(int i = 0; i < 5; i++){
                    fractionOne = Fraction.randomFraction();
                    fractionTwo = Fraction.randomFraction();
                    System.out.print(fractionOne + " * " + fractionTwo + " = ");
                    tokenizer = new StringTokenizer(in.nextLine(), "/");

                    userNum = Integer.parseInt(tokenizer.nextToken());
                    if(tokenizer.hasMoreTokens())
                        userDen = Integer.parseInt(tokenizer.nextToken());
                    else
                        userDen = 1;

                    userAnswer = new Fraction(userNum, userDen);

                    if(userAnswer.equals(fractionOne.multiply(fractionTwo)))
                        System.out.println("Correct!");
                    else
                        System.out.println("Good effort! But " + fractionOne + " * " + fractionTwo + " = " + fractionOne.multiply(fractionTwo));
                    System.out.println("\n");
                }
                break;
                
                case 'D':
                for(int i = 0; i < 5; i++){
                    fractionOne = Fraction.randomFraction();
                    fractionTwo = Fraction.randomFraction();
                    System.out.print(fractionOne + " / " + fractionTwo + " = ");
                    tokenizer = new StringTokenizer(in.nextLine(), "/");

                    userNum = Integer.parseInt(tokenizer.nextToken());
                    if(tokenizer.hasMoreTokens())
                        userDen = Integer.parseInt(tokenizer.nextToken());
                    else
                        userDen = 1;

                    userAnswer = new Fraction(userNum, userDen);

                    if(userAnswer.equals(fractionOne.divide(fractionTwo)))
                        System.out.println("Correct!");
                    else
                        System.out.println("Good effort! But " + fractionOne + " / " + fractionTwo + " = " + fractionOne.divide(fractionTwo));
                    System.out.println("\n");
                }
                break;
                
                case 'Q':
                System.out.println("Goodbye! Have a Fractastic day!");
                contLoop = 'n';
                break;
                
                default:
                System.out.println("Whoops! That's not the right input. Put in either A, S, M, D, or Q this time!");
                
            }
        }
    }
}
