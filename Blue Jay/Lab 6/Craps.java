import java.util.Scanner;
/**
 * Plays a game of Craps.
 *
 * @author Austin Lowery
 * @version 2/26/2019
 */
public class Craps
{
    public static void main(String args[]){
        int point = 0;
        Die rollOne;
        Die rollTwo;
        char choice = 'y';
        Scanner in = new Scanner(System.in);

        while(choice == 'y'){
            rollOne = new Die();
            rollTwo = new Die();
            System.out.println("Round 1:");
            System.out.println("\tRoll One: " + rollOne.getFace());
            System.out.println("\tRoll Two: " + rollTwo.getFace());
            System.out.println("\tRoll Sum: " + (rollOne.getFace()+rollTwo.getFace()));

            if((rollOne.getFace()+rollTwo.getFace()) == 7 || (rollOne.getFace()+rollTwo.getFace()) == 11){
                System.out.println("\n\tYou won!");
            } else if((rollOne.getFace()+rollTwo.getFace()) == 2 || (rollOne.getFace()+rollTwo.getFace()) == 12 || (rollOne.getFace()+rollTwo.getFace()) == 3){
                System.out.println("\n\tOh no! You Lost!");
            }else{
                point = rollOne.getFace()+rollTwo.getFace();
                System.out.println("\n*** Your Point: " + (rollOne.getFace()+rollTwo.getFace()) + " ***\n");
                for(int i=2; i > 0; i++){
                    rollOne.roll();
                    rollTwo.roll();

                    System.out.println("Round " + i + ": ");
                    System.out.println("\tRoll One: " + rollOne.getFace());
                    System.out.println("\tRoll Two: " + rollTwo.getFace());
                    System.out.println("\tRoll Sum: " + (rollOne.getFace()+rollTwo.getFace()));

                    if(rollOne.getFace()+rollTwo.getFace() == point){
                        System.out.println("\n\tYou won!");
                        i = -1;
                    } else if(rollOne.getFace()+rollTwo.getFace() == 7){
                        System.out.println("\n\tOh no! You Lost!");
                        i = -1;
                    }
                }
            }

            System.out.println("\nPlay again (y/n): ");
            choice = in.next().charAt(0);
            System.out.println();
        }
    }
}
