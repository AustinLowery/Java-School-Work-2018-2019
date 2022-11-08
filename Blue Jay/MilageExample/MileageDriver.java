
/**
 * This class used the MileageCalculator
 * to allow the user to calculate gas mileage.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class MileageDriver
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        /*
         * java.util.Scanner in = new java.util.Scanner(System.in);
         */
        MilageCalculator milesPerGalCalc = new MilageCalculator(345,8);
        
        double miles;
        double gasAmount;
        char goAgain = 'y';
        
        while(goAgain == 'y'){
        System.out.print("Enter the miles you drove: ");
        miles = in.nextDouble();
        
        System.out.print("Enter the gas used in gallons: ");
        gasAmount = in.nextDouble();
        
        milesPerGalCalc.setMilesDriven(miles);
        milesPerGalCalc.setGallonsConsumed(gasAmount);
        
        System.out.println(milesPerGalCalc.toString());
        
        System.out.print("Enter y to do another calculation, anything else to quit: ");
        goAgain = in.next().charAt(0);
    }
    
    System.out.println("Calculations Complete.");
    
    }
}
