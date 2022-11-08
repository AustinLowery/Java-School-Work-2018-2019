
/**
 * Replaces a character in a string with "blank"
 *
 * @author Austin Lowery
 * @version 5 Feb 2019
 */
public class Replacer
{
    private String original;
    private StringBuilder workOn;

    
    public Replacer(String string){
        original = string;
        workOn = new StringBuilder(string);
    }
    
    public void replace(char replacee, CharSequence replacer){
        for(int i = 0; i < workOn.length(); i++){
            if(workOn.charAt(i) == replacee){
                workOn.deleteCharAt(i);
                workOn.insert(i, replacer);
            }
        }
    }
    
    public String getOriginal(){
        return original;
    }
    
    public StringBuilder getConvertedString(){
        return workOn;
    }
    
    public void updateString(String changedString){
        original = changedString;
        workOn = new StringBuilder(changedString);
    }
}
