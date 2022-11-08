
/**
 * Write a description of class CurrencyReaderDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class CurrencyReaderDriver
{
   public static void main(String[ ] args)throws Exception
   {
       CurrencyReader cr = new CurrencyReader( );
       System.out.println(cr.toString( ) );
       
       char choice = 'a';
       String newCur;
       Scanner in = new Scanner(System.in);
       while(choice != 'e' && choice != 'E'){
        System.out.println("Add new character (Any Button) Exit (e): ");
        choice = in.next().charAt(0);
        if(choice != 'e' && choice != 'E'){ 
                System.out.println("Name the new currency: ");
                in.nextLine();
                newCur = in.nextLine();
                cr.setAmount(newCur);
                System.out.println(cr.toString( ) );
        }
        }
    }
}
