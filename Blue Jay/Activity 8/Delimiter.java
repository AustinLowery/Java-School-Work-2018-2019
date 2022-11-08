import java.io.*;
import java.util.*;
/**
 * Uses different methods from the StringTokenizer based on a typed input.
 *
 * @author Austin Lowery
 * @version 3/11/2019
 */
public class Delimiter
{
    /**Utilizes StringTokenizer and Scanner to print out tokens and tokencounts of keyboard input.
     */
      public static void main() throws IOException{
        Scanner in; // initialize the Scanner in
        in = new Scanner(System.in); // assigns the Scanner object to keyboard input
        Scanner reader; // initialize the Scanner reader
        reader = new Scanner(new File("students.txt")); // assigns the Scanner to a text file to read
        
        String sentence; // sentence typed in
        StringTokenizer tokenizer; // the tokenizer object
        
        // space is delimiter
        System.out.print("Input a sentence w/ space as delimiter: ");
        sentence = in.nextLine();
        
        tokenizer = new StringTokenizer(sentence);
        printToken(tokenizer); // a method to print the token count and each token
        
        // comma is delimiter
        System.out.print("Input a sentence w/ comma as delimiter: ");
        sentence = in.nextLine();
        
        tokenizer = new StringTokenizer(sentence, ",");
        printToken(tokenizer);
        
        // comma is delimiter and counted as a token
        System.out.print("Input a sentence w/ comma as delimiter (comma counted as token): ");
        sentence = in.nextLine();
        
        tokenizer = new StringTokenizer(sentence, ",", true);
        printToken(tokenizer);
        
        // comma and space is the delimiter
        System.out.print("Input a sentence w/ space and comma as delimiter: ");
        sentence = in.nextLine();
        
        tokenizer = new StringTokenizer(sentence, ", ");
        printToken(tokenizer);
        
        // each line in the text file has their tokens printed
        System.out.println("Text file w/ comma as delimiter: ");
        while(reader.hasNext()){ // while there is still another line to print
            tokenizer = new StringTokenizer(reader.nextLine(), ",");
            printTextfileToken(tokenizer); // a method to print each token
        }
    }
    
    /**Prints the token count and each token in the tokenizer.
     *@param tokenizer the StringTokenizer object
     */
    public static void printToken(StringTokenizer tokenizer){
        System.out.println("Number of Tokens: " + tokenizer.countTokens()); // counts the tokens
        while(tokenizer.hasMoreTokens()){ // while there is still tokens to print
            System.out.println("Token: " + tokenizer.nextToken()); // prints the token
        }
        System.out.println();
    }
    
    /**Prints each token in the tokenizer.
     *@param tokenizer the StringTokenizer object
     */
    public static void printTextfileToken(StringTokenizer tokenizer){
        while(tokenizer.hasMoreTokens()){ // while there is still tokens to print
            System.out.println(tokenizer.nextToken()); // prints the token
        }
        System.out.println();
    }
}
