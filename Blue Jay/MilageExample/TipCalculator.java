/**
 * Write a description of class TipDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TipCalculator
{
    private double cost;
    private double tipRate;
    private double tipAmount;
    private double total;
    
    public TipCalculator(double costAmount, double tipPercent){
        cost = costAmount;
        tipRate = tipPercent;
        tipAmount = tipPercent * costAmount;
        total = tipAmount + costAmount;
    }
    
    public String toString(){
        return "Cost: " + cost + "\nTip Rate: " + tipRate + "\nTip Amount: " + tipAmount + "\nTotal: " + total;
    }
}
