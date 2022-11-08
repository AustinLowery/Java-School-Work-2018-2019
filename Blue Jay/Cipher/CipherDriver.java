
/**
 * The class CipherDriver creates a Scanner object to prompt
 * a user to create an object for the Cipher class.
 *
 * @author Austin Lowery
 * @version 4 Feb 2019
 */
import java.util.Scanner;
public class CipherDriver
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String text;
        String key;
        
        System.out.print("Enter text to encode: ");
        text = in.next();
        
        System.out.println("\nEnter a key: ");
        key = in.next();
        
        Cipher password = new Cipher(text, key, 'e');
        
        System.out.println("Your ciphered text: " + password.output());
        
    }
}
