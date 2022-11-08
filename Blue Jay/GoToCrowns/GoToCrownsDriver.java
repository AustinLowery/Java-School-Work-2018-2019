import java.util.Scanner;
/**
 * The class GoToCrowns asks Obinna if he wants to go to Crowns for lunch 
 * at 12:15
 *
 * @author Austin Lowery
 * @version 2/22/2019
 */
public class GoToCrownsDriver
{
    public static void main(String args){
        Scanner in = new Scanner(System.in); // brings in a Scanner
        GoToCrowns request = new GoToCrowns(); // creates new GoToCrowns object
        request.setRequestee("Obinna"); // the request is being sent to Obinna
        request.setTime("12:20"); // the time to go to crowns
        char choice;
        System.out.print("Hey " + request.getRequestee() + ", do you want to go to crowns at(y/n)? ");
        choice = in.next().charAt(0); // choice to go to crowns or not
        if(Character.toUpperCase(choice) == 'y'){ // checks if choice is uppercase or lowercase y
            request.setRequesteeLoc("at Crowns");
        } else{
            request.setRequesteeLoc("wherever he is now or wants to be");
        }
        System.out.println(request.getRequestee() + " has decided to be " + request.getRequesteeLoc() +
            " at " + request.getTime() + "."); // prints the requestees decision
    }
}
