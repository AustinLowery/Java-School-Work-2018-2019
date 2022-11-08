
/**
 * This class creates a new Bowler
 *
 * @author Austin Lowery
 * @version 29 Jan 2019
 */
public class Bowlers
{
    private String fullName;
    private int scoreOne;
    private int scoreTwo;
    private int scoreThree;
    
    public Bowlers(){
        fullName = null;
        scoreOne = scoreTwo = scoreThree = 0;
    }
    
    public Bowlers(String name, int firstScore, int secondScore, int thirdScore){
    
        fullName = name;
        scoreOne = firstScore;
        scoreTwo = secondScore;
        scoreThree = thirdScore;

    }
    
    public Bowlers(Bowlers other){
        this.fullName = other.fullName;
        this.scoreOne = other.scoreOne;
        this.scoreTwo = other.scoreTwo;
        this.scoreThree = other.scoreThree;
    }
    
    public double calcAverage(int firstScore, int secondScore, int thirdScore){
    
        return ((double)(firstScore+secondScore+thirdScore))/3;
    
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public int getScoreOne(){
        return scoreOne;
    }
    
    public int getScoreTwo(){
        return scoreTwo;
    }
    
    public int getScoreThree(){
        return scoreThree;
    }
    
    public void setScoreOne(int score){
        if(score >= 0 && score <= 300) scoreOne = score;
    }
    
    public void setScoreTwo(int score){
        if(score >= 0 && score <= 300) scoreTwo = score;
    }
    
    public void setScoreThree(int score){
        if(score >= 0 && score <= 300) scoreThree = score;
    }
    
    public String toString(){
        return "\n" + fullName + " has a bowling average of " + calcAverage(scoreOne, scoreTwo, scoreThree) + ".";
    }
    
}
