
/**
 * Plays a game of War.
 *
 * @author Austin Lowery
 * @version 1 May 2019
 */
public class War
{
    /**Runs the game of War
     *@param String[] a list of string arguments passed in
     */
    public static void main(String[] args){
        Deck warDeck = new Deck();
        warDeck.shuffle();

        int cardEarnings; // the amount of cards earned that round

        int playerOneEarnings = 0; // cards that player one wins
        int playerTwoEarnings = 0; // cards that player two wins

        int winner; // value of the compared player one card and player two card

        Card playerOneDraw; // card drawn by player one that round
        Card playerTwoDraw; // card drawn by player two that round

        int warCount; // will usually be 8 unless less than 8 cards remain

        System.out.println("Game of War: Begin");

        for(int i = 1; playerOneEarnings+playerTwoEarnings < 52; i++){ // goes through the cards until each player has the entire deck
            cardEarnings = 2;

            System.out.println("\nROUND " + i + ":"); // gives the round

            playerOneDraw = warDeck.getTopCard();
            System.out.println("Player one draws... the " + playerOneDraw + "!");

            warDeck.draw();

            playerTwoDraw = warDeck.getTopCard();
            System.out.println("Player two draws... the " + playerTwoDraw + "!");

            do{
                winner = playerOneDraw.compareTo(playerTwoDraw);
                if(winner > 0){
                    System.out.println("\nThe " + playerOneDraw + " defeats the " + playerTwoDraw + "! Player One wins Round " + i + "!\nTotal Earnings: " + cardEarnings);
                    playerOneEarnings += cardEarnings;
                }
                else if(winner < 0){
                    System.out.println("\nThe " + playerTwoDraw + " defeats the " + playerOneDraw + "! Player Two wins Round " + i + "!\nTotal Earnings: " + cardEarnings);
                    playerTwoEarnings += cardEarnings;
                } else if(playerOneEarnings+playerTwoEarnings+cardEarnings >= 52 && playerOneEarnings+playerTwoEarnings != 52){ // if the last game is a draw and no cards left
                    System.out.println("\nNo clear winner! Cards distributed evenly among players.");
                    playerOneEarnings += cardEarnings/2;
                    playerTwoEarnings += cardEarnings/2;
                    
                    winner = 1; // ensures the loop exits
                }else{ // while 8 cards still remain
                    if(playerOneEarnings+playerTwoEarnings+cardEarnings > 44) // if there are less than 8 cards remaining
                        warCount = 52-playerOneEarnings-playerTwoEarnings-cardEarnings;
                    else
                        warCount = 8;
                        
                    cardEarnings += warCount;

                    System.out.println("\nIt's War!!!");
                    System.out.println("I\nDE-\nCLARE\nWAR!!!");

                    for(int j = 0; j < warCount-1; j++) // draws the necessary number of cards for a war
                        warDeck.draw();

                    // player one uses the seventh card in a war under normal circumstances; in others, it's first of the remaining 2 cards of the deck
                    playerOneDraw = warDeck.getTopCard();
                    System.out.println("\nPlayer one draws... the " + playerOneDraw + "!");

                    warDeck.draw();

                    // player one uses the eighth card in a war under normal circumstances; in others, it's last remaining card of the deck
                    playerTwoDraw = warDeck.getTopCard();
                    System.out.println("Player two draws... the " + playerTwoDraw + "!");
                }
            } while(winner == 0); // will continue running until all wars are done

            // prints the points
            System.out.println("\nPlayer One: " + playerOneEarnings + " cards.");
            System.out.println("Player Two: " + playerTwoEarnings + " cards.");

            warDeck.draw(); // draws player one card for next round
        }
        
        System.out.println("\n*****************************************************************");
        
        if(playerOneEarnings > playerTwoEarnings)
            System.out.println("\nPlayer One wins with a total of " + playerOneEarnings + " cards!");
        else if(playerOneEarnings < playerTwoEarnings)
            System.out.println("\nPlayer Two wins with a total of " + playerTwoEarnings + " cards!");
        else
            System.out.println("\nIt's a tie! Both players earned " + playerOneEarnings + " cards!");
    }
}
