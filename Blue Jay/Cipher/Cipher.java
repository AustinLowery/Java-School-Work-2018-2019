
/**
 * The class Cipher creates vignere ciphered text
 * encoded by a string of letters along with a key.
 *
 * @author Austin Lowery
 * @version 4 Feb 2019
 */
public class Cipher
{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String text;
    private String key;
    private String output; 
    private char encodeOrDecode;
    
    public Cipher(String input, String keyText, char operation){
        String outputText = "";
        int index = 0;
        text = input;
        key = keyText;
        encodeOrDecode = operation;
        
        switch(encodeOrDecode){
            case 'e':
            for(index = 0; index < text.length(); index++){
                outputText += vignereCharacter(text.charAt(index), key.charAt(index));
            }
            output = outputText;
        }
    }
    
    public String output(){
        return output;
    }
    
    private char vignereCharacter(char textLetter, char keyLetter){
        String vignereAlphabet = "";
        int getPlacement;
        int index = 0;
        
        // finds placement of textLetter in alphabet
        getPlacement = alphabet.indexOf(textLetter);
        
        // creates new alphabet starting with textLetter, up until z, then going back around to the letter before textLetter
        for (index = getPlacement; index < alphabet.length(); index++){
            vignereAlphabet += alphabet.charAt(index);
        }
        for (index = 0; index < getPlacement; index++){
            vignereAlphabet += alphabet.charAt(index);
        }
        
        // gets the placement of keyLetter in alphabet
        getPlacement = alphabet.indexOf(keyLetter);
        
        // returns the placement of the keyLetter in alphabet and finds that same placement in the new vignere alphabet
        return vignereAlphabet.charAt(getPlacement);
        
    }
}
