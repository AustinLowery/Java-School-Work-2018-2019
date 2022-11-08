import java.time.ZonedDateTime;
/**
 * This class creates an object representing a date and performs 
 * operations on that date.
 *
 * @author Austin Lowery
 * @version 4/3/2019
 */
public class Date
{
    private int month;
    private int day;
    private int year;
    // list of dates and their highest values (leap year not included)
    private String[][] monthsString = {{"January","31"}, {"February","28"}, {"March","31"}, {"April","30"}, {"May","31"}, {"June","30"},
            {"July","31"}, {"August","31"}, {"September","30"}, {"October","31"}, {"November","30"}, {"December","31"}};
    private String[] zodiacSigns = {"Capricorn","Aquarius","Pisces","Aries","Taurus","Gemini","Cancer","Leo","Virgo","Libra","Scorpio","Sagittarius"}; // list of zodiac signs
    private int[] zodiacDates = {19,18,20,19,20,20,22,22,22,22,21,21}; // highest value for a set month to be labeled the same as it is on the first of that date

    /**The no args constructor makes the date into the current date.
     */
    public Date(){
        month = ZonedDateTime.now().getMonthValue(); // set to a value between 1-12
        day = ZonedDateTime.now().getDayOfMonth();
        year = ZonedDateTime.now().getYear();
    }

    /**Makes a copy of another date
     *@param other the date to copy
     */
    public Date(Date other){
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }
    
    /**Creates a date accepting parameters for a month, day, and year.
     *@param inMonth the month of the date
     *@param inDay the day of the month
     *@param inYear the date's year
     */
    public Date (int inMonth, int inDay, int inYear){
        month = (inMonth < 1)?1: // if month less than 1, make the month January
        (inMonth <= 12)?inMonth: // if month is between 1 and 12 inclusively, make the month equal inMonth
        12; // if month greater than 12, make the month December
        year = (inYear!=0)?inYear:1; // if the year isn't zero, set it to the passed in year. Otherwise, set it to 1

        boolean isLeapYear = false; // assumes it is not a leap year
        if(inDay == 29 && month == 2){ // if the passed in date was February 29
            if(year < 1582){ // and if the year comes before 1582
                isLeapYear = (year%4 == 0)? true : false; // and the year is divisible by 4, then it is a leap year. If not divisible, the it isn't a leap year
            } else{ // and if the year is after 1582
                if( (year%400 == 0) || (year%4==0 && year%100!=0) ) // and if it is divisble by 4, not divisble by 100, unless it is divisible by 400, then it is a leap year
                    isLeapYear = true;
            }
        }

        if(isLeapYear) // if it is a leap year
            day = 29;
        else{ // if not a leap year
            day = (inDay < 1)?1: // if day is less than 1, make it 1
            (inDay <= Integer.parseInt(monthsString[month-1][1]))?inDay: // if day between 1 and the largest day for that month inclusively, make it day equal to the parameter
            Integer.parseInt(monthsString[month-1][1]); // if day is greater than the largest possible day for that month, make it equal to the largest possible day
        }
    }

    /**Shows the date as a string.
     *@return string - the current date
     */
    public String toString(){
        String yearPrint = (year > 999)?(year + "") : // if greater than 999, just print the year
            (year >= 0)?(year + " A.D") : // if between 0 and 1000, append A.D to the year
            ( (-year) + " B.C"); // if negative, negate the year and append B.C to the year
        return monthsString[month-1][0] + " " + day + ", " + yearPrint;
    }

