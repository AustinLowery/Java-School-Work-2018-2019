
/**
 * Copies 10 methods from the String class using character arrays.
 *
 * @author Austin Lowery
 * @version 3/3/2019
 */
public class MyStringMethods
{
    private String original; // the original string
    char[] letters; // a character array of the string
    
    /**No-args constructor sets original string to a blank String and the letters to that blank
     */
    public MyStringMethods(){
        original = " ";
        letters = original.toCharArray();
    }
    
    /**Stores the parameter to the original string and makes the letters into a character array of the original string.
     *@param start string to store to original
     */
    public MyStringMethods(String start){
        original = start;
        letters = original.toCharArray();
    }

    /**Sets the parameter to the original string and makes the letters into a character array of the original string.
     *@param start string to store to original
     */
    public void setString(String start){
        original = start;
        letters = original.toCharArray();
    }
    
    /**Gets the original string from the object.
     *@return original - the string stored in the object
     */
    public String getString(){
        return original;
    }
    
    /**Returns the character at a specific index from within a String. Gives a blank character and error message if out of range.
     *@param index the index of the string's character location
     *@return result - the character at the index or the lack thereof
     */
    public char charAt(int index){
        char result; // stores the character at the index
        if(index < 0 || index > letters.length){ // if index is negative or greater than the string length, return an error and blank character
            System.out.println("MyStringMethods.StringIndexOutOfBoundsException: String index out of range: " + index); // error message
            result =  '\u0000'; // returns a blank char value
        } else
            result = letters[index]; // returns the character at the index
        return result; // return result
    }
    
    /**Returns a negative number if the other string is higher, a zero if they're equal, and a positive number if the other is lower. 
     * If the original is the first part of other, a negative is returned. If other is the first part of the original, a positive number is returned.
     *@param other a MyStringMethods object to compare to the original being used
     *@return answer - resulting number for comparing the two strings
     */
    public int compareTo(MyStringMethods other){
        int answer = 0; // return result
        int smallestCharacters = Math.min(this.letters.length,other.letters.length); // loops through the smallest to avoid out of bounds exception
        for(int i = 0; i < smallestCharacters; i++){
            if(this.letters[i] != other.letters[i]){ // if the letters are not equal, find their difference and set to answer
                answer = this.letters[i]-other.letters[i];
                break; // exit loop once answer is defined
            }
        }

        if(this.letters.length != other.letters.length && answer == 0) // if answer was never redefined and the two lengths are unequal
            answer = this.letters.length-other.letters.length; // the difference between original length and other length
            
        return answer; // returns answer
    }
    
    /**Returns a negative number if the other string is higher, a zero if they're equal, and a positive number if the other is lower. 
     * If the original is the first part of other, a negative is returned. If other is the first part of the original, a positive number is returned. 
     * Case is ignored in this method.
     *@param other a MyStringMethods object to compare to the original being used
     *@return answer - resulting number for comparing the two strings
     */
    public int compareToIgnoreCase(MyStringMethods other){
        int answer = 0; // return result
        int smallestCharacters = Math.min(this.letters.length,other.letters.length); // loops through the smallest to avoid out of bounds exception
        for(int i = 0; i < smallestCharacters; i++){
            // if the letters are not equal once lowercased, find their difference and set to answer
            if(Character.toLowerCase(this.letters[i]) != Character.toLowerCase(other.letters[i])){
                answer = this.letters[i]-other.letters[i];
                break; // exit loop once answer is defined
            }
        }

        if(this.letters.length != other.letters.length && answer == 0) // if answer was never redefined and the two lengths are unequal
            answer = this.letters.length-other.letters.length; // the difference between original length and other length
            
        return answer; // returns answer
    }
    
    /**Checks if two strings are equal or not.
     *@param other a MyStringMethods object to compare to the original being used
     *@return checkEqual - determines if the two strings are equal
     */
    public boolean equals(MyStringMethods other){
        boolean checkEqual = true; // starts by assuming the strings are equal
        if(this.letters.length == other.letters.length){ // if the two lengths are equal
             // for each element in the strings
            for(int i = 0; i < this.letters.length; i++){
                 // if any characters are not equal
                if(this.letters[i] != other.letters[i]){
                    checkEqual = false;
                    break; // once any character is false, end the for loop
                }
            }
        } else{ // if the lengths aren't equal
            checkEqual = false;
        }
        return checkEqual; // returns the result
    }
    
