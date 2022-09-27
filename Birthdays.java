/*
Program asks for date of birth (DOB) (in YYYYMMDD format) and names of N number of people (user decides how many inputs).
Program then compares the age of all the individuals and outputs the names from oldest to youngest. 
Program also outputs the DOB of every individual in MM/DD/YYYY format.

HOW TO USE:
Start by inputting birthdays
When done inputting, enter 0: this will break the loop and move the program forward
The program will prompt you for names (same number as birthdays inputted)
Program will then calculate and display the output
*/

import java.util.ArrayList; // Since there is an undefined number of inputs, I used ArrayList
import java.util.Scanner; // Used to take inputs

class Birthdays{
    public static void main(String[] args){
        ArrayList<Integer> bDays = new ArrayList<Integer>(); // Creating an ArrayList of integers that will store all the birthdays
        ArrayList<String> names = new ArrayList<String>(); // Creating an ArrayList of Strings that will store all the names

        Scanner birthdayIn = new Scanner(System.in); // Creates a new Scanner object to input the birthdays.

        int counter = 0;
        int counterPlusOne = 1;
        int input = 1;

        while (true){
            
            System.out.print("Enter Date Of Birth in 8-digit format for person #" + counterPlusOne + ": (YYYYMMDD) Enter 0 to move on: "); // Prompts the user
            try{ // Implemented a try-catch statement here to catch any incorrect inputs
                input = birthdayIn.nextInt(); // stores the user's input in a variable
            }
            catch(Exception InputMismatchException){
                errorProcedureInt(); // calling the errorProcedure method which will alert the user of their mistake and end the program
            }
            if (input == 0){ // This is IMPORTANT: this is the escape key which signifies when the user is done inputting birthdays
                break;
            }
            if(dataValidation(input)!=true){ // Makes sure input is valid
                errorProcedureInt(); // if not valid, calls the errorProcedure defined below
            }
    
            bDays.add(input); // adding the input to the ArrayList once it passes all tests
            counter++; // Incrementing the counters
            counterPlusOne++;
        }
        
        Scanner personNames = new Scanner(System.in); // Creates a second scanner object to input the names.

        int counterNames = 0;
        int counterNamesPlusOne = 1;
        String inputName = "";

        while (counterNames<counter){
            System.out.print("Enter the name for person #" + counterNamesPlusOne + ": "); // Prompts user for name corresponding to first DOB
            try{ // Implemented a try-catch statement here to catch any incorrect inputs
                inputName = personNames.nextLine();
            }
            catch(Exception InputMismatchException){
                errorProcedureString(); // calling the errorProcedure method which will alert the user of their mistake and end the program
            }
            names.add(inputName); // Adds String to ArrayList if it passes all tests
            counterNames++; // Incrementing the counters
            counterNamesPlusOne++;
        }

        for (int i = 0; i<names.size(); i++){ // Loops through all the names and DOBs in the ArrayLists and converts them to the new format
            System.out.println("\n" + names.get(i) + "'s date of birth is " + convertDateFormat(bDays.get(i))); 
        }

        System.out.println("\n" + checker(bDays, names)); // calls the checker method to determine hierarchy of age

        birthdayIn.close(); 
        personNames.close();
        System.exit(0);
    }

    /*
    Input parameters:
        ArrayList<Integer> bDays -> ArrayList containing all the DOBs (date of birth)
        ArrayList<String> names -> ArrayList containing all the names of the corresponding DOBs

    Description:
        First sorts both ArrayLists from smallest to greatest (using the values in bDays)
        Then creates a string that makes it clear who is older than who. It also checks for same-age values and notifies the user
    
    Output:
        Outputs a String with the relative ages of each of the inputs.
    */
    public static String checker(ArrayList<Integer> bDays, ArrayList<String> names){
        int temp; // Innitializing temp variables to perform a swap later on
        String tempS;
        for(int i = 0; i<bDays.size(); i++){ // Simple bubble sort algorithm implementation that arranges the values of the ArrayList from smallest to greatest
            for (int j = 0; j<bDays.size()-1; j++){
                if(bDays.get(j)>bDays.get(j+1)){

                    temp = bDays.get(j); // assigning bdays[j] to temp so that the value is not lost when it is overwritten
                    tempS = names.get(j);

                    bDays.set(j, bDays.get(j+1));
                    names.set(j, names.get(j+1));
                    
                    bDays.set(j+1, temp); // completing the swap
                    names.set(j+1, tempS);
                }
            }
        }
        
        String answer = ""; // Creates empty string that will later be added to
        for (int k = 0; k<bDays.size(); k++){ // iterates through the bDays list and appends the corresponding names 
            answer += names.get(k);

            if ((k<bDays.size()-1) && (bDays.get(k).equals(bDays.get(k+1)))){ // if the age of two people are the same, appends ", is the same age as "
                answer += ", is the same age as ";
            }
            else{
                answer += ", is older than "; // If they are not the same, appends ", is older than ". it will always be older than since the Lists are sorted
            }
        }
        answer = answer.substring(0, (answer.length()-16)); // Removes the final ", is older than "
        answer += "!";
        return answer;
    }

    /*
    Input parameters:
        int date -> takes in a DOB to be converted to a new format

    Description:
        Uses integer division and the modulo function to splice out fragments of the DOB and then creates a new format.
    
    Output:
        Returns a string combining the month, day and year variables into the proper format.
    */
    public static String convertDateFormat(int date){
        int month = date/100%100; // int dividing by 100 to remove the last two digits. Then use modulo 100 to isolate the month value
        int day = date%100; // Modulo 100 returns the last two digits which is the date. Modulo calculates the remainder.
        int year = date/10000; // int dividing by 10000 to get the first 4 digits
        return "" + month + "/" + day + "/" + year; 
    }

    /*
    Input parameters:
        int date -> takes in a DOB to be validated
    Description:
        This method validates the inputted birthday to make sure they are in the correct format
    Output:
        Returns true if valid or false if invalid
     */

    public static boolean dataValidation(int date){
        String dateToString = date+"";
            if (dateToString.length() != 8 || date/100%100 > 12 || date%100 > 31){ // checking to make sure that neither the date nor day can be absurdly large as to be impossible. Also veryfying hat the int is 8 digits
                return false;
            }
        return true;
    }

    /*
    This method ends the program and tells the user what went wrong.
     */
    public static void errorProcedureInt(){
        System.out.println("Enter a Valid 8-digit int!");
        System.exit(0); // ends program
    }

    /*
    This method ends the program and tells the user what went wrong (specific to String inputs).
     */
    public static void errorProcedureString(){
        System.out.println("Enter a Valid String!");
        System.exit(0);// ends program
    }
}