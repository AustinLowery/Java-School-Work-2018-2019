
/**
 * Thisis a driver class to test the methods of the
 * LinearMeasurement class.
 * 
 * @author L. Lehmann 
 * @version v1
 */
public class Driver
{
    public static void main(String[ ] args)
    {
        LinearMeasure m1;
        LinearMeasure m2;

        m1 = new LinearMeasure(20);

        m2 = m1.add(5);

        System.out.println("First: "  + m1);
        System.out.println("Second: "  + m2);

        m2 = m1.multiply(2.0);
        System.out.println("After multiply: " + m1);
        System.out.println("New object from the muliplication: " + m2);
        //   m1.add(4);
        //         System.out.println("After add: " + m1);
        //         

    }
}
