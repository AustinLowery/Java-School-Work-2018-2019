
/**
 * The class stepFour reads a txt file
 * and tells of different characteristics of it
 *
 * @author Austin Lowery
 * @version 12 Feb 2019
 */
import java.util.*;
import java.io.*;
public class stepFour
{
    public static void main(String args[]) throws IOException{
        Scanner in;
        in = new Scanner(new File("sevenLines.txt"));
        
        int eAmount = 0;
        int vowelCount = 0;
        int charCount = 0;
        int nonSpace = 0;
        String upperCase = "";
        String currentLine;
        char isSame;
        
        while(in.hasNext()){
            currentLine = in.nextLine( );
            upperCase += currentLine.toUpperCase() + "\n";
            
            for(int index = 0; index < currentLine.length(); index++){
                isSame = Character.toUpperCase( currentLine.charAt(index) );
                charCount++;
                if(isSame == 'E'){
                    eAmount++;
                    vowelCount++;
                } else if(isSame == 'A' || isSame == 'I' || isSame == 'O' || isSame == 'U'){
                    vowelCount++;
                } else if(isSame == ' ' && index != 0 && currentLine.charAt(index-1) != ' '){
                    nonSpace++;
                }
            }
        }
        
        System.out.println("Amount of E's in file: " + eAmount);
        System.out.println("Amount of vowels in file: " + vowelCount);
        System.out.println("Characters in the file: " + charCount);
        System.out.println("The number of times a non-space character is preceded by a space character: " + nonSpace);
        System.out.println();
        System.out.println("The file contents in uppercase: \n" + upperCase);
    }
}