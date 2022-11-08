
/**
 * This BowlerDriver class creates
 * two bowlers, three scores, and their averages.
 *
 * @author Austin Lowery
 * @version 29 Jan 2019
 */
import java.util.Scanner;
public class BowlerDriver
{
    public static void main(String[] args){
        
        String name;
        int scoreOne, scoreTwo, scoreThree;
      
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the bowler's full name: ");
        name = in.nextLine();
        
        System.out.print("Enter " + name + "'s first score: ");
        scoreOne = in.nextInt();
        
        System.out.print("Enter " + name + "'s second score: ");
        scoreTwo = in.nextInt();
        
        System.out.print("Enter " + name + "'s third score: ");
        scoreThree = in.nextInt();
        
        Bowlers bowlerOne = new Bowlers(name, scoreOne, scoreTwo, scoreThree);
        
        
        System.out.print("Enter the second bowler's full name: ");
        in.nextLine();
        name = in.nextLine();
        
        System.out.print("Enter " + name + "'s first score: ");
        scoreOne = in.nextInt();
        
        System.out.print("Enter " + name + "'s second score: ");
        scoreTwo = in.nextInt();
        
        System.out.print("Enter " + name + "'s third score: ");
        scoreThree = in.nextInt();
        
        Bowlers bowlerTwo = new Bowlers(name, scoreOne, scoreTwo, scoreThree);
        
        System.out.println(bowlerOne.toString() + bowlerTwo.toString());
        
        
        /* Change Bowler One */
        char choice;
        System.out.println("Change " + bowlerOne.getFullName() + "'s scores? (y/n) ");
        choice = in.next().charAt(0);
        switch(choice){
            case 'y':
            System.out.println("First Score Betw. 0 and 300 (enter n for no change): ");
            try{
                scoreOne = Integer.parseInt(in.next());
            } catch(NumberFormatException n){
                scoreOne = bowlerOne.getScoreOne();
            }
            
            System.out.println("Second Score Betw. 0 and 300 (enter n for no change): ");
            try{
                scoreTwo = Integer.parseInt(in.next());
            } catch(NumberFormatException n){
                scoreTwo = bowlerOne.getScoreTwo();
            }
            
            System.out.println("Third Score Betw. 0 and 300 (enter n for no change): ");
            try{
                scoreThree = Integer.parseInt(in.next());
            } catch(NumberFormatException n){
                scoreThree = bowlerOne.getScoreThree();
            }
            
            changeScore(bowlerOne, scoreOne, scoreTwo, scoreThree);
            
            break;
            default:
            break;
        }
        
        /* Change Bowler Two */
        System.out.println("Change " + bowlerTwo.getFullName() + "'s scores? (y/n) ");
        choice = in.next().charAt(0);
        switch(choice){
            case 'y':
            System.out.println("First Score Betw. 0 and 300 (enter n for no change): ");
            try{
                Integer.parseInt(in.next());
            } catch(NumberFormatException n){
                scoreOne = bowlerTwo.getScoreOne();
            }
            
            System.out.println("Second Score Betw. 0 and 300 (enter n for no change): ");
            try{
                Integer.parseInt(in.next());
            } catch(NumberFormatException n){
                scoreTwo = bowlerTwo.getScoreTwo();
            }
            
            System.out.println("Third Score Betw. 0 and 300 (enter n for no change): ");
            try{
                Integer.parseInt(in.next());
            } catch(NumberFormatException n){
                scoreThree = bowlerTwo.getScoreThree();
            }
            
            changeScore(bowlerTwo, scoreOne, scoreTwo, scoreThree);
            
            break;
            default:
            break;
        }
        
        double firstAverage = bowlerOne.calcAverage(bowlerOne.getScoreOne(),bowlerOne.getScoreTwo(),bowlerOne.getScoreThree());
        double secondAverage = bowlerTwo.calcAverage(bowlerTwo.getScoreOne(),bowlerTwo.getScoreTwo(),bowlerTwo.getScoreThree());
        
        if(firstAverage > secondAverage){
            System.out.println("\n" + bowlerOne.getFullName() + " has a higher average than " + bowlerTwo.getFullName() +
                               ". Their averages are " + firstAverage + " and " + secondAverage + ".");
        } else if (firstAverage < secondAverage){
            System.out.println("\n" + bowlerTwo.getFullName() + " has a higher average than " + bowlerOne.getFullName() +
                               ". Their averages are " + secondAverage + " and " + firstAverage + ".");
        } else{
            System.out.println("\n" + bowlerTwo.getFullName() + " and " + bowlerOne.getFullName() +
                               " have equivalent bowling scores. Their averages are " + firstAverage);
        }
    }
    
    public static void changeScore(Bowlers bowler, int scoreOne, int scoreTwo, int scoreThree){
        bowler.setScoreOne(scoreOne);
        bowler.setScoreTwo(scoreTwo);
        bowler.setScoreThree(scoreThree);
    }
}
