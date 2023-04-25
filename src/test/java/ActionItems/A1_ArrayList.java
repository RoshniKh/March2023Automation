package ActionItems;

import java.util.ArrayList;

public class A1_ArrayList {
    public static void main(String[] args) {
        //declare and define arrayList of region
        ArrayList<String> country = new ArrayList<>();
        //add some values for some regions
        country.add("YEMEN");
        country.add("ZAMBIA");
        country.add("USA");
        country.add("UK");

        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(887);
        countryCode.add(894);
        countryCode.add(840);
        countryCode.add(826);

        for (int i = 0; i < countryCode.size(); i++) {

            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of for loop
    }//end of main
}//end of class