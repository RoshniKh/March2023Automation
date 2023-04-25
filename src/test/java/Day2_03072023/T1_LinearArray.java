package Day2_03072023;

import java.sql.SQLOutput;

public class T1_LinearArray {
    public static void main(String[] args) {
        //declare a string array variable
        String[] zipCode;
        //store zipcode values in the string array
        zipCode =  new String[]{"11210", "11330", "14565", "17589", "14525"};
        //print the first zipcode from the zipCode array
        //Array always start from index 0
        System.out.println("My first Zipcode is " +zipCode[0]);
        //print the second zipcode from the zipCode array
        System.out.println("My second Zipcode is " +zipCode[1]);
        //alternative way to declare and define a Linear array
        String[] zipCode2 = new String[]{"11210", "11330", "14565", "17589", "14525"};
        //print out the 5th zipcode from zipCode2 array
        System.out.println("My Fifth Zipcode is " +zipCode2[4]);
        //declare a linear array of int values
        int[] studentGrades = new int[]{90, 55, 60};
        System.out.println("My Second student grade is " +studentGrades[1]);
    }//end of main
}//end of class
