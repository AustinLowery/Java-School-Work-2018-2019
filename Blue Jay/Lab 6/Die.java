import java.util.*;
/**
 * Information and methods for a game die (dice).
 * 
 * @author Lorrie Lehmann 
 * @version v1
 */

public class Die
{

    private int numberOfSides;
    private int face;

    private Random numberGenerator;//declare a referenc 
    //variable for a Random 
    //object	
    public Die( )
    {
        numberOfSides = 6;
        numberGenerator = new Random( );
        roll( );
    } 

    public Die( int inNumberOfSides)
    {
        numberOfSides = inNumberOfSides;
        numberGenerator = new Random( );
        roll( );
    }  

    public void roll( )
    {
        face = numberGenerator.nextInt(numberOfSides) + 1;
    }

    public String toString( )
    {
        String result;
        switch(face)
        {
            case 1:  result =  "\t*";
            break;
            case 2:  result =  "\t*\t*";
            break;
            case 3:  result = "*\n\t\t*\n\t\t\t*";
            break;
            case 4:  result = "\t*\t*\n\n\t*\t* ";
            break;
            case 5:  result = "* * * * *";
            break;
            case 6:  result = "* * * * * *";
            break;
            default: result = "face is " + face;
        }
        return result;
    }

    public int getFace( )
    {
        return face;
    }    

    public boolean equals(Die inDie)
    {
        return (face == inDie.face) && (numberOfSides == inDie.numberOfSides);
    }

    public int compareTo(Die inDie)
    {
        int answer;

        if(face > inDie.face)
        {
            answer = 1;
        }
        else
        {
            if(face < inDie.face)
            {
                answer = -1;
            }
            else
            {
                answer = 0;
            }
        }   
        return answer;
    }

}

