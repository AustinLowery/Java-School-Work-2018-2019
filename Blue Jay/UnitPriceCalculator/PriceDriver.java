
/**
 * The class PriceDriver creates an
 * object off the blueprint of
 * the UnitPriceCalculator class
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class PriceDriver
{
    public static void main(String args[]){
        double cost;
        double mass;
        char choice = 'y';
        UnitPriceCalculator groceryItem = new UnitPriceCalculator();
        
        Scanner in = new Scanner(System.in);
        
        while(choice == 'y'){
            System.out.print("Enter the cost of the item: $");
            cost = in.nextDouble();
            
            System.out.print("\nEnter the weight of the item: ");
            mass = in.nextDouble();
            
            System.out.print("\nWeight in pounds or ounces? (o/p): ");
            choice = in.next().charAt(0);
            
            groceryItem.setPrice(cost);
            groceryItem.setWeight(mass);
            groceryItem.setPoundsOrOunces(choice);
            
            System.out.println("\n" + groceryItem.toString());
            
            System.out.println("\nWould you like to put in another item? (y/n): ");
            choice = in.next().charAt(0);
        }
    }
}
