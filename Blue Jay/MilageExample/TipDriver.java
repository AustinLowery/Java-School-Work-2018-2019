
/**
 * Write a description of class TipDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipDriver
{
    public static void main(String args[]){
        TipCalculator firstPurchase = new TipCalculator(30.50, .15);
        System.out.println(firstPurchase.toString());
    }
}
