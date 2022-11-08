import java.util.Scanner;
/**
 * Finds each grave without a photo.
 *
 * @author Austin Lowery
 * @version 2/26/2019
 */
public class FindNoPhoto
{
    /**Finds each grave without a photo
     *@param args[] a list of strings that goes unused in the program
     *@throws Exception
     */
    public static void main(String args[]) throws Exception{
        Scanner in = new Scanner(System.in);
        int id;
        
        System.out.println("Input the cemetery ID: ");
        id = in.nextInt();
        
        FindAGrave pleasantGroves = new FindAGrave(id); // set to pleasant grove's memorial id
        System.out.println(pleasantGroves.toString()); // prints a string of pleasant grove profiles without a photo
    }
}