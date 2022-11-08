
/**
 * This is an exercise in using the String and
 * StringBuilder classes
 * 
 * @author Austin Lowery 
 * @version 6 Feb 2019
 */
import java.util.Scanner;
public class StringTesting
{
    public static void main(String[ ] args)
    {
        //declare a reference to a String object:
        String sentence;
        
        //declare a reference to a StringBuilder object
        StringBuilder nSentence;
        
        //declare a reference to a Scanner object
        Scanner in;
        
        //declare an int to hold the unicode value of a character
        int unicode;
        
        //create a Scanner object that will use the keyboard for input
        in = new Scanner(System.in);
        
        //create a String object with input from the user
        System.out.print("Enter a String: ");
        sentence = in.nextLine();
        
        //create a StringBuilder object from the String
        nSentence = new StringBuilder(sentence);
        
        //loop through the StringBuilder object character by character.
        //change each character to the next character in the unicode encoding scheme
        for(int index = 0; index < nSentence.length(); index++){
            unicode = (int)(nSentence.charAt(index))+1;
            nSentence.replace(index,index+1,Character.toString((char)(unicode)));
        }
        
        //print the original String and the StringBuilder contents
        System.out.println("String: " + sentence);
        System.out.println("New String: " + nSentence);
        
        
        //ask the user if they want to repeat
        //compile and run
        //set a breakpoint near the top of the code, not on a declaration statement
        //step though the statement and exampline the variables
        
    }//end of main
    
}//end of class

