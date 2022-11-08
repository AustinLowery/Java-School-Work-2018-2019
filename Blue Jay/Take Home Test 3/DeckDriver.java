
/**
 * Creates a deck of cards, shuffles them, and tells of the top two card.
 *
 * @author Austin Lowery
 * @version 23 Apr 2019
 */
public class DeckDriver
{
    /**Lists a deck of cards, lists a deck of shuffled cards, and prints the first two cards.
     *@param String[] a list of passed in arguments
     */
    public static void main(String[] args){
        Deck cards = new Deck();
        
        System.out.println("List of Sorted Cards: ");
        for(int i = 0; i < 52; i++){ // prints all 52 cards
            System.out.println(cards.getTopCard()); // prints the top card
            cards.draw(); // draws another card
        }
        
        System.out.println("\nList of Shuffled Cards: ");
        cards.shuffle(); // shuffles the cards
        for(int i = 0; i < 52; i++){ // prints all 52 cards
            System.out.println(cards.getTopCard()); // prints the top card
            cards.draw(); // draws another card
        }
        
        System.out.println("\nTop Card: " + cards.getTopCard()); // gets the top card
        cards.draw(); // draws
        System.out.println("Second Card: " + cards.getTopCard()); // gets the top card after a draw
    }
}
