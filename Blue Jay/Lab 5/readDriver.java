
/**
 * The class readDriver reads a txt file.
 *
 * @author Austin Lowery
 * @version 12 Feb 2019
 */
import java.util.*;
import java.io.*;
public class readDriver
{
    public static void main(String args[]) throws IOException{
        Scanner in;
        in = new Scanner(new File("fiveLines.txt"));
        
        while(in.hasNext()){
            System.out.println(in.nextLine( ));
        }
    }
}