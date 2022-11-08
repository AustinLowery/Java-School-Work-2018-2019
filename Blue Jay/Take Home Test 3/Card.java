
/**
 * Creates a single playing card that has a value, suit, and a face of a normal card deck.
 *
 * @author Austin Lowery
 * @version 1 May 2019
 */
public class Card
{
    private int value; // a number between 1 and 13
    private String suit; // heart, club, spade, or diamond
    private String face; // a card that is an ace, jack, queen, or king; none is attributed to this value if the card isn't any of those

    /**The no-args constructor creates a Two of Hearts by default.
     */
    public Card(){
        value = 2;
        suit = "Hearts";
        face = "Two";
    }

    /**The copy constructor creates a deep copy of a passed in Card object.
     *@param Card a card to copy
     */
    public Card(Card other){
        value = other.value;
        suit = other.suit;
        face = other.face;
    }

    /**This constructor takes in a value, a suit, and a face. The value passed must be between 1 and 13 inclusively. The passed in value goes unused if the face is
     * defined. For example, if some valid number, n, is passed in, and a recognized face is passed in, say "King", the value will become to 13 and the face will be a King. If 
     * the face is unrecognized, the number will determine what face was put in.
     *@param int the value of the card (goes unused if the face is defined)
     *@param char the suit of the card; becomes a Heart card if left undefined
     *@param String the face of the card (takes presedence over the value if defined)
     */
    public Card(int inValue, char inSuit, String inFace){
        face = inFace;
        String[] faceArr = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
        for(int i = 0; value == 0; i++){
            if(i < faceArr.length && face.equals(faceArr[i])) // if the face is defined, set the value to it's respective value
                value = i+2; // value is two plus whatever the placement of the array element is
            else if(i >= faceArr.length){ // if the face isn't defined, set the value to the input value and the face with respect to the value
                value = (inValue >= 2 && inValue <= 14)?inValue:2; // if value not defined, set to a default of two
                face = faceArr[value-2];
            }
        }
        
        
        switch(inSuit){
            case 'C': // c for clubs
            suit = "Clubs";
            break;
            
            case 'D': // d for diamonds
            suit = "Diamonds";
            break;
            
            case 'S': // s for spades
            suit = "Spades";
            break;
            
            default: // by default it will be hearts
            suit = "Hearts";
        }
    }

    /**Gets the value of a card.
     *@return int - the value of the card
     */
    public int getValue(){
        return value;
    }

    /**Gets the suit of a card.
     *@return String - the suit of the card
     */
    public String getSuite(){
        return suit;
    }

    /**Gets the face of a card.
     *@return String - the face of the card
     */
    public String getFace(){
        return face;
    }

    /**Compares two cards using their values. It will return -1 if the caller is less than the passed in card object, 0 if the caller is equal, and 1 if the caller is more.
     *@param Card card to compare to the caller
     *@return int - value that tells of the comparison
     */
    public int compareTo(Card other){
        return this.value-other.value; // will be negative if smaller, 0 if equal, and positive if greater
    }

    /**Compares two cards using their values and suit.
     *@param Card card to compare to the caller
     *@return boolean - value that tells of it's equavalence
     */
    public boolean equals(Card other){
        return this.face.equals(other.face) && this.suit == other.suit;
    }

    /**Returns a string representation of the card.
     *@return String - the face and suit used to represent the card
     */
    public String toString(){
        return face + " of " + suit;
    }
}
