
/**
 * Tests each method in Date.
 *
 * @author Austin Lowery
 * @version 4/3/2019
 */
public class DateDriver
{
    /**Tests every method in Date
     *@param args passed in arguments
     */
    public static void main(String[] args){
        Date dateOne;
        Date dateTwo;
        
        /*  */
        System.out.println("Tests the default constructor: ");
        
        dateOne = new Date(); // default; sets to current day
        System.out.println(dateOne+": Today\n");
        
        /*   */
        System.out.println("\n\nTests the copy constructor: ");
        
        dateOne = new Date(4,3,2019);
        dateTwo = new Date(dateOne);
        System.out.println(dateTwo + ": should be April 3, 2019");
        
        /*  */
        System.out.println("\n\nTests the constructor with 3 int arguments: ");
        
        dateOne = new Date(5,15,2019); // just a standard date
        System.out.println(dateOne+": Standard\n");
        
        
        dateOne = new Date(40,15,2019); // tests for the upperbound for month
        System.out.println(dateOne+": Upperbound Month\n");
        
        dateOne = new Date(5,40,2019); // tests for the upperbound for day
        System.out.println(dateOne+": Upperbound Day\n");
        
        
        dateOne = new Date(0,15,2019); // tests for the lower bound for month
        System.out.println(dateOne+": Lowerbound Month\n");
        
        dateOne = new Date(5,-10,2019); // tests for the lower bound for day
        System.out.println(dateOne+": Lowerbound Day\n");
        
        
        dateOne = new Date(5,15,0); // tests if the year 0 works, which it shouldn't since there is no 0 AD
        System.out.println(dateOne+": Year 1 AD?\n");
        
        
        dateOne = new Date(2,29,2019); // tests if leap year is in 2019 (it isn't)
        System.out.println(dateOne+": 2019 not leap year\n");
        
        dateOne = new Date(2,29,2016); // tests if leap year is in 2016 (it is)
        System.out.println(dateOne+": 2016 is leap year\n");
        
        dateOne = new Date(2,29,2100); // tests if leap year is in 2100 (it isn't)
        System.out.println(dateOne+": 2100 is not leap year\n");
        
        dateOne = new Date(2,29,2000); // tests if leap year is in 2016 (it is)
        System.out.println(dateOne+": 2000 is leap year\n");
        
        
        /*  */
        System.out.println("\n\nTests the toString: ");
        
        dateOne = new Date(2,15,2019); // prints out normally no AD or BC
        System.out.println(dateOne+": No BC or AD\n");
        
        dateOne = new Date(2,15,819); // prints out AD
        System.out.println(dateOne+": is AD\n");
        
        dateOne = new Date(2,15,-500); // prints out BC
        System.out.println(dateOne+": is BC\n");
        
        
        /*  */
        System.out.println("\n\nTests the equals method: ");
        
        dateOne = new Date(2,15,2019);
        dateTwo = new Date(2,15,2019);
        System.out.println(dateOne.equals(dateTwo)+": is true\n");
        
        dateOne = new Date(2,15,2019);
        dateTwo = new Date(2,18,2019);
        System.out.println(dateOne.equals(dateTwo)+": is false\n");
        
        
        /*  */
        System.out.println("\n\nTests the compare to method: ");
        
        dateOne = new Date(2,15,2019);
        dateTwo = new Date(2,15,2019);
        System.out.println(dateOne.compareTo(dateTwo)+": is 0\n");
        
        dateOne = new Date(2,15,2019);
        dateTwo = new Date(2,15,2018);
        System.out.println(dateOne.compareTo(dateTwo)+": is 1\n");
        
        dateOne = new Date(2,15,2019);
        dateTwo = new Date(2,10,2019);
        System.out.println(dateOne.compareTo(dateTwo)+": is 1\n");
        
        dateOne = new Date(2,15,2019);
        dateTwo = new Date(1,15,2019);
        System.out.println(dateOne.compareTo(dateTwo)+": is 1\n");
        
        
        dateOne = new Date(2,15,2018);
        dateTwo = new Date(2,15,2019);
        System.out.println(dateOne.compareTo(dateTwo)+": is -1\n");
        
        dateOne = new Date(2,10,2019);
        dateTwo = new Date(2,15,2019);
        System.out.println(dateOne.compareTo(dateTwo)+": is -1\n");
        
        dateOne = new Date(1,15,2019);
        dateTwo = new Date(2,15,2019);
        System.out.println(dateOne.compareTo(dateTwo)+": is -1\n");
        
        
        
        /*  *   */
        // dates for all set methods
        dateTwo = new Date(2,15,2019);
        
        /*   */
        System.out.println("\n\nTests the set day: ");
        
        dateTwo.setDay(20); // checks arbitrary day
        System.out.println(dateTwo + ": Day should be 20");
        
        dateTwo.setDay(-5); // checks for negative day
        System.out.println(dateTwo + ": Day should be 1");
        
        dateTwo.setDay(40); // checks for day over upperbound
        System.out.println(dateTwo + ": Day should be highest day for that month");
        
        
        /*   */
        System.out.println("\n\nTests the set month: ");
        
        dateTwo.setMonth(5); // checks arbitrary month
        System.out.println(dateTwo + ": Month should be May");
        
        dateTwo.setMonth(-5); // checks for month less than 1
        System.out.println(dateTwo + ": Month should be January");
        
        dateTwo.setMonth(40); // checks for month over upperbound
        System.out.println(dateTwo + ": Month should be December");
        
        
        /*   */
        System.out.println("\n\nTests the set year: ");
        
        dateTwo.setYear(1990); // checks arbitrary year
        System.out.println(dateTwo + ": Year should be 1990");
        
        dateTwo.setYear(0); // checks for when year is zero
        System.out.println(dateTwo + ": Year should be 1");
        
        
        /*   */
        System.out.println("\n\nTests the add method: ");
        
        dateOne = new Date(4,3,2019);
        dateTwo = dateOne.add(5);
        System.out.println(dateTwo + ": Should be April 8,2019");
        
        dateOne = new Date(4,3,2019);
        dateTwo = dateOne.add(30);
        System.out.println(dateTwo + ": Should be May 3,2019");
        
        dateOne = new Date(4,3,2019);
        dateTwo = dateOne.add(400);
        System.out.println(dateTwo + ": Should be May 7, 2020");
        
        /*   */
        System.out.println("\n\nTests the subtract method: ");
        
        dateOne = new Date(4,3,2019);
        dateTwo = dateOne.subtract(5);
        System.out.println(dateTwo + ": Should be March 29,2019");
        
        dateOne = new Date(4,3,2019);
        dateTwo = dateOne.subtract(30);
        System.out.println(dateTwo + ": Should be March 4,2019");
        
        dateOne = new Date(4,3,2019);
        dateTwo = dateOne.subtract(400);
        System.out.println(dateTwo + ": Should be February 27, 2018");
        
        /*   */
        System.out.println("\n\nTests the days between method: ");
        
        dateOne = new Date(4,3,2019);
        
        dateTwo = new Date(4, 8, 2019);
        System.out.println(dateOne.daysBetween(dateTwo) + ": should be 5");
        
        dateTwo = new Date(4, 30, 2019);
        System.out.println(dateOne.daysBetween(dateTwo) + ": should be 27");
        
        dateTwo = new Date(5, 7, 2020);
        System.out.println(dateOne.daysBetween(dateTwo) + ": should be 400");
        
        
        /*   */
        System.out.println("\n\nTests the format: ");
        
        System.out.println(dateOne.getDate('l') + ": should be April 3, 2019");
        System.out.println(dateOne.getDate('s') + ": should be 4/3/2019");
        
        
        /*   */
        System.out.println("\n\nTests the day of the week: ");
        
        dateOne = new Date(4,3,2019);
        System.out.println(dateOne.dayOfWeek() + ": should be Wednesday");
        
        dateOne = new Date(7,4,1998);
        System.out.println(dateOne.dayOfWeek() + ": should be Saturday");
        
        dateOne = new Date(1,16,1998);
        System.out.println(dateOne.dayOfWeek() + ": should be Friday");
        
        
        /*   */
        System.out.println("\n\nTests the zodiac: ");
        
        dateOne = new Date(1,16,2019);
        System.out.println(dateOne.getZodiac() + ": should be Capricorn");
        
        dateOne = new Date(1,30,1993);
        System.out.println(dateOne.getZodiac() + ": should be Aquarius");
        
        dateOne = new Date(7,4,1998);
        System.out.println(dateOne.getZodiac() + ": should be Cancer");
        
    }
}