    /**Replaces a specified character with another character.
     *@param oldChar the character to be changed
     *@param newChar the character that the old character is changed to
     *@return String - a string with the old character replaced by the new character
     */
    public String replace(char oldChar, char newChar){
        char[] originalCopy = new char[letters.length]; // creates new list of characters of equal length to letters array
        for(int i = 0; i < letters.length; i++){ // goes through each element in the array
            if(this.letters[i] == oldChar) // if the current character is equal to the old character, change it to the new character
                originalCopy[i] = newChar;
            else // otherwise add it normally
                originalCopy[i] = this.letters[i];
        }
        return new String(originalCopy); // returns the modified array of characters as a string
    }
    
    /**Takes a portion of the original string and returns it based on the parameters.
     *@param start the portion of the string to start at
     *@param end the portion of the string to end at
     *@return stringPart - the substring returned
     */
    public String substring(int start, int end){
        String stringPart; // the part of the string between the two indexes
        if(start < 0 || start > letters.length-1){ // if the start is less than zero or greater than the highest index
            System.out.println("MyStringMethods.StringIndexOutOfBoundsException: String index out of range: "+start); // error message
            stringPart = "";
        } else if(end > letters.length-1 || end < 0){ // if the start is less than zero or greater than the highest index
            System.out.println("MyStringMethods.StringIndexOutOfBoundsException: String index out of range: "+end); // error message
            stringPart = "";
        } else if(end < start){ // if the end is less than the start index
            System.out.println("MyStringMethods.StringIndexOutOfBoundsException: String index out of range: "+(end-start)); // error message
            stringPart = "";
        }else{
            char[] originalSubstring = new char[end-start]; // makes a new list of characters equal to end minus start
            for(int i = 0; start < end; start++, i++){ // while start is less than end, continue adding the characters to the array; i determines the element in the string
                originalSubstring[i] = this.letters[start];
            }
            stringPart = new String(originalSubstring); // make the character array a string and equate to the string part
        }
        return stringPart; // returns the result
    }
    
    /**Makes all characters in a string uppercase.
     *@return String - the string with each character to uppercase
     */
    public String toUpperCase(){
        char[] originalUpper = new char[letters.length]; // creates a character array equal to the letters array length
        for(int i = 0; i < letters.length; i++){ // goes through each character in the string
            if( (int)(this.letters[i]) >= 97 && (int)(this.letters[i]) <= 122 ) // if ascii values are between 97 and 122, then they are through lowercase a and z
                originalUpper[i] = (char)(this.letters[i]-32); // subtract by 32 to find the uppercase characters of a through z
            else
                originalUpper[i] = this.letters[i]; // otherwise, just add the values as is to the array
        }
        return new String(originalUpper); // send the array as a string
    }
    
    /**Makes all characters in a string lowercase.
     *@return String - the string with each character to lowercase
     */
    public String toLowerCase(){
        char[] originalLower = new char[letters.length]; // creates a character array equal to the letters array length
        for(int i = 0; i < letters.length; i++){ // goes through each character in the string
            if( (int)(this.letters[i]) >= 65 && (int)(this.letters[i]) <= 90 ) // if ascii values are between 97 and 122, then they are through lowercase a and z
                originalLower[i] = (char)(this.letters[i]+32); // subtract by 32 to find the uppercase characters of a through z
            else
                originalLower[i] = this.letters[i]; // otherwise, just add the values as is to the array
        }
        return new String(originalLower); // send the array as a string
    }
    
    /**Checks the first instance of a character in a string.
     *@return index - returns where the last instance of the character is in the string
     */
    public int indexOf(char findChar){
        int indexPlacement = -1; // assumes character isn't in the index
        for(int index = 0; index < letters.length; index++){ // goes through each character in the string
            if(this.letters[index] == findChar){
                indexPlacement = index; // sets the returned value to the currennt index
                break; // once answer is found, break loop
            }
        }
        return indexPlacement; // returns the result
    }
    
    /**Checks the last instance of a character in a string.
     *@return index - returns where the last instance of the character is in the string
     */
    public int lastIndexOf(char findChar){
        int indexPlacement = -1; // assumes character isn't in the index
        for(int index = letters.length-1; index >= 0; index--){ // goes through each character in the string starting from the last character backwards
            if(this.letters[index] == findChar){
                indexPlacement = index; // sets the returned value to the currennt index and continues until it ends
                break; // once answer is found, break loop
            }
        }
        return indexPlacement; // returns the result
    }
}
