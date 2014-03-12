/**This class is used to convert a string to a long value 
 * without using the standard libraries
 */
package com.zillow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**Class : StringToLong
 * @author Krithiga Sundar Raj
 * 
 */
public class StringToLong {

	/**This is the main method of the class
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		/* This code reads the input from the user */
		System.out.println("Enter your input:");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String inputStr = br.readLine();
		
		long longInput = convertStringToLong(inputStr);
		
		System.out.println("The convert long value of the input string is : " + longInput );
	}
	
	
	/**This function takes the input string and converts it to a long value
	 * @param inputStr
	 * @return sum
	 */
	public static long convertStringToLong(String inputStr){
		long sum = 0; 
		long digitIndex = 1;
		boolean isNegative = false;
		char[] inputCharArray = null;
		
		/* If the input is a negative number, we assign a 
		 * flag and multiple by -1 in the end */
		if(inputStr.startsWith("-")){
			inputCharArray = inputStr.substring(1, inputStr.length()).toCharArray();
			isNegative = true;
		} else {
			inputCharArray = inputStr.toCharArray();
		}
		
		/* This code iterates through the char array to get the digit values 
		 * and adds them together to get the actual long value */
		for(int i = inputCharArray.length - 1; i >= 0; i--){
			sum += (inputCharArray[i] - '0' )* digitIndex;
			digitIndex *= 10;
		}
		if(isNegative){
			sum = sum * (-1);
		}
		return sum;
	}

}
