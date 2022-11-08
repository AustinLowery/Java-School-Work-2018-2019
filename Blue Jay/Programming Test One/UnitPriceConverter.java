
/**
 * The class UnitPriceConverter calculates the price per pound and of ounces
 * given an input of the price and weight of an item.
 *
 * @author Austin Lowery
 * @version 17 Feb 2019
 */
public class UnitPriceConverter
{
    private double priceOfItem; // the price brought in by the constructor
    private double weightInPound; // the weight brought in by the constructor
    private double pricePerPound; // the cost for an item for each pound
    private double pricePerOunce; // the cost for an item for each ounce
    private final double OUNCES_PER_POUND = 16; // a constant for the conversion 
    
    /**The no-args constructor sets the values of the price and weight fields
     * to zero
     */
    public UnitPriceConverter(){
        // all prices and the weight set to zero
        priceOfItem = weightInPound = pricePerPound = pricePerOunce = 0;
    }
    
    /**This constructor takes in a price and weight then calls the private calculatePricePerWeight method for
     * calculating the price per pound and ounce
     *@param price the cost of an item for weightInPounds pounds of that item 
     *@param weight the weight of the item
     */
    public UnitPriceConverter(double price, double weight){
        // sets the priceOfItem and weightOfItem to the input variables
        priceOfItem = price;
        weightInPound = weight;
        
        // calculates the price per pounds and ounces
        calculatePricePerWeight(priceOfItem, weightInPound);
    }
    
    
    /**The calculatePriceWeight takes the price of the item, divides it by the weight in pounds, and stores the 
     * value into the pricePerPound and a 16th of the pricePerPound is stored to the pricePerOunce
     * The constant OUNCES_PER_POUND is equal to 16
     *@param price the cost of an item for weightInPounds pounds of that item
     *@param weight the weight of the item
     */
    private void calculatePricePerWeight(double price, double weight){
        // sets the pricePerPound to the price divided by the weight
        pricePerPound = priceOfItem / weightInPound;
        // sets pricePerOunce to the pricePerPound divided by 16 (constant OUNCES_PER_POUND)
        pricePerOunce = pricePerPound / OUNCES_PER_POUND;
    }
    
    
    /**The setPrice method stores the parameter, price, to priceOfItem<br>
     * The price per pound and ounce are also recalculated
     *@param price the new cost of the item for weightInPound pounds of that item
     */
    public void setPrice(double price){
        priceOfItem = price;
        calculatePricePerWeight(priceOfItem, weightInPound);
    }
    
    /**The setWeight method stores the parameter, weight, to weightInPound<br>
     * The price per pound and ounce are also recalculated
     *@param weight the new weight of the item
     */
    public void setWeight(double weight){
        weightInPound = weight;
        calculatePricePerWeight(priceOfItem, weightInPound);
    }
    
    
    /**The method getPrice is a get method returning the priceOfItem
     *@return priceOfItem - the cost of an item for weightInPounds pounds of that item
     */
    public double getPrice(){
        return priceOfItem;
    }
    
    /**The method getWeight is a get method returning the weightInPound
     *@return weightInPound - the weight of an item
     */
    public double getWeight(){
        return weightInPound;
    }
    
    /**The method getPricePerPound is a get method returning the pricePerPound
     *@return pricePerPound - the cost of an item for each pound 
     */
    public double getPricePerPound(){
        return pricePerPound;
    }
    
    /**The method getPricePerOunce is a get method returning the pricePerOunce
     *@return pricePerOunce - the cost of an item for each ounce 
     */
    public double getPricePerOunce(){
        return pricePerOunce;
    }
}
