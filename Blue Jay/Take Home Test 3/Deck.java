
/**
 * Creates of a deck of cards that can be shuffled and drawn from.
 *
 * @author Austin Lowery
 * @version 1 May 2019
 */
public class Deck
{
    private Card[] playingCards; // the cards in the deck
    private int subscript; // the value of the card at the top of the deck
    
    /**The no-args constructor creates an organized deck of cards.
     */
    public Deck(){
        playingCards = new Card[52]; // 52 cards in a deck
        char[] family = {'C','D','S','H'}; // the different suites
        for(int i = 0; i < family.length; i++){ // 4 suites to go through
            for(int j = 1; j <= 13; j++){ // 13 card values
                if(j == 1) // Ace
                    playingCards[i*13+j-1] = new Card(j+13,family[i],"Ace");
                else if(j == 11) // Jack
                    playingCards[i*13+j-1] = new Card(j,family[i],"Jack");
                else if(j == 12) // Queen
                    playingCards[i*13+j-1] = new Card(j,family[i],"Queen");
                else if(j == 13) // King
                    playingCards[i*13+j-1] = new Card(j,family[i],"King");
                else // 2-10
                    playingCards[i*13+j-1] = new Card(j,family[i],"None");
            }
        }
        subscript = playingCards[0].getValue();
    }

    /**Obtains a deep copy of the card on the top of the deck.
     *@return Card the card on the top of the deck
     */
    public Card getTopCard(){
        return new Card(playingCards[0]);
    }

    /**Switches the cards in two random placements in the deck 1,000 times to fully shuffle the deck.
     */
    public void shuffle(){
        // random numbers
        int randomNum1;
        int randomNum2;
        
        // holds the addresses for the cards at a random placement
        Card randPlacement1;
        Card randPlacement2;
        
        for(int j = 0; j < 1000; j++){ // shuffles 2 different cards in random spots
            // random placement in a 52 card deck
            randomNum1 = (int)(Math.random()*52);
            randomNum2 = (int)(Math.random()*52);
            
            // stores the addresses of the cards
            randPlacement1 = playingCards[randomNum1];
            randPlacement2 = playingCards[randomNum2];

            // switches the addresses in the deck
            playingCards[randomNum1] = randPlacement2;
            playingCards[randomNum2] = randPlacement1;
        }
        subscript = playingCards[0].getValue(); // updates the current top card value
    }
    
    /**Puts the card on the top of the deck at the bottom.
     */
    public void draw(){
        Card top = playingCards[0]; // stores the address of the top card
        for(int i = 0; i < playingCards.length-1; i++)
            playingCards[i] = playingCards[i+1]; // sets the current card to the address of the one after it
        playingCards[playingCards.length-1] = top; // makes the last card the original top card
    }
}