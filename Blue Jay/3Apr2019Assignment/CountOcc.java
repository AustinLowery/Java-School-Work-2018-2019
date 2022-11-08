import java.util.Scanner;
import java.io.*;
/**
 * This class contains only the main method
 * which accepts two command line arguments.
 * The first is the name of a file and the second is a character.
 * The method opens the file, counts the number of occurances of the
 * character in the file and then prints this count.
 * 
 * @author Lorrie Lehmann 
 * @version v1
 */
public class CountOcc
{
    public static void main(String[ ]  args)throws IOException
    {
        int count = 0;
        Scanner infile;
        PrintWriter outfile;
        String line;
        char searchChar;
        if(args.length != 2)
        {
            System.out.println("Proper usage is  CountOcc filename character");
        }
        else
        {
            infile = new Scanner(new File(args[0]));
            outfile = new PrintWriter(new File(args[1]));
            
            while(infile.hasNext())
            {
                line = infile.nextLine( );
                outfile.println(line);
               
            }
           // System.out.println("Goodbye");
           outfile.close();
            infile.close( );
        }
    }
}
                       
            
          

