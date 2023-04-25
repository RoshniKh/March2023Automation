package Day3_03132023;

import java.util.ArrayList;

public class T1_WhileLoop {
    public static void main(String[] args) {

        //create an Array list of cities
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Brooklyn");
        cities.add("Manhattan");
        cities.add("Staten Island");

        //set the initial point
        int i = 0;
        while(i <cities.size()){

            System.out.println("Cities: " + cities.get(i));
            i = i+1; //incrementation

        }//end of loop
    }//end of main
}//end of class
