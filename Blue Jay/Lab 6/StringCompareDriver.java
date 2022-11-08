import java.util.Scanner;
/**
 * Write a description of class StringCompareDriver here.
 *
 * @author Austin Lowery
 * @version 3/3/2019
 */
public class StringCompareDriver
{
    public static void main(String args[]) throws Exception{
        MyStringMethods s1 = new MyStringMethods();
        MyStringMethods s2 = new MyStringMethods();
        char choice = 'y';
        char choice2;
        int number;
        int anotherNumber;
        int userResponse;
        Scanner in = new Scanner(System.in);
        
        while(choice == 'y'){
            System.out.println("Choose a function to complete (Enter an integer): ");
            System.out.println("\t0. String.charAt(index)");
            System.out.println("\t1. String.equals(otherString)");
            System.out.println("\t2. String.compareTo(otherString)");
            System.out.println("\t3. String.compareToIgnoreCase(otherString)");
            System.out.println("\t4. String.replace(oldChar,newChar)");
            System.out.println("\t5. String.toUpperCase()");
            System.out.println("\t6. String.toLowerCase()");
            System.out.println("\t7. String.indexOf(character)");
            System.out.println("\t8. String.lastIndexOf(character)");
            System.out.println("\t9. String.substring(start,end)\n");
            choice = in.nextLine().charAt(0);
            
            switch(choice){
                case '0':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.print("Find character at this index: ");
                userResponse = in.nextInt();
                System.out.println("Character at Index: " + s1.charAt(userResponse));
                System.out.println("Actual CharAt: " + s1.getString().charAt(userResponse));
                in.nextLine();
                break;
                
                case '1':
                System.out.print("String One: ");
                s1.setString(in.nextLine());
                System.out.print("String Two: ");
                s2.setString(in.nextLine());
                System.out.println("Equal Strings? " + s1.equals(s2));
                System.out.println("Actual equals: " + s1.getString().equals(s2.getString()));
                break;
                
                case '2':
                System.out.print("String One: ");
                s1.setString(in.nextLine());
                System.out.print("String Two: ");
                s2.setString(in.nextLine());
                System.out.println("Compare To Value: " + s1.compareTo(s2));
                System.out.println("Actual compareTo: " + s1.getString().compareTo(s2.getString()));
                break;
                
                case '3':
                System.out.print("String One: ");
                s1.setString(in.nextLine());
                System.out.print("String Two: ");
                s2.setString(in.nextLine());
                System.out.println("Compare To Ignore CaseValue: " + s1.compareToIgnoreCase(s2));
                System.out.println("Actual compareToIgnoreCase: " + s1.getString().compareToIgnoreCase(s2.getString()));
                break;
                
                case '4':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.print("Character to replace: ");
                choice = in.nextLine().charAt(0);
                System.out.print("Character to replace it with: ");
                choice2 = in.nextLine().charAt(0);
                System.out.println("New String with character replacements: " + s1.replace(choice,choice2));
                System.out.println("Actual replace: " + s1.getString().replace(choice,choice2));
                break;
                
                case '5':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.println("UpperCased: " + s1.toUpperCase());
                System.out.println("Actual Uppercase: " + s1.getString().toUpperCase());
                break;
                
                case '6':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.println("Lowercased: " + s1.toLowerCase());
                System.out.println("Actual Lowercase: " + s1.getString().toLowerCase());
                break;
                
                case '7':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.print("Charcter to find: ");
                choice = in.nextLine().charAt(0);
                System.out.println("Index of " + choice + ": " + s1.indexOf(choice));
                System.out.println("Actual Index of " + choice + ": " + s1.getString().indexOf(choice));
                break;
                
                case '8':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.print("Charcter to find: ");
                choice = in.nextLine().charAt(0);
                System.out.println("Last Index of " + choice + ": " + s1.lastIndexOf(choice));
                System.out.println("Actual Last Index of " + choice + ": " + s1.getString().lastIndexOf(choice));
                break;
                
                case '9':
                System.out.print("String: ");
                s1.setString(in.nextLine());
                System.out.print("Index to start substring: ");
                number = in.nextInt();
                in.nextLine();
                System.out.print("Index to end substring: ");
                anotherNumber = in.nextInt();
                in.nextLine();    
                System.out.println("Substring: " + s1.substring(number,anotherNumber));
                System.out.println("Actual Substring: " + s1.getString().substring(number,anotherNumber));
                break;
                
                default:
            }
            System.out.println("Task Complete. Run again? (y/n)");
            choice = in.nextLine().charAt(0);
        }
    }
}
