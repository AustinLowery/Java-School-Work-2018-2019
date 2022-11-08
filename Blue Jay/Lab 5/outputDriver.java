
/**
 * The class outputDriver writes text to seven lines.
 *
 * @author Austin Lowery
 * @version 12 Feb 2019
 */
import java.io.*;
import java.util.Scanner;
public class outputDriver
{
    public static void main(String args[]) throws IOException{
        String filename;
        String line;
        Scanner in;
        PrintWriter output;
        
        output = new PrintWriter("sevenLines.txt");
        in = new Scanner(System.in);
        for(int index = 0; index < 7; index++){
            System.out.print("Enter line #" + (index+1) + ": ");
            line = in.nextLine();
            
            output.println(line);
        }
        output.close();
        System.out.println("Output file created.");
    }
}
