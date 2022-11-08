
/**
 * Write a description of class CommandExample here.
 * 
 * @author L. Lehmann 
 * @version v1
 */
public class CommandExample
{
    public static void main(String[ ] args)
    {
        System.out.println("The number of arguments is: " + args.length);
        for(int k = 0; k < args.length; k++)
        {
            System.out.println(args[k]);
        }
    }//end of main
}//end of class
