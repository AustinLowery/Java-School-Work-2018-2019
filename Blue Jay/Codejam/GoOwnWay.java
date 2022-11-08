import java.util.*;
import java.io.*;
public class GoOwnWay
{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[] alphabetList = new int[26];
        int[] numList = new int[26];

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        StringTokenizer tokenizer;
        StringBuilder code;

        int highestDivisor;
        int currentNumber;
        int currentDivisor;
        int arrNum;
        int j;

        for (int i = 1; i <= t; ++i) {
            arrNum = 0;
            tokenizer = new StringTokenizer(in.nextLine());

            highestDivisor = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(in.nextLine());
            currentNumber = Integer.parseInt(tokenizer.nextToken());
            for(j = 2; j < highestDivisor; j++){
                if(currentNumber%j == 0){
                    currentDivisor = j;
                    break;
                }
            }

            numList[0] = j;
            currentDivisor = currentNumber/j;
            arrNum = 1;
            
            while(tokenizer.hasMoreTokens()){
                j = Integer.parseInt(tokenizer.nextToken());
                numList[arrNum] = j/currentDivisor;
                arrNum++;
            }
            
            
            
            System.out.println("Case #" + i + ": ");
        }
    }
}
