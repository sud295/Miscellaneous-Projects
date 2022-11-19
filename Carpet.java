import java.util.Scanner;
public class Carpet{
    public static void main(String[] args){ // Interacts with user and calls the appropriate design
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.print("Which design? (1 or 2?) Enter 0 to break: ");
            int design = input.nextInt();
            if (design == 1){
                designOne();
            }
            else if (design == 2){
                designTwo();
            }
            else{
                input.close();
                System.exit(0);
            }
        }
    }

    public static void designOne(){ // Draws design one
        System.out.println(drawRectangle(4, 21, ".")); // creates a square of dimensions (21x4)

        System.out.println(drawRectangle(21, "*")); // Creates a line of "*" 

        drawArrOne(); // Draws two triangles

        System.out.println(drawRectangle(21, "_")); // Creates another line

        drawChecker(); // Draws a checker pattern

        System.out.println(drawRectangle(21, "_")); // Creates another line

        System.out.println(); // Creates blank line
        System.out.println(); // Creates blank line

        drawDiamond(); // creates diamond

        System.out.println(); // Creates blank line
        System.out.println(); // Creates blank line

        System.out.println(drawRectangle(21, "_")); // Creates another line

        drawChecker(); // Draws checker pattern

        System.out.print(drawRectangle(21, "_")); // Creates another line

        drawArrTwo(); // Draws two triangles

        System.out.println(drawRectangle(21, "*")); // Creates a line of "*" 

        System.out.println(drawRectangle(4, 21, ".")); // creates a square of dimensions (21x4)
    }

    public static void designTwo(){ // Draws design two
        System.out.println(drawRectangle(21, "_")); // Creates a line

        drawChecker(); // Draws checker pattern

        System.out.println(drawRectangle(21, "_")); // Creates a line

        drawArrOne(); // Draws two triangles

        System.out.println(drawRectangle(4, 21, ".")); // creates a square of dimensions (21x4)

        drawDiamond(); // creates diamond

        System.out.println();

        System.out.print(drawRectangle(4, 21, ".")); // creates a square of dimensions (21x4)

        drawArrTwo(); // Draws two triangles

        System.out.println(drawRectangle(21, "_")); // Creates a line

        drawChecker(); // Draws checker pattern

        System.out.println(drawRectangle(21, "_")); // Creates a line
    }

    /*
    Input parameters:
        - int length --> this is the length of the rectangle
        - String Character --> this is the character to be used
    
    Function:
        - This method draws a rectangle with a fixed height of 1
    
    Return value: 
        - rectangle
    */
    public static String drawRectangle(int length, String character){

        String answer = "";
        for (int rows = 0; rows<length; rows++){
            answer+=character;
        }
        return answer;
    }

    /*
    Input parameters:
        - int length --> this is the length of the rectangle
        - String Character --> this is the character to be used
        - int width --> width of the rectangle
    
    Function:
        - This method draws a rectangle with height and width specified by user
    
    Return value: 
        - rectangle
    */
    public static String drawRectangle(int height, int width, String character){ 
        String answer = ""; // this is the string to which the rectangle is going to be appended to
        for (int rows = 0; rows<height; rows++){ // repeats the inner loop height times
            for (int cols = 0; cols<width; cols++){ // creats the width of the rectangle
                answer+=character;
            }
            answer+="\n"; // going to the next line
            
        }
        return answer; 
    }

    /*
    Function:
        - This method draws triangles of fixed size
    Return value: 
        - the two triangles
    */
    public static void drawArrOne(){
        for(int rows = 0; rows<5; rows++){ // establishes a height of 5
            for(int colsOne = 0; colsOne<5-rows; colsOne++){ // Starts the first triangle
                System.out.print("*");
            }
            for(int colsTwo = 0; colsTwo<11+rows; colsTwo++){  // Adds the space in between the two triangles
                System.out.print(" ");
            }
            System.out.print(drawRectangle(rows, " ")); // Starts the second triangle
            for(int colsThree = 0; colsThree<5-rows; colsThree++){
                System.out.print("*");
            }
            System.out.println(); // goes to the next line
        } 
    }

    /*
    Function:
        - This method draws triangles of fixed size (inverse of ArrOne)
    Return value: 
        - the two triangles
    */
    public static void drawArrTwo(){
        for(int  rows= 5; rows>=0; rows--){ // establishes a height of 5
            for(int colsOne = 0; colsOne<5-rows; colsOne++){ // Starts the first triangle
                System.out.print("*");
            }
            for(int colsTwo = 0; colsTwo<11+rows; colsTwo++){ // Adds the space in between the two triangles
                System.out.print(" ");
            }
            System.out.print(drawRectangle(rows, " "));
            for(int colsThree = 0; colsThree<5-rows; colsThree++){ // Starts the second triangle
                System.out.print("*");
            }
            System.out.println(); // goes to the next line
        }
    }

    /*
    Function:
        - This method draws a checker pattern of a fixed size
    Return value: 
        - the checker pattern
    */
    public static void drawChecker(){ 
        for(int rows = 0; rows<3; rows++){ // establishes the first layer of the checker as having a height of 3
            System.out.print(drawRectangle(5, " ")); // Calling the drawRectangle method to make a line (acts as a buffer to center the checker)
            System.out.print(drawRectangle(3, "*")); // first square in the checker
            System.out.print(drawRectangle(5, " ")); // Space in between the squares
            System.out.print(drawRectangle(3, "*")); // Second square
            System.out.println(); // Goes to the next line
        }
        for(int rows = 0; rows<3; rows++){ // establishes the first layer of the checker as having a height of 3
            System.out.print(drawRectangle(8, " ")); // Creates the buffer
            System.out.print(drawRectangle(5, "*")); // Draws the square
            System.out.println(); 
        }
        for(int rows = 0; rows<3; rows++){ // establishes the first layer of the checker as having a height of 3
            System.out.print(drawRectangle(5, " ")); // Calling the drawRectangle method to make a line (acts as a buffer to center the checker)
            System.out.print(drawRectangle(3, "*")); // first square in the checker
            System.out.print(drawRectangle(5, " ")); // Space in between the squares
            System.out.print(drawRectangle(3, "*")); // Second square
            System.out.println(); // Goes to next line
        }
    }

    /*
    Function:
        - This method draws a diamond pattern of a fixed size
    Return value: 
        - the diamond pattern
    */
    public static void drawDiamond(){
        for(int rows = 0; rows<5; rows++){ // Creates the top half of the diamond
            System.out.print(drawRectangle(5, " ")); // Creats the space in front of the diamond to center it
            for(int colsOne = 0; colsOne<5-rows; colsOne++){ // prints the space in between the stars (a triangle of space)
                System.out.print(" ");
            }
            for(int colsTwo = 0; colsTwo<rows+rows+1; colsTwo++){  // Prints the stars (actual diamond)
                System.out.print("*");
            }
            System.out.println(); // Goes to next line
        }
        for(int rows = 5; rows>=0; rows--){ // Creates the bottom half of the diamond
            System.out.print(drawRectangle(5, " ")); 
            for(int colsOne = 0; colsOne<5-rows; colsOne++){ // prints the space in between the stars (a triangle of space)
                System.out.print(" "); 
            }
            for(int colsTwo = 0; colsTwo<rows+rows+1; colsTwo++){ // Prints the stars (actual diamond)
                System.out.print("*");
            }
            System.out.println(); // Goes to next line
        }
    }
}