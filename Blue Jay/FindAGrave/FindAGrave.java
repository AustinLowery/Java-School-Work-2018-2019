import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Finds profiles without a profile image and stores the names, nates, and IDs of them.
 *
 * @author Austin Lowery
 * @version 2/26/2019
 */
public class FindAGrave
{
    private int cemetery; // holds cemetery number
    private List name; // name of the profile
    private List dates; // birth and death dates
    private List memorialID; // unique id

    private URL graveListing; //to hold the connection to the web site
    private URLConnection connection;//to hold the connection to the website
    private Scanner in;//to read the lines of data from the website

    /**The no-args constructor sets all variables to their default values.
     */
    public FindAGrave(){
        cemetery = 0; // sets the cemetery
        name = new ArrayList(); // list of names
        dates = new ArrayList(); // list of dates
        memorialID = new ArrayList(); // list of ids
    }

    /**Accepts the cemetery id and calls on the noPhoto method to find each profile without a photo.
     *@param cemeteryNumber - the cemetery id used in determining the webpage
     *@throws IOException
     */
    public FindAGrave(int cemeteryNumber) throws IOException{
        cemetery = cemeteryNumber; // sets the cemetery
        name = new ArrayList(); // list of names
        dates = new ArrayList(); // list of dates
        memorialID = new ArrayList(); // list of ids
        noPhoto(); // calls noPhoto
    }

    /**Finds the name, date, and memorialID of each profile without a photo.
     *@throws IOException
     */
    private void noPhoto() throws IOException{
        graveListing = new URL("https://www.findagrave.com/cemetery/" + cemetery + "/memorial-search?firstName=&lastName=&page=1");
        int posFirst = -1; // finds the position before the first character in the string
        int posSecond = -1; // finds the position after the last character in the string
        String inputLine = new String(" "); // makes inputLine a blank string
        // 443574
        // for loop continues running for all the pages of the memorial
        for(int i = 1; i > 0; i++){
            graveListing = new URL("https://www.findagrave.com/cemetery/" + cemetery + "/memorial-search?firstName=&lastName=&page=" + i + "#sr-63110624");
            connection = graveListing.openConnection(); // connects to the page

            in = new Scanner(new InputStreamReader(connection.getInputStream())); // scanner for the webpage
            while(in.hasNext()){
                do {
                    inputLine = in.nextLine(); // makes string equal to next line

                    // if no memorials found for the cemetery on the page, end the for loop
                    if(inputLine.contains("No memorials found for <b> </b>"))
                        i = -1;
                    break;
                }while(!(inputLine.contains("span class=\"media"))); // continues until it finds this commonality in the blank photo lines

                // between these values is the name
                posFirst = inputLine.indexOf("name-grave\">",1); // sets the first position
                if(inputLine.contains("Flowers have been left")) // if flowers were left
                    posSecond = inputLine.indexOf("<b data-toggle=\"tooltip\"",1); // sets the second position
                else
                    posSecond = inputLine.indexOf("<span class=\"media",1); // sets the second position
                name.add(new String(inputLine.substring(posFirst+2,posSecond)).toUpperCase()); // gets substring of line, sets to uppercase

                // between these values is the memorial ID
                posFirst = inputLine.indexOf("value=\"",1); // sets the first position
                posSecond = inputLine.indexOf("></h2>",1); // sets the second position
                memorialID.add(new String(inputLine.substring(posFirst+2,posSecond)).toUpperCase()); // gets substring of line, sets to uppercase

                inputLine = in.nextLine(); // goes to next line which has dates

                // between these values is the date
                posFirst = inputLine.indexOf("text-muted birthDeathDates\">",1); // sets the first position
                posSecond = inputLine.indexOf("</b>",1); // sets the second position
                dates.add(new String(inputLine.substring(posFirst+2,posSecond)).toUpperCase()); // gets substring of line, sets to uppercase
            }
        }
    } // end noPhoto

    /**Returns a string encompassing the information within the profile.
     *@return String - information within the profile
     */
    public String toString(){
        StringBuilder string = new StringBuilder(""); // creates a string builder to hold each profile as it is appended
        for(int i = 0; i < name.size(); i++){ // appends name, date, and the website address to the memorial
            string.append("Name: " + name.get(i) + "\n\t" + dates.get(i) + "\nhttps://www.findagrave.com/memorial/" + memorialID.get(i) + "\n\n");
        }
        return string.toString(); // returns the string
    }
}
