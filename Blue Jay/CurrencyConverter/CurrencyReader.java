import java.net.*;
import java.io.*;
import java.util.*;
/**
 * This class is used to open a connection to a URL to 
 * obtain the current exchange rates for five type of world
 * currencies. This can be edited to cover more exange rates, 
 * it is currently based on the layout of the website found
 * at http://www.x-rates.com/table/?from=USD&amount=1
 * 
 * @author L. Lehmann
 * @version v1
 */
public class CurrencyReader
{
    private URL rates; //to hold the connection to the web site
    private URLConnection yc;//to hold the connection to the website
    private Scanner in;//to read the lines of data from the website
    private String[ ] currencyTypes = {"EUR","GBP","INR","AUD","CAD"}; //used for labels in parallel with the values
    private double[ ] exchangeRates;//to hold the currency exchange rates from one US dollar
    //to anohter type of currenct. 
    // For example 1 US Dollar = exchangeRate[k] of currencyType[k]
    //remember using arrays in parallel???

    //I had to look at the html for thepage to see its layout
    //and then apply String methods to extract the exchage rates.
    //The constructor initializes all the fields declared above.
    //It then opens the URL conncection and sends an input stream from
    //the conncection to the constructor method of a new Scanner object.
    //After that the Scanner object can be used to read the contents of the URL.

    public CurrencyReader( ) throws Exception 
    {
        rates = new URL("https://www.x-rates.com/table/?from=USD&amount=1");
        yc = rates.openConnection();
        in = new Scanner(new InputStreamReader(yc.getInputStream()));
        exchangeRate();
    }

    public void exchangeRate(){
        String inputLine = new String("");
        int pos = -1;
        exchangeRates = new double[currencyTypes.length]; //create the array to hold the exchange rates
        while (!(inputLine.contains("Euro")))//look thru the url for the first rate
            inputLine = in.nextLine( );

        inputLine = in.nextLine(); //this lineof the ul holds the exchange rate
        System.out.println(inputLine);
        pos = inputLine.indexOf('>',inputLine.indexOf('>')+ 1); //find the position  of the rate in the line of text          

        //the line of text is, well, text. So the numberic rate must be converted from the text rate
        //and then stored in the array of exchange rates
        exchangeRates[0]  = Double.parseDouble(inputLine.substring(pos+1,inputLine.indexOf('<',pos+1)));
        //now repeat this for five other  counties in the web site table
        for(int country = 1; country < currencyTypes.length;country++)
        {

            for(int lnCount = 0; lnCount < 4; lnCount++)
                in.nextLine( );
            inputLine = in.nextLine();
            pos = inputLine.indexOf('>',inputLine.indexOf('>')+ 1);           
            exchangeRates[country]  = Double.parseDouble(inputLine.substring(pos+1,inputLine.indexOf('<',pos+1)));

        }
        in.close( );   
    }

    /**
     * This method returns a reference to the array of double that
     * hold the currency exchange rates.
     * @return a reference of doubles. Each element hold the value of an exchange rate
     */
    public double[ ] getRateArray( )
    {
        return exchangeRates;
    }

    /** This method returns a textual representation of the object
     * formatted to show the type of currency and the current exchange rate.
     * nb- this is a review of using arrays in parallel.
     * @return a string containing the currency types and exchange rates to US Dollars
     */
    public String toString( )
    {
        String result = new String("");
        for(int i = 0; i < exchangeRates.length; i++)
        {
            result += currencyTypes[i] + ": " + exchangeRates[i] + "\n";
        }
        return result;
    }

    public void setAmount(String newCur) throws Exception{
        // String[ ] currencyTypes = {"EUR","GBP","INR","AUD","CAD"};
        rates = new URL("https://www.x-rates.com/table/?from=USD&amount=1");
        yc = rates.openConnection();
        in = new Scanner(new InputStreamReader(yc.getInputStream()));
        String[] newCurrency = new String[currencyTypes.length+1];

        for(int i=0; i < currencyTypes.length; i++){
            newCurrency[i] = currencyTypes[i];
        }
        newCurrency[currencyTypes.length] = newCur;

        currencyTypes = newCurrency;
        exchangeRate();
    }
}