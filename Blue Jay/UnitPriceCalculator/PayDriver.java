
/**
 * Write a description of class PayDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class PayDriver
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String name;
        double pay;
        double hours;
        
        System.out.print("Input the Employee's Name: ");
        name = in.nextLine();
        
        System.out.print("Input the Rate of Pay: ");
        pay = in.nextDouble();
        
        System.out.print("Input the Hours Worked: ");
        hours = in.nextDouble();
        
        PayCheck employee = new PayCheck(name, pay, hours);
        printForm(employee);
        
        in.nextLine();
        System.out.print("\nSet new name for Employee: ");
        name = in.nextLine();
        
        System.out.print("Set new value for Pay: ");
        pay = in.nextDouble();
        
        System.out.print("Set new value for Worked: ");
        hours = in.nextDouble();
        
        employee = new PayCheck(name, pay, hours);
        printForm(employee);
        
    }
    
    public static void printForm(PayCheck employee){
        System.out.println("\nEmployee: " + employee.getName() +
                           "\nHours Worked: " + employee.getHours() +
                           "\nRate of Pay: " + employee.getPay() +
                           "\nGross Pay: $" + employee.getGrossPay());
    }
}
