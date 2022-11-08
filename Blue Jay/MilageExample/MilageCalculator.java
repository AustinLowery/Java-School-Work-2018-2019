 /**
 * This class used the MileageCalculator
 * to allow the user to calculate gas mileage.
 *
 * @author Austin Lowery supervised by Professor Leighman
 * @version 16 Jan 2O19
 */
public class MilageCalculator
{
    // a class definition file is made up of fields and methods
    private double milesDriven;
    private double gallonsConsumed;
    private double gasMilage;
    
    // the constructor method is used to build or construct an object from a class definition file; builds objects
    // the constructor method has the EXACT same name as the class definition and no return type
    // purpose: give the field their starting values
    public MilageCalculator(double inMiles, double inGallons){
        milesDriven = inMiles;
        gallonsConsumed = inGallons;
        gasMilage = milesDriven/gallonsConsumed;
    }
    
    public MilageCalculator(){
        milesDriven = 0;
        gallonsConsumed = 0;
        gasMilage = 0;
    }
    
    public void setMilesDriven(double inMiles){
        milesDriven = inMiles;
        gasMilage = milesDriven/gallonsConsumed;
    }
    
    public void setGallonsConsumed(double inGallons){
        gallonsConsumed = inGallons;
        gasMilage = milesDriven/gallonsConsumed;
    }
    
    // get methods
    public double getMilesDriven(){
        return milesDriven;
    }
    
    public double getGallonsConsumed(){
        return gallonsConsumed;
    }
    
    public double gasMilage(){
        return gasMilage;
    }
    
    public String toString(){
        return "Miles Driven: " + milesDriven + 
               "\n Gas Used: " + gallonsConsumed +
               "\nMilage: " + gasMilage;
    }
}
