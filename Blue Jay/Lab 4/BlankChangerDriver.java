
/**
 * Creates a new Replacer Object
 *
 * @author Austin Lowery
 * @version 5 Feb 2019
 */
import java.util.Scanner;
public class BlankChangerDriver
{
    public static void main(String args[]){
        
        Scanner in = new Scanner(System.in);
        char choice = 'y';
        Replacer sentenceReplace;
        String sentence;
        
        while (choice == 'y'){
            System.out.println("Input a sentence: ");
            sentence = in.nextLine();
            
            sentenceReplace = new Replacer(sentence);
            sentenceReplace.replace(' ',"blank");
            
            System.out.println("Original Sentence: " + sentenceReplace.getOriginal());
            System.out.println("New Sentence: " + sentenceReplace.getConvertedString());
            
            System.out.print("\n\nWould you like to run again? (y/n) ");
            choice = in.nextLine().charAt(0);
        }
        
    }
}
