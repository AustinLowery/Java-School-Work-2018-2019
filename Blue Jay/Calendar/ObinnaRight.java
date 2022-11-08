
/**
 * Write a description of class ObinnaWrong here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObinnaRight
{
    int howRight;
    public ObinnaRight(int rightness){
        howRight = rightness;
    }
    
    public ObinnaRight(ObinnaRight one){
        this.howRight = one.howRight;
    }
    
    public void cardToCardList(){
        String[] s1 = {new String("0")};
        String[] s2 = new String[1];
        //s2 = s1[0];
        // assign the wrong address to an array? I think NOT
    }
    
    
    
  /* More than one? I think NOT
    public ObinnaRight(ObinnaRight two){
        this.howRight = two.howRight;
    }*/
}
