
/**
 * The class GroceryItem is
 * a class blueprint that is
 * used to find and report unit 
 * prices on grocery items.
 *
 * @author Austin Lowery
 * @version 30 Jan 2019
 */
public class UnitPriceCalculator  
{
    private final double CONVERT = 16;
    
    private char poundsOrOunces;
    private double price;
    private double weight;
    
    private double pricePerPound;
    private double pricePerOunce;
    
    public UnitPriceCalculator  (){
        poundsOrOunces = 'N';
        price = weight = pricePerPound = pricePerOunce = 0.0;
    }
    
    public UnitPriceCalculator  (double cost, double mass, char choice){
        if(cost < 0) cost = 0;
        if(mass < 0) mass = 0;
        
        price = cost;
        weight = mass;
        poundsOrOunces = choice;
        setPricePerWeight();
    }
    
    private void setPricePerWeight(){
        switch(poundsOrOunces){
            case 'p':
            pricePerPound = price / weight;
            pricePerOunce = pricePerPound / CONVERT;
            break;
            
            case 'o':
            pricePerOunce = price / weight;
            pricePerPound = pricePerOunce * CONVERT;
            break;
        }
    }
    
    
    public void setPrice(double cost){
        price = cost;
        setPricePerWeight();
    }
    
    public void setWeight(double mass){
        weight = mass;
        setPricePerWeight();
    }
    
    public void setPoundsOrOunces(char units){
        poundsOrOunces = units;
        setPricePerWeight();
    }
    
    
    public double getPrice(){
        return price;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public double getPricePerPound(){
        return pricePerPound;
    }
    
    public double getPricePerOunce(){
        return pricePerOunce;
    }
    
    public char getPoundsOrOunces(){
        return poundsOrOunces;
    }
    
    public String toString(){
        return "Original Price: " + price +
               "\nOriginal Weight: " + weight +
               "\nOriginal Weight Type: " + poundsOrOunces +
               "\nPrice Per Pound: " + pricePerPound +
               "\nPrice Per Ounce: " + pricePerOunce;
    }
}
