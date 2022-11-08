
/**
 * Write a description of class PayCheck here.
 *
 * @author Austin Lowery
 * @version 31 Jan 2019
 */
public class PayCheck
{
    private String employeeName;
    private double rateOfPay;
    private double hoursWorked;
    private double grossPay;
    
    public PayCheck(){
        employeeName = "unknown";
        rateOfPay = hoursWorked = 0.0;
    }
    
    public PayCheck(String name, double pay, double hours){
        employeeName = name;
        rateOfPay = pay;
        hoursWorked = hours;
        calcGrossPay();
    }
    
    private void calcGrossPay(){
        if(hoursWorked <= 40) grossPay = rateOfPay * hoursWorked;
        else grossPay = rateOfPay * ( 40 + 1.5 * (hoursWorked - 40));
    }
    
    public void setName(String name){
        employeeName = name;
    }
    
    public void setPay(double pay){
        rateOfPay = pay;
        calcGrossPay();
    }
    
    
    public void setHours(double hours){
        hoursWorked = hours;
        calcGrossPay();
    }
    
    
    public String getName(){
        return employeeName;
    }
    
    public double getPay(){
        return rateOfPay;
    }
    
    public double getHours(){
        return hoursWorked;
    }
    
    public double getGrossPay(){
        return grossPay;
    }
}
