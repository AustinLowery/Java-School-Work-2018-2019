import java.net.*;
import java.io.*;
import java.util.*;
/**
 * The class GameWord creates objects and utilizes methods for the hangman game.
 * 
 * @author Austin Lowery
 * @version 2/23/2019
 */
public class GameWord
{
    private String phrase; // the phrase to be guessed
    private StringBuilder inProgress; // the set of underscores corresponding to the unknown character values in the phrase
    private int numberWrongGuesses; // stores the incorrect guess that, when the value hits 7, a game over occurs
    private StringBuilder state; // draws each hangman part as the number of wrong guesses go up
    private boolean gameOver; // the boolean storing whether or not the user has lost the game
    
    private URL famousMovies; //to hold the connection to the web site
    private URLConnection connection;//to hold the connection to the website
    private Scanner in;//to read the lines of data from the website

    /**This no-args constructor sets all fields to their default value.
     */
    public GameWord( )
    {
        inProgress = new StringBuilder( );
        phrase = new String( );
        numberWrongGuesses = 0;
        state = new StringBuilder( );
        gameOver = false; // by default, the user has not lost
    }
    
    /**This constructor takes in the phrase to guess, sets the inProgress field to a string containing 
     * the same amount of underscores as the phrase does variables, and sets every other field to 
     * their default value.
     *@param phraseToGuess the phrase used in the game of hangman
     */
    public GameWord(String phraseToGuess)
    {
        phrase = new String(phraseToGuess); // sets the phrase to a new string equivalent to the phraseToGuess parameter
        state = new StringBuilder( );
        inProgress = new StringBuilder( );
        for(int k = 0; k < phrase.length( ); k++) // for each character in phrase, append an underscore to in progress
        {
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0;
        gameOver = false; // by default, the user has not lost
    }
    
    /**This set method setMoviePhrase gets one of the top ten movies from wikipedia from a specific year and makes it 
     * the phrase for the hangman game.
     *@param year the year chosen for which the top films are picked
     *@throws Exception
     */
    public void setMoviePhrase(int year) throws Exception{
        famousMovies = new URL("https://en.wikipedia.org/wiki/" + year +"_in_film"); // sets the page to find the top movies
        connection = famousMovies.openConnection(); // connects to the page
        in = new Scanner(new InputStreamReader(connection.getInputStream())); // scanner for the webpage
        
        int posFirst = -1; // finds the position before the first character in the title
        int posSecond = -1; // finds the position after the last character in the title
        String inputLine = new String(" "); // makes inputLine a blank string
        
        int randomMovie = (int)(Math.random()*10); // sets a random value for what movie to choose
        for(int i = 0; i < randomMovie; i++){ // continues looping a random amount to choose the movie
            do {
                inputLine = in.nextLine(); // moves to the next line until it hits the line with the title
            } while(!(inputLine.contains("<td><i>")));
        }
        
        posFirst = inputLine.indexOf("\">",1); // sets the first position
        posSecond = inputLine.indexOf("</",1); // sets the second position
        setPhrase(new String(inputLine.substring(posFirst+2,posSecond)).toLowerCase()); // gets the substring of the line and sets it to lowercase
    }

    /**The set method setPhrase creates a new phrase for the game updating each respective field.
     *@param phraseToGuess the phrase used in the game of hangman
     */
    public void setPhrase(String phraseToGuess)
    {
        phrase = new String(phraseToGuess); // sets the phrase to a new string equivalent to the phraseToGuess parameter
        state = new StringBuilder( );
        inProgress = new StringBuilder( );
        for(int k = 0; k < phrase.length( ); k++) // for each character in phrase, append an underscore to in progress
        {
            inProgress.append( "_ ");
        }
        numberWrongGuesses = 0;
        state = new StringBuilder( );
        gameOver = false; // by default, the user has not lost
    }

    /**This get method returns the phrase to the user.
     *@return phrase - the phrase that is guessed in the hangman game.
     */
    public String getPhrase( ){
        return phrase;
    }
    
    /**The get method getGameOver returns whether or not the user has lost.
     *@return gameOver - boolean storing whether or not the user has lost.
     */
    public boolean getGameOver( )
    {
        return gameOver;
    }

    /**The method find is used to check if the character guessed is within the phrase.
     *@param symbol the symbol representing the guessed character within the phrase.
     */
    public void find(char symbol)
    {
        int count = 0; // counter indicating the amount of that character in the phrase
        int pos = 0; // position of each guessed character
        pos = phrase.indexOf(symbol); // returns the index of the character in the phrase; returns -1 if character not in phrase
        while(pos != -1) // while a character still remains in the index of the phrase
        { 
            count++; // count incremented each time to ensure it has a non zero value for when if statement below is checked
            inProgress.setCharAt(pos*2,symbol); // sets the underscore to the character in the phrase
            pos = phrase.indexOf(symbol, pos + 1);; // pos is continually checking for the character until the index becomes -1
        }
        if(count == 0) // if the count was never incremented
        {
            numberWrongGuesses++; // adds to the wrong number of guesses
            updateState( ); // updates the hangman to add another body part
        }

    }

    /**This method returns true if all characters in the phrase has been guessed, otherwise, it returns false
     *@return match - the boolean value used to determine if the game has been won or not.
     */
    public boolean checkWin( )
    {
        boolean match = true; // set to true by default
        
        /* k and m start at 0 continuing until each character is the phrase has been looped through
         * k is the index of the phrase and m is the index of the underscore
         * 2 is added to m since every other character in the inProgress StringBuilder is an underscore */
        for(int k = 0, m = 0; k < phrase.length( ) && match; k++, m += 2)
        {
            if(phrase.charAt(k) != inProgress.charAt(m)) // if character in phrase's position is equal to the character to the inProgress position
            {
                match = false; // set to false unless all characters are equal

            }
        }
        return match; // returns the result
    }

    /**The method updateState adds a body part to the state of the hangman dependent on the number of wrong guesses made. 
     * If seven are made, it results in a game over.
     */
    private void updateState( )
    { 

        switch(numberWrongGuesses)
        {
            case 1: state.append("\n\t\t\t\t\t 0"); // the head
            break;
            case 2: state.append( "\n\t\t\t\t       /"); // the left arm
            break;
            case 3: state.append(" |"); // the top of the chest
            break;
            case 4: state.append( " \\"); // the right arm
            break;
            case 5: state.append("\n\t\t\t\t         |"); // the bottom of the chest
            break;
            case 6: state.append("\n\t\t\t\t        /"); // the left leg
            break;
            case 7: state.append(" \\\n\n\t\t\t\t      OH NO!!\n"); // the right leg and an OH NO message
            gameOver = true; // the user has lost after 7 wrong answers

        }
    }

    /**This method returns a string with a separator, the phrase that is in the progress of being deciphered, and the state of the hangman.
     *@return String - a string representing the printed output of the game to the user.
     */
    public String toString(  )
    {
        return new String("\n***************************************\n" 
            + inProgress + "\n" + state.toString( ));
    }
}