package ActionItems;

public class A1_LinearArray {
    public static void main(String[] args) {
        //declare string variable
        String[] region;
        //store region values in the string array
        region = new String[] {"CA", "TX", "PA", "OH"};
        //declare a linear array of int values
        int[] areaCode = new int[] {213,214,215,216};
        //declare for loop for linear array
        for (int i= 0; i< areaCode.length; i++) {
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
        }//end of for loop for linear array
    }//end of main
}//end of class
