import java.util.*;
/**
 * A simple demonstration of how to use the StringTokenizer class.
 * The StringTokenizer class is located in the java.util package.
 * It has three overloaded constructors. Look at the Java API documentation
 * for a description of the three constructors and the available methods.
 *
 * @author L. Lehmann
 * @version v1
 */
public class BreakingUp
{
    public static void main(String[ ] args)
    {
        Scanner keyboard;
        String inputSentence;
        StringTokenizer stok; //declare a reference to hold the address of a StringTokenizer object

        int count = 0;
        String salaryString;
        double salary;
        stok = null;
        keyboard = new Scanner(System.in);

        System.out.println("Enter a line of text: ");
        inputSentence = new String(keyboard.nextLine( ) );
        while(!(inputSentence.equals("quit")))
        {
            stok = new StringTokenizer(inputSentence);//the constructor that take a String and uses a space as the delimeter

            System.out.println("Number of tokens: " + stok.countTokens( ) );
            //    count = stok.countTokens( );
            System.out.println(stok.nextToken( ) + " ");
            //   salaryString = stok.nextToken( );
            //   salary = Double.parseDouble(salaryString);
            //   System.out.println(salaryString  + "  " + salary * 2);
            //       //This output line demonstrates the countTokens( ) method
            //          System.out.println("This is how many tokens are in your input String: " + stok.countTokens( ));
            //          int loop = stok.countTokens( );
            //         
            //          salaryString = stok.nextToken( );
            //          salary = Double.parseDouble(salaryString);
            //          System.out.println(salaryString);
            //          System.out.println(salary * 1.1);
            //This while loop demonstrates two of the StringTokenizer methods, the hasMoreTokens( ) and the
            // nextToken( ) methods

            System.out.println("Enter another line of data or quit\n" );
            inputSentence = keyboard.nextLine( );
        }
        System.out.println("Goodbye");

        // Enter a new String to demonstrate another StringTokenizer constructor.
        // This version of the constructor takes a second paramenter, a string of characters
        // which will be used to tokenize the String. The delimeters do not
        // count as tokens, but delimit the tokens in the string of characters.
        //      System.out.println("\nEnter another line of text with some of the following characters ?,.!: ");       inputSentence = new String(keyboard.nextLine( ) );
        //       stok = new StringTokenizer(inputSentence);
        //       int age = Integer.parseInt(stok.nextToken( ));
        // 
        //       System.out.println("This is how many tokens are in your input String: " + stok.countTokens( ));
        // 
        // 
        //   System.out.println("token " + count + ": " + stok.nextToken( ) );
        //           count++;
        //       

        //For you TODO. Write the code similar to the above examples to see how the third StringTokenizer
        //constructor works. Look the constructor papameter list on the Java API documentation.
        //put your code here.


    }//end of main
} //end of class

