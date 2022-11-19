import java.util.Scanner; 
import java.util.HashMap;

public class NumberConversions{
    public static void main(String[] args){
        while (true){
            run(); // Calling the method to run
        }
    }

    public static void run(){ // This is controller method that calls on all other methods and interacts with the user
        HashMap<String, Integer> conversionBases = new HashMap<String, Integer>(); // Mapping the user inputs for each number system to their respective bases for calculations
        conversionBases.put("dec", 10); // The key value maps to the int value
        conversionBases.put("hex", 16);
        conversionBases.put("bin", 2);
        conversionBases.put("oct", 8);

        Scanner input = new Scanner(System.in); // Creating an input variable to get user data

        System.out.print("Convert from? (Enter 'b' to exit): "); // Prompting user for original number type
        String originalType = input.nextLine();

        if (originalType.equals("b")){ // Breaking the loop
            input.close();
            System.exit(0);
        }

        System.out.print("Convert To?: "); // Prompting user for desired number type
        String resultType = input.nextLine();

        System.out.print("Enter Input: ");
        String numberToConvert = input.nextLine(); // Assigning the number to use to a variable
    
        if(originalType.equals("dec")){ // This block executes if the original type was "dec"
            String answer = decToConvert(Integer.valueOf(numberToConvert), conversionBases.get(resultType)); // Calculates the value of the original number in the new base by running through decToConvert
            System.out.println(numberToConvert + " is " + answer + " in " + resultType); // Prints answer in a string
        }

        else if(originalType.equals("hex")){

            HashMap<String, Integer> hexadecimalMap = new HashMap<String, Integer>(); // Hashmap that links every numeric value between 10 and 15 to an aphabet because of the way hex works
            hexadecimalMap.put("A", 10);
            hexadecimalMap.put("B", 11);
            hexadecimalMap.put("C", 12);
            hexadecimalMap.put("D", 13);
            hexadecimalMap.put("E", 14);
            hexadecimalMap.put("F", 15);

            try {
                String answer = decToConvert(hexadecimalMap.get(numberToConvert), conversionBases.get(resultType)); // the first block calls the numeric value of the letter provided. If it returns an error (i.e. there is no letter provided) ignores this block
                System.out.println(numberToConvert + " is " + answer + " in " + resultType);
            } 
            catch (Exception e) {
                int intermediateValue = Integer.valueOf(convertToDec(numberToConvert, 16)); // if there is no letter input, converts the hex number to a decimal
                String answer = decToConvert(intermediateValue, conversionBases.get(resultType)); // converts the intermediate decimal value to the desired result type
                System.out.println(numberToConvert + " is " + answer + " in " + resultType); // prints answer
            }
        }

        else if(originalType.equals("bin")){
            int intermediateValue = Integer.valueOf(convertToDec(numberToConvert, 2)); // converts bn number to dec
            String answer = decToConvert(intermediateValue, conversionBases.get(resultType)); // converts the intermediate decimal value to the desired result type
            System.out.println(numberToConvert + " is " + answer + " in " + resultType); // prints answer
        }

        else if(originalType.equals("oct")){
            int intermediateValue = Integer.valueOf(convertToDec(numberToConvert, 8)); // converts oct number to dec
            String answer = decToConvert(intermediateValue, conversionBases.get(resultType)); // converts the intermediate decimal value to the desired result type
            System.out.println(numberToConvert + " is " + answer + " in " + resultType); // prints answer
        }

        else{
            System.out.println("Invalid type (Choose: bin, hex, oct, dec)"); // if the input types were not valid, tells the user
        }
        System.out.println();
    }

    /*
    Input parameters:
        - int input --> this is the decimal value to be converted
        - int base --> this is the base to be converted to
    
    Function:
        - This method takes a decimal value and converts it to some other number type
    
    Return value: 
        - The converted number
    */
    public static String decToConvert (int input, int base){  
        int inputToManipulate = input; // assigning the input value to a new variable so that math operations can be performed
		int toCalculate; // this retains input's value so that input can be divided
		int remainder; // stores remainder value which can then be appended to string
		String reversedAnswer = "";	
		while(inputToManipulate/(base*1.0) > 0) { // as long as quotient is greater than 0, loop will perform
			toCalculate = inputToManipulate;
			inputToManipulate = inputToManipulate/base;
			remainder = toCalculate%base;
			reversedAnswer += remainder; // Algorithm continually divides input and appends the remainder to a string. When loop breaks, the string is the reversed answer.
		}
		String correctAnswer = "";
		for(int i = reversedAnswer.length()-1; i>=0 ; i--) { // Simple string reversal
			correctAnswer += reversedAnswer.charAt(i);
		}	
        
        if(base == 16 && (input<16 && input>9)){ // this checks for the special case: if the return type is hex and between (9,16), this block executs because those hex values are letters
            HashMap<String, String> hexadecimalMap = new HashMap<String, String>(); // creates a map assigning every numeric digit (that would have been produced with the algorithm above) to a letter
            hexadecimalMap.put("01", "A");
            hexadecimalMap.put("11", "B");
            hexadecimalMap.put("21", "C");
            hexadecimalMap.put("31", "D");
            hexadecimalMap.put("41", "E");
            hexadecimalMap.put("51", "F");
            try{
                correctAnswer = hexadecimalMap.get(correctAnswer); // attempts to match the answer calculated above to a letter, if it fails, the catch block prevents any errors.
            }
            catch(Exception e){        
            }
        }
        return correctAnswer; // return the converted number
    }

    /*
    Input parameters:
        - String inputString --> this is the value in a different number type to be converted to decimal
        - int base --> this is the base to be converted from
    
    Function:
        - This method takes a number and converts it to decimal. Algorithm works by taking the right most digit and multiplying it with (base**i)
    
    Return value: 
        - The converted decimal number
    */
    public static int convertToDec (String inputString, int base){ 
        int power = 0; // the power to which digits will be raised to
		int convertedDigit = 0; // this is where the answer will append to
		for(int i = inputString.length()-1; i>=0; i--) { // for loop starts at the right and goes left
			int characterInNumber = Character.getNumericValue(inputString.charAt(i)); 
			convertedDigit += characterInNumber*Math.pow(base, power); 
			power++;	// increments power
		}
        return convertedDigit; // returns the converted digits
    }
}