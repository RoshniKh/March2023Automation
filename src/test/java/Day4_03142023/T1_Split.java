package Day4_03142023;

public class T1_Split {
    public static void main(String[] args) {

        //create a single string variable
        String message = "My name is John";
        //create a single string variable
        String statement = "My name is John";
        //extract/take out the world John from the string and print it out
        //declare and define a new array String to store the split concept
        //declare String array to split the message to print out only John
        String[] arrayMessage = message.split(" ");
        // print out john
        System.out.println("Value is " + arrayMessage[3]);

    }//end of main
}//end of class
