import java.util.*;
import java.io.*;
public class ForegoneSolution
{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int n;
        String nx;
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            nx = n+"";
            for(int j = 0; j < nx.length(); j++){
                if(nx.charAt(j) == '4')
                    n -= Math.pow(10,nx.length()-j-1);
            }
            
            System.out.println("Case #" + i + ": " + n + " " + (Integer.parseInt(nx)-n));
        }
    }
}