    /**Returns true if two dates are equal, otherwise they are false.
     *@return boolean - whether or not the dates are equal
     */
    public boolean equals(Date other){
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    /**Compares two dates to see if the caller is smaller, the same, or larger than the comparing date. It will return -1, 0, and 1 respectfully for each instance.
     *@return compare - value determining how much smaller or larger the caller is to the comparing date
     */
    public int compareTo(Date other){
        int compare;
        // if the years are equal
        if(this.year == other.year){
            // if the years and months are equal
            if(this.month == other.month){
                // if the years, months, and days are equal, then it is the same and returns zero
                if(this.day == other.day){
                    compare = 0;
                } else{ // returns 1 if this is the larger day and -1 if other is larger
                    compare = (this.day > other.day)?1:-1;
                }

            } else{ // returns 1 if this is the larger month and -1 if other is larger
                compare = (this.month > other.month)?1:-1;
            }

        } else{ // returns 1 if this is the larger year and -1 if other is larger
            compare = (this.year > other.year)?1:-1;
        }
        return compare;
    }

    /**Sets the day of a date.
     *@param inDay - the current day
     */
    public void setDay(int inDay){
        boolean isLeapYear = false; // assumes it is not a leap year
        if(inDay == 29 && month == 2){ // if the passed in date was February 29
            if(year < 1582){ // and if the year comes before 1582
                isLeapYear = (year%4 == 0)? true : false; // and the year is divisible by 4, then it is a leap year. If not divisible, the it isn't a leap year
            } else{ // and if the year is after 1582
                if( (year%400 == 0) || (year%4==0 && year%100!=0) ) // and if it is divisble by 4, not divisble by 100, unless it is divisible by 400, then it is a leap year
                    isLeapYear = true;
            }
        }

        if(isLeapYear) // if it is a leap year
            day = 29;
        else{ // if not a leap year
            day = (inDay < 1)?1: // if day is less than 1, make it 1
            (inDay <= Integer.parseInt(monthsString[month-1][1]))?inDay: // if day between 1 and the largest day for that month inclusively, make it day equal to the parameter
            Integer.parseInt(monthsString[month-1][1]); // if day is greater than the largest possible day for that month, make it equal to the largest possible day
        }
    }

    /**Sets the month of the year.
     *@param inMonth - the current month
     */
    public void setMonth(int inMonth){
        month = (inMonth < 1)?1: // if month less than 1, make the month January
        (inMonth <= 12)?inMonth: // if month is between 1 and 12 inclusively, make the month equal inMonth
        12; // if month greater than 12, make the month December
    }

    /**Sets the year for a date.
     *@param inYear - the current year
     */
    public void setYear(int inYear){
        year = (inYear!=0)?inYear:1; // if the year isn't zero, set it to the passed in year. Otherwise, set it to 1
    }

    /**Checks the date after a number of days have passed.
     *@param numDays the number of days to increment after the date
     *@return passedDate - returns the date after a number of days have passed
     */
    public Date add(int numDays){
        Date passedDate; // days after the current date

        if(numDays < 0) // if a negative number was passed, call the subtract method with it's negated value
            passedDate = this.subtract(numDays*-1);
        else{ // if a non negative number

            int inDay = day;
            int inMonth = month;
            int inYear = year;
            int highestDayInMonth = Integer.parseInt(monthsString[inMonth-1][1]); // the highest day for a given month

            if(inMonth == 2){ // if the beginning month is February
                if(inYear < 1582){ // and the year is before 1582
                    highestDayInMonth = (inYear%4 == 0)? 29 : 28; // and the year is divisble by 4, make the highest day 29. Otherwise, make it 28
                } else{
                    if( (inYear%400 == 0) || (inYear%4==0 && inYear%100!=0) ) // and the year is divisible by 4, but not 100, unless it is divisble by 400, make the highest 29
                        highestDayInMonth = 29;
                }
            }

            for(;numDays > 0; numDays--){
                inDay++; // go forward a day

                // if the day is greater than the highest day in that month
                if(inDay > highestDayInMonth ){
                    inDay = 1; // sets to first day of the month
                    inMonth++; // goes forward a month

                    highestDayInMonth = Integer.parseInt(monthsString[(inMonth-1)%12][1]); // sets a new highest day in the next month. If it is December, it goes to January.
                    if(inMonth == 2){ // if the beginning month is February
                        if(inYear < 1582){ // and the year is before 1582
                            highestDayInMonth = (inYear%4 == 0)? 29 : 28; // and the year is divisble by 4, make the highest day 29. Otherwise, make it 28
                        } else{ // and the year is after 1582
                            if( (inYear%400 == 0) || (inYear%4==0 && inYear%100!=0) ) // and the year is divisible by 4, but not 100, unless it is divisble by 400, make the highest 29
                                highestDayInMonth = 29;
                        }
                    }

                }

                // if December has passed
                if (inMonth > 12){
                    inMonth = 1; // sets to the first month of the year
                    inYear += (inYear!=-1)?1:2; // goes forward a year unless it is 1 BC, in that case it will go from 1 BC to 1 AD
                }
            }
            passedDate = new Date(inMonth, inDay, inYear); // makes a new date using the month, day, and year found
        }
        return passedDate; // returns the date
    }

    /**Checks the date since a number of days were passed.
     *@param numDays the number of days to decrement before the date
     *@return passedDate - returns the date since a number of days were passed
     */
    public Date subtract(int numDays){
        Date subtractedDate; // the subtracted date

        if(numDays < 0) // if a negative number was passed, call the add method with it's negated value
            subtractedDate = this.add(numDays*-1);
        else{
            int inDay = day;
            int inMonth = month;
            int inYear = year;
            for(;numDays > 0; numDays--){
                //System.out.println(inDay);
                inDay--; // go back one day

                if(inDay < 1 ){

                    inMonth--; // go back one month

                    inDay = (inMonth == 0)?31:Integer.parseInt(monthsString[inMonth-1][1]); // if month is 0, make it the 31st (highest day in december)

                    if(inMonth == 2){ // if it is march, the next highest day will be the in February and could be a leap year
                        if(inYear < 1582){ // if it is before 1582
                            inDay = (inYear%4 == 0)? 29 : 28; // and year is divisble by 4, make the day 29, otherwise it will be 28
                        } else{ // and the year is after 1582
                            if( (inYear%400 == 0) || (inYear%4==0 && inYear%100!=0) ) // if the year is divisble by 4, but not 100, unless it is by 400, make the day 29
                                inDay = 29;
                        }
                    }

                    //System.out.println((inMonth == 0)?"December 31":monthsString[inMonth-1][0] + " " + inDay);
                }

                // if January has been gone through
                if (inMonth < 1){
                    inMonth = 12; // sets the month to December
                    inYear -= (inYear!=1)?1:2; // goes back a year unless it is 1 AD, in that case it will go from 1 AD to 1 BC
                }
            }
            subtractedDate = new Date(inMonth, inDay, inYear);
        }
        return subtractedDate; // returns the date as it was a number of days ago
    }

    /**Finds the days between two dates.
     *@param other the date to compare
     *@return amountDays - the amount of days between the two dates
     */
    public int daysBetween(Date other){
        int thisDays = 0;
        int otherDays = 0;
        int monthToDays = 0;

        int amountDays = 0;

        // the days plus the days in a year
        thisDays += this.day + this.year*365; 
        // adds the highest day in a month for each month until back at January
        for(int i = this.month; i > 0; i--){
            thisDays += Integer.parseInt(monthsString[i-1][1]);
        }

        // the days plus the days in a year
        otherDays += other.day + other.year*365;
        // adds the highest day in a month for each month until back at January
        for(int i = other.month; i > 0; i--){
            otherDays += Integer.parseInt(monthsString[i-1][1]);
        }

        int min = Math.min(this.year,other.year);
        int max = Math.min(this.year,other.year);

        if(min > 1582){ // if minimum year greater than start of gregorian calendar, use gregorian method
            //           difference between the days     plus any leap year                   minus any 100th year non leap year     plus every 400th year leap year
            amountDays = Math.abs(thisDays-otherDays) + (max-min)/4 - (max-min)/100 + (max-min)/400;
        } else if(min < 1582 && max < 1582){ // if minimum and max year both less than start of gregorian calendar, use julian calendar method
            amountDays = Math.abs(thisDays-otherDays) + (max-min)/4;
        } else{ // if minimum is less than start of gregorian calendar but max is greater than the start, combine both methods
            amountDays = Math.abs(thisDays-otherDays) + (1582-min)/4;
            amountDays += Math.abs(thisDays-otherDays) + (max-1582)/4 - (max-1582)/100 + (max-1582)/400;
        }

        return amountDays;
    }

    /**Returns the date in a specific format as a string.
     *@param format the character deciding the format; l for long way, s for short way
     *@return resultingString - the formatted date
     */
    public String getDate(char format){
        String resultingString = "";
        String yearPrint = (year > 999)?(year + "") : // if greater than 999, just print the year
            (year >= 0)?(year + " A.D") : // if between 0 and 1000, append A.D to the year
            ( (-year) + " B.C"); // if negative, negate the year and append B.C to the year
        switch(format){
            case 'l': // long
            resultingString = monthsString[month-1][0] + " " + day + ", " + yearPrint; // ie January 5 1766
            break;

            case 's': // number
            resultingString = month + "/" + day + "/" + yearPrint; // ie March 28 1803
            break;

            default:
            System.err.println("Date.UnknownFormatExeption: characters unrecognized."); // if none of the right characters are chosen

        }

        return resultingString;
    }

    /**Uses zeller's formula to find the day of the week.
     *@return String - the day of the week
     */
    public String dayOfWeek(){
        int zellerYear = year; // zellerYear is year by default
        String[] daysOfWeek = new String[] {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}; // list of days of the week
        int zellerMonth = month; // zellerMonth is month by default

        // zeller's formula counts january and february as months 13 and 14
        if(month < 3){
            zellerMonth+=12;
            zellerYear--; // if it's January or February, the zeller year is a year before the actual year
        }

        int yearOfCentury = zellerYear%100; // the last two digits of the year
        int zeroBasedCentury = zellerYear/100; // the first two digits of the year

        // Zeller's formula: (k + [(13*(m+1)/5] + D + [D/4] + [C/4] - 2*C)%7
        int getDay = ( day + ( (13 * (zellerMonth+1)) / 5) + yearOfCentury + yearOfCentury/4 + zeroBasedCentury/4 - 2*zeroBasedCentury)%7;

        if (getDay < 0) // if the modulus is negative, add 7 to it
            getDay += 7;

        return daysOfWeek[getDay];

    }

    /**Gets the zodiac for a date
     *@return zodiacSign - the zodiac sign
     */
    public String getZodiac(){
        int monthCheck = (month == 12)?0:month;// if it's december, it will have a check for if it is latter part of the year and have it set to capricorn, the 0th element, if it is
        String zodiacSign;
        if(day <= zodiacDates[month-1]) // if the day is less than or equal to the largest possible day for earlier part of the month
            zodiacSign = zodiacSigns[month-1]; // if it is, then it will be set to the former part of the month
        else
            zodiacSign = zodiacSigns[monthCheck]; // otherwise, it will be the zodiac in the latter part of the month
        return zodiacSign;
    }
}
