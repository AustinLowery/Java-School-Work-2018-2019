
/**
 * This class performs a set of operations
 * on a String input by the user
 *
 * @author Austin Lowery
 * @version 5 Feb 2019
 */
import java.util.Scanner;
public class Test
{
    public static void main(String args[]){
        String sentence;
        int counter;
        int index;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Print out a full sentence: ");
        sentence = in.nextLine();
        StringBuilder sentenceBuild = new StringBuilder(sentence);
        
        // a
        System.out.println("Length of Sentence: " + sentence.length());
        
        // b
        System.out.println("First Character: " + sentence.charAt(0));
        
        // c
        System.out.println("Last Character: " + sentence.charAt(sentence.length()-1));
        
        // d
        System.out.println("Does it contain the letter 'e': " + sentence.contains("e"));
        
        // e
        System.out.println("Does it contain \"ay\": " + sentence.contains("ay"));
        
        // f
        counter = 0;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == 'e') counter++;
        }
        System.out.println("Amount of times 'e' appears: " + counter);
        
        // g
        System.out.println("The last occurence of 'e' is at: " + sentence.lastIndexOf('e'));
        
        // h
        counter = 0;
        for(index = 0; index < sentence.length(); index++){
            if(sentence.charAt(index) == 'e') counter++;
            if(counter == 2) break;
        }
        if(counter == 2) System.out.println("Index of the second occurence of e: " + index);
        else System.out.println("The sentence does not have more than two e's.");
        
        // i
        counter = 0;
        for(index = 0; index < sentence.length(); index++){
            if(sentence.charAt(index) != ' ') counter++;
        }
        System.out.println("Sentence countains this many letters without spaces: " + counter);
        
        // j
        sentenceBuild.append("you know");
        System.out.println(sentenceBuild);
        
        // k
        System.out.println("All uppercase: " + sentence.toUpperCase());
        
        // l
        System.out.println("Substring of five characters: " + sentence.substring(0,5));
        
        // m
        System.out.println("Replaced 'a' with 'x': " + sentence.replaceAll("a", "x"));
        
    }
}
