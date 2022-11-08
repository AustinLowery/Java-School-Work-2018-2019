
/**
 * Write a description of class GoToCrowns here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoToCrowns
{
    private String requestee;
    private String requesteeLocation;
    private String time;
    public GoToCrowns(){
        requestee = "unknown";
        requesteeLocation = "unknown";
        time = "00:00";
    }
    public String getRequestee(){
        return requestee;
    }
    public String getRequesteeLoc(){
        return requesteeLocation;
    }
    public String getTime(){
        return time;
    }
    public void setRequestee(String person){
        requestee = person;
    }
    public void setRequesteeLoc(String location){
        requesteeLocation = location;
    }
    public void setTime(String timeSet){
        time = timeSet;
    }
}
