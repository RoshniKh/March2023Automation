package Day2_03072023;

import java.util.ArrayList;

public class T2_ArrayList { //Array List is also called Dynamic array
    public static void main(String[] args) {
          //declare and define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //add some values for countries
        countries.add("USA"); //index 0
        countries.add("UK"); //index 1
        countries.add("BANGLADESH"); //index 2
        countries.add("INDIA"); //index 3
        countries.add("PAKISTAN"); //index 4
        //print out USA from the ArrayList
        System.out.println("My first country is " +countries.get(0));
        //get the total size of the Array list
        System.out.println("Size of the countries ArrayList is " +countries.size());
        //add an additional country
        countries.add("CANADA");//index 5
        //print out the size of the ArrayList again
        System.out.println("Size of the countries is " +countries.size());

        //call an integer array list for studentGrades
        //For ArrayList Integer always needs to be spelled out the Integer
        ArrayList<Integer> studentGrades = new ArrayList<>();
        //add some student grades to the array list
        studentGrades.add(90);
        studentGrades.add(80);
        studentGrades.add(70);
        System.out.println("First student grade is " +studentGrades.get(0)+ " and the second student grade is " +studentGrades.get(1));
    }//end of main
}//end of class
