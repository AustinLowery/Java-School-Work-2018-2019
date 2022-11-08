
import java.io.*;
import java.util.*;
import java.util.ArrayList;
/**
 * This is a driver class used to
 * test the methods of the Student class
 * in learning about equals( ) amd compareTo( )
 * 
 * @author Austin Lowery
 * @version 2/25/2019
 */
public class Driver
{

    public static void main(String[ ] args)throws IOException
    {
        Student s1; //reference variable will hold the address of a Student object
        Student s2; //reference variable will hold the address of a Student object
        Student s3; //reference variable will hold the address of a Student object
        Student s4; //reference variable will hold the address of a Student object
        Student s5; //reference variable will hold the address of a Student object
        Student s6; //reference variable will hold the address of a Student object
        Student s7; //reference variable will hold the address of a Student object
        Student s8; //reference variable will hold the address of a Student object
        Student s9; //reference variable will hold the address of a Student object
        Student s10; //reference variable will hold the address of a Student object
        Student s11; //reference variable will hold the address of a Student object
        Student s12; //reference variable will hold the address of a Student object
        //write the code to create the three Student objects using the constructor that accepts all the values
        s1 = new Student("Rentas", "Gabriel", 801085332, 3.223, 5);
        s2 = new Student("Lowery", "Austin", 801074644, 3.520, 5);
        s3 = new Student("Umerah", "Obinna", 801031335, 3.512, 4);
        s4 = new Student("Lowery", "Jennifer", 80109012, 3.789, 3);
        s5 = new Student("Jackson", "Andrew", 801063213, 2.450, 2);
        s6 = new Student("Lowery", "Jessica", 801074644, 3.520, 5);
        s7 = new Student("Brown", "Charlie", 801074644, 3.520, 5);
        s8 = new Student("Krebs", "Barbara", 801074644, 3.520, 5);
        s9 = new Student("Mips", "Barbie", 801074644, 3.520, 5);
        s10 = new Student("Williams", "Quincy", 801074644, 3.520, 5);
        s11 = new Student("Augustus", "Caesar", 801074644, 3.520, 5);
        s12 = new Student("Phillips", "Phillip", 801074644, 3.520, 5);    
        //Write the code to determine the "greatest" Student object using the compareTo( ) method
        //Write the code to determine the "least" Student object using the compareTo( ) method
        Student[] sList = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12};
        Student[] sListSorted = new Student[sList.length];
        int xthElement = 0;
        int ythElement = sList.length;
        int biggest;
        int smallest;
        while(xthElement < ythElement){
            smallest = 0;
            for(int i = 0; i < sList.length; i++){
                //System.out.println(sList[biggest] + " " + sList[i] + "\nsmall");
                if(sList[smallest].compareTo(sList[i]) < 0)
                    smallest = i;
            }
            biggest = 0;
            for(int i = 0; i < sList.length; i++){
                if(sList[biggest].compareTo(sList[i]) > 0)
                    biggest = i;
            }
            sListSorted[xthElement] = sList[biggest];
            sListSorted[ythElement-1] = sList[smallest];
            sList = removeElement(sList,smallest,biggest);
            xthElement++;
            ythElement--;
        }
        
        for(int i = 0; i < sListSorted.length; i++){
            System.out.println(sListSorted[i].toString());
        }
    }//end of main( )
    
    public static Student[] removeElement(Student[] list, int smallest, int biggest){
        Student[] nList = new Student[list.length-2];
        for(int i = 0, m = 0; i < list.length; i++){
            if(list[i] != list[smallest] && list[i] != list[biggest]){
                nList[m] = list[i];
                m++;
            }
        }
        
        return nList;
    }
}