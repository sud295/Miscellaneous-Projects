import java.net.URL;
import java.util.Scanner;
public class Part3{
    static String[][] originalFigure = { // The original hangman figure that remains constant
        {"|","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"," "," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","-","-","-"," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," ","|"," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","-","-","-"," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","/"," ","|"," ","\\"," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","/"," "," ","|"," "," ","\\"," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"," "," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","/"," ","\\"," "," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","/"," "," "," ","\\"," "," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","/"," "," "," "," "," ","\\"," "," "},
        {"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
        {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"}
    };

    public static void main(String[] args){
        String[][] figure = new String[originalFigure.length][originalFigure[0].length]; // Making a copy of the original String that does not modify the original
        for (int row = 0; row<figure.length; row++){ 
            for (int col = 0; col<figure[0].length; col++){
                figure[row][col] = originalFigure[row][col];
            }
        }
        
        String[] words = new String [74]; // Creating an array to store the bank of words
        Scanner guess = null; // Creating Scanner that will be used to read in the words

        try{
            URL loc = new URL("https://cs.nyu.edu/~odeh/resources/python/animals.txt"); // New URL object

            guess = new Scanner(loc.openStream());
            Scanner guessWord = new Scanner(System.in); // Scanner object to interact with user

            int ind = 0;

            while (guess.hasNext()){ // Loading words into array
                words[ind] = guess.nextLine();
                ind++;
            }


            String word = words[((int) (Math.random()*75))]; // Selecting a random word from the array


            String[] spl = word.split(""); // Splitting the word into an array of individual letters. This is used to compare user input
            char[] display = new char[word.length()]; // This is the array that innitially displays dashes and changes according to the user input


            for (int i = 0; i< display.length; i++){ // Setting values to '_'
                display[i] = '_';
            }

            int status = 0; // Status 0 means player lost and status 1 means player won
            int lives = 6; // Player gets 6 lives


            while(true){
                drawFig(figure); // draw figure
                printDisplay(display); // print dashes

                System.out.println();
                System.out.print("Guess Letter (OR type 'hint' for a hint!): ");

                String a = guessWord.nextLine(); // the user's guess
                if(a.toLowerCase().equals("hint")){
                    getHint(word);
                    System.out.print("Guess Letter: ");
                    a = guessWord.nextLine();
                }
                boolean answerdCorrectly = false; // True means that the user chose a correct letter
                char letter = a.charAt(0);

                for (int i = 0; i< spl.length; i++){ // Checking if user input equals any letters in word
                    if((letter+"").equals(spl[i])){ // if user chose a correct letter
                        display[i] = letter; // change dash to the letter
                        answerdCorrectly = true; // set this to true
                    }

                }

                if (answerdCorrectly == false){ // If the user chose a wrong letter
                    lives--; // remove a life
                        deconstruct(lives, figure); // remove a body part
                    if (lives<1){
                        guessWord.close(); // if user has no lives left exit game
                        break;
                    }
                }

                boolean finished = true; // true if game is finished
                for (int i = 0; i< display.length; i++){ // check for dashes
                    if(display[i] == '_'){ // if there are any dashes, 
                        finished = false; // game is not finished yet (assuming there are still lives)
                    }
                }
                
                if (finished == true){ // if no dashes were found, user has won
                    status = 1; // updating to winning status
                    guessWord.close();
                    break;
                }
            }

            if (status == 1){ // if the user won
                System.out.println(); 
                System.out.print("YOU WIN! --> ");
                printDisplay(spl); // print correct word
                System.out.println();
            }

            else{ // if user loses
                System.out.println();
                System.out.print("YOU LOSE! --> ");
                printDisplay(spl); //print correct word
                System.out.println();
            }
        }


        catch (Exception e){ // catch exceptions and deliver them in a controlled manner
            System.err.println(e.getMessage());
        }


        finally{ // close Scanner and exit 
            guess.close();
            System.exit(0);
        }
    }


    public static void deconstruct(int chances, String[][] figure){ // Removes body parts depending on lives
        if (chances == 6){
        }
        else if (chances == 5){
            modFig(removeHand("L"), figure); // Removes left hand
        }
        else if (chances == 4){
            modFig(removeHand("R"), figure);// Removes right hand
        }
        else if (chances == 3){
            modFig(removeLeg("R"), figure);// Removes right leg
        }
        else if (chances == 2){
            modFig(removeLeg("L"), figure);// Removes left leg
        }
        else if (chances == 1){
            modFig(removeBody(), figure);// Removes body
        }
        else{
            modFig(removeHead(), figure);// Removes head
        }
    }

    public static void printDisplay(char[] disp){
        for (int i = 0; i< disp.length; i++){ // Prints the dashes
            System.out.print(disp[i]);
        }
    }
    public static void printDisplay(String[] disp){
        for (int i = 0; i< disp.length; i++){ // Prints the original word
            System.out.print(disp[i]);
        }
    }

    public static void drawFig(String[][] figure){ // Draws the figure
        for (int rows = 0; rows<figure.length;rows++){
            for (int cols = 0; cols<figure[rows].length;cols++){
                System.out.print(figure[rows][cols]);
            }
            System.out.println();
        }
    }

    public static void modFig(String[] modifications, String[][] figure){ // Takes the coordinates of each body part and replaces the characters with spaces
        for(int row = 0; row<modifications.length; row++){
            String[] coordinates = modifications[row].split(",");
            figure[Integer.valueOf(coordinates[0])][Integer.valueOf(coordinates[1])] = " ";
        }
    }

    public static String[] removeHand(String side){ // Returns the coordinates of the hand
        String[] ans = new String[2];
        if (side == "L"){
            ans[0] = "7,16";
            ans[1] = "8,15";
        }
        if (side == "R"){
            ans[0] = "7,20";
            ans[1] = "8,21";  
        }
        return ans;
    }

    public static String[] removeLeg(String side){ // Returns the coordinates of the leg
        String[] ans = new String[3];
        if (side == "L"){
            ans[0] = "11,17";
            ans[1] = "12,16";
            ans[2] = "13,15";
        }
        if (side == "R"){
            ans[0] = "11,19";
            ans[1] = "12,20"; 
            ans[2] = "13,21";
        }
        return ans;
    }

    public static String[] removeBody(){ // Returns the coordinates of the body
        String[] ans = new String[6];
        ans[0] = "5,18";
        ans[1] = "6,18";
        ans[2] = "7,18";
        ans[3] = "8,18";
        ans[4] = "9,18";
        ans[5] = "10,18";
        return ans;
    }

    public static String[] removeHead(){ // Returns the coordinates of the head
        String[] ans = new String[8];
        ans[0] = "2,17";
        ans[1] = "2,18";
        ans[2] = "2,19";
        ans[3] = "3,16";
        ans[4] = "3,20";
        ans[5] = "4,17";
        ans[6] = "4,18";
        ans[7] = "4,19";
        return ans;
    }   

    public static void getHint(String word){ // Retrieves a hint from dictionary.com
        Scanner reader = null; // Creating a new scanner to read source code of the website
        String finalForm = "";
        try {
            URL dict = new URL("https://www.dictionary.com/browse/"+word); // Accessing the webpage for a specific word
            reader = new Scanner(dict.openStream()); 
            int index = 0;
            String[] lines = new String[500]; // The webpage is usually around 200 lines so this gives me headroom
            while(reader.hasNextLine()){
                lines[index] = reader.nextLine(); // putting the webpage into an array
                index++;
            }
            String intermediateForm = lines[8]; // line 9 on the webpage always contains the definition. I extract it here.
            intermediateForm = intermediateForm.substring(49+word.length(), intermediateForm.length()-11); // Here, I remove the HTML code before and after the definition
            String[] separated = intermediateForm.split(" "); // Split definition into constituent words
            finalForm = "";
            
            for(int i = 0; i<separated.length;i++){ // find instances of the word in the hint and censor it
                if (separated[i].toLowerCase().contains(word)){
                    separated[i] = generateDash(word.length()); // calls the function to generate an equal number of dashes as the length of the word
                }
                finalForm += separated[i] + " "; // appends to the final answer
            }
            String placeHolder = finalForm.charAt(0)+""; // extract the first letter to capitalize
            finalForm = finalForm.substring(1, finalForm.length()); // Removing the first character which is usually lower case
            finalForm = placeHolder.toUpperCase() + finalForm; // Adding the new upper case first character to the string
            System.out.println(finalForm);


        } catch (Exception e) {
            System.err.println("Error: "+e.getMessage());
        }

    }
    public static String generateDash(int len){ // Generate dashes corresonding to the length of the word
        String ans = "";
        for (int i = 0; i<len; i++){
            ans+="_";
        }
        return ans;
    }
}