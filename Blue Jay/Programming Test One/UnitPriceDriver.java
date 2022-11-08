
/**
 * The class UnitPriceDriver asks the user for the price of an item
 * and weight in pounds of an item then calculates price per pound
 * and ounce. The program continues to the user's discretion. This
 * class creates an object of the UnitPriceConverter class to do said
 * calculations.
 *
 * @author Austin Lowery
 * @version 17 Feb 2019
 */
import java.util.Scanner; // imports the scanner
public class UnitPriceDriver
{
    /**The method main uses a Scanner and UnitPriceConverter object to ask
     * the user for a price and weight to set so that price per pound and ounce
     * of that item is returned.
     *@param args[] a list of strings input when the method is started but goes unused 
     */
    public static void main(String args[]){
        // new UnitPriceConverter object
        UnitPriceConverter item = new UnitPriceConverter();
        // creates a scanner
        Scanner in = new Scanner(System.in);
        // choice that determines if the loop continues
        char choice = 'y';
        
        while(choice == 'y'){
            // asks the user the price of the item
            System.out.print("Enter the price of the item: $");
            item.setPrice(in.nextDouble());
            
            // asks the user the weight of the item
            System.out.print("Enter the weight of the item in pounds: ");
            item.setWeight(in.nextDouble());
            
            // prints out what user typed in for the price and weight
            System.out.println("\nPrice for " + item.getWeight() + " lbs of the item: $" + item.getPrice());
            // prints the price per pound and ounce
            System.out.println("Price per pound: $" + item.getPricePerPound());
            System.out.println("Price per ounce: $" + item.getPricePerOunce());
            
            // asks the user if the program should run again
            System.out.print("\nWould you like to run again (y/n): ");
            choice = in.next().charAt(0);
            System.out.println();
        }
        // goodbye message
        System.out.println("Goodbye User.");
    }
}
