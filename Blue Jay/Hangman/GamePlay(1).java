import java.io.*; //needed for File and IOException
import java.util.*; // brings in the Scanner and Math class
/**
 * The class GamePlay prompts the user for a category then picks a random 
 * line from that category. That line is then used as the word to guess in 
 * the hangman game.
 * 
 * @author Austin Lowery
 * @version 2/23/2019
 */
public class GamePlay
{
    /**The main method prompts the user for a category then picks a random 
     * line from that category. That line is then used as the word to guess in 
     * the hangman game.
     *@param args[] a list of strings sent when the program is started; this list goes unused in the program
     *@throws IOException
     */
    public static void main(String[ ] args) throws IOException
    {
        Scanner in = new Scanner(System.in); // keyboard input
        Scanner reader = new Scanner(new File("christmas songs.txt")); // declares the reader with christmas songs as the default
        char guess; // the user's guess as to what letter is in the phrase
        char choice = 'y'; // the user's choice in category
        String category; // name of the category
        int randomOption; // random value initialized
        int year = 2019; // 2019 by default
        int i; // an iterator
        GameWord myPhrase = new GameWord(); // declares my phrase

        while(choice == 'y'){
            System.out.println("Choose a category: ");
            System.out.println("\t*Christmas Songs (enter 1)");
            System.out.println("\t*Famous Books (enter 2)");
            System.out.println("\t*Celebrities (enter 3)");
            System.out.println("\t*Slogans (enter 4)");
            System.out.println("\t*Video Games (enter 5)");
            System.out.println("\t*Highest Grossing Movies (enter 6)");
            System.out.println("\t*Random Category (enter anything else)");
            choice = in.next().charAt(0); // choice is determined by first character in the user's response

            switch(choice){
                case '1':
                reader = new Scanner(new File("christmas songs.txt")); // chooses the choice's respective text file
                category = "Christmas Songs"; // stores the category choice
                break;

                case '2':
                reader = new Scanner(new File("famous books.txt"));
                category = "Famous Books";
                break;

                case '3':
                reader = new Scanner(new File("slogans.txt"));
                category = "Slogans";
                break;

                case '4':
                reader = new Scanner(new File("celebrities.txt"));
                category = "Celebrities";
                break;

                case '5':
                reader = new Scanner(new File("video games.txt"));
                category = "Video Games";
                break;

                case '6':
                System.out.println("Highest grossing films for which year? (choose dates from 1915-2019) ");
                year = in.nextInt();
                if(year < 1915) year = 1915; // if it's too low, set it to 1915
                else if(year > 2019) year = 2019; // if it's too high, set it to 2019
                category = "Highest Grossing Movies of the " + year + "'s"; // sets category to the highest grossing movies of the year chosen
                break;

                default:
                randomOption = (int)(Math.random()*5); // random value for the random choice; 5 choices
                if(randomOption == 0){
                    reader = new Scanner(new File("christmas songs.txt")); // assignes this random file to the scanner
                    category = "Christmas Songs"; // assigns that file's corresponding category to the category variable
                } else if(randomOption == 1){
                    reader = new Scanner(new File("famous books.txt"));
                    category = "Famous Books";
                } else if(randomOption == 2){
                    reader = new Scanner(new File("slogans.txt"));
                    category = "Slogans";
                } else if(randomOption == 3){
                    reader = new Scanner(new File("celebrities.txt"));
                    category = "Celebrities";
                } else{
                    reader = new Scanner(new File("video games.txt"));
                    category = "Video Games";
                }
            }

            i = 0; // an iterator
            randomOption = (int)(Math.random()*50); // random integer to correspond to a random line
            if(choice != '6'){ // if the web page choice wasn't chosen
                while(reader.hasNext()){
                    if(i == randomOption){
                        myPhrase.setPhrase(reader.nextLine()); // sets myPhrase equal to a random line
                        break; // stops the while loop once the phrase is chosen
                    }
                    i++; // continues to add one until equivalent to the randomOption variable
                    reader.nextLine(); // goes to the next line until it has
                }
            } else{
                try{
                    myPhrase.setMoviePhrase(year); // sets the year to get the top movies
                } catch(Exception e){} // throws an exception in case java.lang messes up
            }
            boolean [ ] used = new boolean[255]; // a list of booleans corresponding to each character value

            if(myPhrase.getPhrase().indexOf(' ') > -1){
                guess = ' ';
                used[guess] = true;  // remembers that the character has been chosen
                myPhrase.find(Character.toLowerCase(guess)); // checks if the character is in the phrase
            }
            
            
            System.out.println("\n" + myPhrase.toString( )); // prints out a separator, the to be deciphered string, and the state of the hangman
            in.nextLine(); // goes to the next line
            while(!myPhrase.checkWin( ) && ! myPhrase.getGameOver( )) // while the user has neither won nor lost
            {
                do{
                    System.out.print("\nCategory: " + category); // reminds the user of the category chosen
                    System.out.print("\nEnter your character: "); // prompts user to guess a character within the phrase
                    guess = in.nextLine( ).charAt(0); // sets the guess to the first character input by the user
                    if(used[guess]) System.out.println("That letter already guessed."); // if it has been guessed, it tells the user
                }while (used[guess]); // while the character entered is not a new character chosen; ensured to run at least once each loop
                used[guess] = true;  // remembers that the character has been chosen
                myPhrase.find(Character.toLowerCase(guess)); // checks if the character is in the phrase
                System.out.println("\n" + myPhrase.toString( )); // prints the updated hangman assets
            }

            if(myPhrase.checkWin( )) // if the user has won
            {
                System.out.println("You got it!"); // victory message
            }
            System.out.println("Correct Answer: " + myPhrase.getPhrase() + "\n"); // shows the correct answer
            System.out.println("Game Over"); // game over message
            System.out.println("Game Over"); 
            System.out.println("Game Over"); 
            System.out.println("Game Over"); 
            
            System.out.print("\n\nPlay again? (y/n) ");
            choice = in.nextLine().charAt(0);
            System.out.println();
        }
    }
}
