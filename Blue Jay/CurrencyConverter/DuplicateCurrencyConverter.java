
/**
 * The class of DuplicateCurrencyConverter
 * converts money values
 *
 * @author Austin Lowery
 * @version 28 Jan 2019
 */
public class DuplicateCurrencyConverter
{
    // current amount of money
    private double yenAmount;
    private double euroAmount;
    private double poundAmount;
    private double bitCoinAmount;
    private double dollarAmount;
    
    private final double YEN_TO_DOLLAR = .00913;
    private final double EURO_TO_DOLLAR = 1.14048;
    private final double POUND_TO_DOLLAR = 1.31952;
    private final double BITCOIN_TO_DOLLAR = 3567.21;
    
    public DuplicateCurrencyConverter(){
        yenAmount = euroAmount = poundAmount = bitCoinAmount = dollarAmount = 0;
    }
    
    public DuplicateCurrencyConverter(double inAmount, char inChoice){
        setAmount(inAmount, inChoice);
    }
    
    public void setAmount(double inAmount, char inChoice){
        switch(inChoice){
            case 'y':
            dollarAmount = inAmount * YEN_TO_DOLLAR;
            break;
            case 'e':
            dollarAmount = inAmount * EURO_TO_DOLLAR;
            break;
            case 'p':
            dollarAmount = inAmount * POUND_TO_DOLLAR;
            break;
            case 'b':
            dollarAmount = inAmount * BITCOIN_TO_DOLLAR;
            break;
            case 'd':
            dollarAmount = inAmount;
            break;
        }
        
        yenAmount = dollarAmount / YEN_TO_DOLLAR;
        euroAmount = dollarAmount / EURO_TO_DOLLAR;
        poundAmount = dollarAmount / POUND_TO_DOLLAR;
        bitCoinAmount = dollarAmount / BITCOIN_TO_DOLLAR;
    }
    
    public String toString(){
        return "Dollars: " + dollarAmount +
               "\nYen: " + yenAmount +
               "\nEuro: " + euroAmount +
               "\nPound: " + poundAmount +
               "\nBitCoin: " + bitCoinAmount;
    }
}
