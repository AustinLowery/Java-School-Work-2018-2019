
/**
 * Write a description of class DuplicateCurrencyDriver here.
 *
 * @author Austin Lowery
 * @version 28 Jan 2019
 */
public class DuplicateCurrencyDriver
{
    public static void main(String[] args){
        DuplicateCurrencyConverter cc = new DuplicateCurrencyConverter();
        
        System.out.println(cc.toString());
        
        cc.setAmount(800,'d');
        
        System.out.println("\n" + cc.toString());
    }
}
