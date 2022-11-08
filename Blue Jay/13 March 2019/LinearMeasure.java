
/**
 * This class has methods to allow a user to perform calculations
 * with linear measurements.
 * 
 * Its purpose is to illustrate object references as both
 * parameters and return values in methods.
 * 
 * @author L. Lehmann 
 * @version v1
 */
public class LinearMeasure
{
   private int feet;
   private double inches;
   private double totalInches;
   /**
    * The default constructor sets all the measures to zero.
    */
    public LinearMeasure()
    {
   
       totalInches = inches = feet = 0;
    
      } 
    
    /**
     * This constructor allows the user to send in a total number of inches.
     * It then uses this value to break that amount up into feet and inches.
     *  @param double total number of inches for the LinearMeasure object
     */
    public LinearMeasure (double inInches)
    {
        totalInches = inInches;
        simplify( ); //the simplify method calculates the feet and inches using the total inches
    }
    
    /**
     * This constructor accepts the measurement broken up into the components of
     * feet and inches. It then caluclates the total number of inches.
     * @param int the number of integer feet in the measure
     * @param the number of additional inches (as a double)
     */
    public LinearMeasure(int inFeet, double inInches)
    {
        totalInches = inFeet * 12 + inInches;
        simplify( );
    }
    
    /**
     * This is the copy constructor. It is used
     * to create a new LinearMeasure object using the data
     * from an exisitng lInearMeasure object.
     * @param a reference to an exisiting LinearMeasure Object
     */
    public LinearMeasure (LinearMeasure lm)
    {
        this.totalInches = lm.totalInches;
        simplify( );
    }
    
    //This is a private utility method for the class.
    //It is called to adjust the integer feet and the leftover inches
    //fields usng the total number of inches for the LinearMeasure.
    private void simplify( )
    {
        //typecast the totalInches field to be used as a integer in
        //this calculation so that integer division will be performed
        feet = (int)totalInches/12;
        inches = totalInches % 12;
    }
    
    /**
     * This method multiplies the current measure by a factor and uses that 
     * value for total inches to create a new LinearMeasure object. 
     * It returns a reference to the new LinearMeasure object created.
     * @param a double used as the multiplication factor
     * @return a reference to a newly created LinearMeasure object
     * 
     */
    public LinearMeasure multiply(double factor)
    {
        //This line calls the constructor that accepts a double
        //reresenting the total inches and returns a reference to the
        //newly created LinearMeasure object.
       return new LinearMeasure(this.totalInches * factor);
         
     }
     public LinearMeasure add(double amount)
    {
      
       
        return new LinearMeasure(this.totalInches + amount);
       
     }
    
    /**
     * This method divides the current measure by a factor and uses that 
     * value for a total inches amount to create a new LinearMeasure object. 
     * It returns a reference to the new LinearMeasure object created.
     * @param a double used as the dividend 
     * @return a reference to a newly created LinearMeasure object
     * 
     */
     public LinearMeasure divide(double factor)
    {
        //This line calls the constructor that accepts a double
        //reresenting the total inches and returns a reference to the
        //newly created LinearMeasure object.
        return new  LinearMeasure(totalInches/ factor);
    }
    
    /** 
     * The toString method returns a textual representation of the current object.
     * @return a String representing the state of the LinearMeasure object.
     */
    public String toString( )
    {
        return "Feet: " + feet + "\tInches: " + inches;
    }
    
    /**
     * The equals( ) method determines if another LinearMeasure
     * object should be considered eaul to the current
     * object based on the value of the totalInces fields.
     * @param a reference to another LinearMeasure object to compare with the 
     * current LinearMeasure object.
     * @return a boolean which is true of the two LineasrMeasure have the
     * same value for the totalInches field.
     */
    public boolean equals(LinearMeasure other)
    {
        return this.totalInches == other.totalInches;
    }
    
     /**
     * The compareTo( ) method determines if the current LinearMeasure
     * object should be considered greater than, equal to, or less than
     * another LinearMeasure object based on the values  of the
     * totalInches field.
     * @param a reference to another LinearMeasure object
     * @return an int which is positive if this current LinearMeasure
     * object has the same value for totalInches as the parameter's
     * totalInches, returns 0 if the two LinearMeasure objects have
     * the same value for their totalInches fields and returns a negative
     * integer if the current LinearMeasure's totalInches field is less
     * than the value of the parameter's totalInches field.
     * 
     */
    public int compareTo(LinearMeasure other)
    {
        int result;
        
        if(this.totalInches > other.totalInches)
          result = 1;
        else if (this.totalInches == other.totalInches)
         result =  0;
        else result =  -1;
        
        return result;
    }
    
    
    
    
    
    
    
    
    
        
        
       
       
      
 }



