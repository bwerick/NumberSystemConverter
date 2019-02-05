import java.util.Scanner;
import java.lang.Math;


public class DecToBinary{
	
	public static void main (String [] args) {
		
		
		int xInput= 0; //will hold number input by user
		String binOutput= ""; //what will be printed for binary
		String hexOutput= "";
		int numSysChoice=0;
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Please enter a decimal integer: ");
		//xInput = sc.nextInt(); //take users input
		
		
		
		
		
		
		//System.out.println(binOutput); //remove comment to test original string before reversing		
		//System.out.println(binToDec(binOutput)); //use to check if Binary to Decimal is working
		//System.out.println(hexToDec(hexOutput)); //use to check if Hex to Decimal is working
		
		
		
		
		
	do {	System.out.println("Is your number in Decimal, Hexadecimal, or Binary? \n"
				+ "\t[1]Decimal\n"
				+ "\t[2]Hexadecimal\n"
				+ "\t[3]Binary\n"
				+ "\t[0]Quit");
		
		numSysChoice= sc.nextInt();
		
		switch (numSysChoice) {
			case 1:  //they will enter a decimal number
				System.out.println("Please enter your Decimal integer: \n");
				 xInput= sc.nextInt();
				 
				binOutput=toBinary(xInput); //method inserts string 	
				System.out.println("Your Decimal number in binary is: \n");
					
				System.out.println("\n"+reverseString(binOutput)+ "\n");
					
				hexOutput = toHexadecimal(xInput);
					
				System.out.println("Your Decimal number in Hexadecimal is: \n");
					
				System.out.println("\n"+ reverseString(hexOutput)+ "\n\n\n");
				
				break;
				
			case 2: //they choose to enter the number in hex
				System.out.println("Please enter your Hexadecimal integer: ");
				sc.nextLine();
				hexOutput= sc.nextLine();
				
				System.out.println("Your Hexadeximal number in Binary is: \n");
				System.out.println(reverseString(hexToBin(hexOutput))+"\n");
				
				System.out.println("Your Hexadeximal number in Decimal is: \n");
				System.out.println(hexToDec(hexOutput)+ "\n\n\n");
				
				break;
			case 3: //they choose to enter the number in binary
				System.out.println("Please enter your Binary integer: ");
				sc.nextLine();
				binOutput= sc.nextLine();
				
				System.out.println("Your Binary number in Hexadecimal is: \n");
				System.out.println(reverseString(binToHex(binOutput))+"\n");
				
				System.out.println("Your Binary number in Decimal is: \n");
				System.out.println(binToDec(binOutput)+ "\n\n\n");
				
				break;
			default:
				System.out.println("That is not an option.");
				break;
				
		}
	 }while ( numSysChoice != 0);	
	}
	public static String toBinary(int x) { //recursive method that will return the binary numbers
		int binReturn=0;
		String binOut="";
		
		
		if (x == 0) {
			return "";
		}
		else {
			binReturn= x%2;
			
			binOut= Integer.toString(binReturn);
			//System.out.print(binReturn);
			
			return binOut = binOut + toBinary(x/2); 
		}
		
	}//end toBinary
	public static String toHexadecimal(int x) { //recursive method that will return the hex numbers
		int binReturn=0;
		String binOut="";
		
		
		if (x == 0) {
			return "";
		}//stop case
		else {
			binReturn= x%16; //the remainders are the digits for the new representation
			
			
				
			if(binReturn == 10) {
				binOut="A";
			}else if(binReturn == 11) {
				binOut="B";
			}else if(binReturn == 12) {
				binOut="C";
			}else if(binReturn == 13) {
				binOut="D";
			}else if(binReturn == 14) {
				binOut="E";
			}else if(binReturn == 15) {
				binOut="F";
			}else {
				binOut= Integer.toString(binReturn);
			}
			
			//System.out.print(binReturn);
			
			return binOut = binOut + toHexadecimal(x/16); 
		}//end else
		
	}//end toHexadecimal
	public static int binToDec(String stIn) {
		String stIn1=reverseString(stIn);
		int total=0;
		int indVal=0;
		
		for (int i=0; i< stIn1.length()  ;i++) {
			String eval= Character.toString(stIn1.charAt(i));
			indVal= Integer.parseInt(eval);
			indVal= indVal * (int)Math.pow(2,i);
			total= total+indVal;
		}
		return total;
	}// end binToDec
	public static int hexToDec(String stIn) {
		String stIn1= reverseString(stIn);
		int total=0;
		int indVal=0;
		
		for (int i=0; i< stIn1.length()  ;i++) {
			String eval= Character.toString(stIn1.charAt(i));
			if (eval.equals("A")) {
				indVal=10;
				
			}else if(eval.equals("B")) {
				
				indVal=11;
				
			}else if(eval.equals("C")) {
				indVal=12;
				
			}else if(eval.equals("D")) {
				indVal=13;
				
			}else if(eval.equals("E")) {
				indVal=14;
				
			}else if(eval.equals("F")) {
				indVal=15;
				
			}else {
				indVal= Integer.parseInt(eval);
			}
			indVal= indVal * (int)Math.pow(16,i);
			total= total+indVal;
		}
		return total;
	}// end hextodec
	public static String binToHex(String stIn) {
		int decBin;
		String hexDec;
		decBin= binToDec(stIn);
		hexDec= toHexadecimal(decBin);
		
		return hexDec;
	}
	public static String hexToBin(String stIn) {
		int decHex;
		String binDec;
		decHex= hexToDec(stIn);
		binDec= toBinary(decHex);
		return binDec;
	}
	public static String reverseString(String stIn) {
		char[] in= stIn.toCharArray();
		int indFirst= 0; //starts at index 0
		int indLast= in.length - 1; //last index of char array
		char temp;
		while(indLast>indFirst) {
			temp = in[indFirst];
			in[indFirst] = in[indLast];
			in[indLast] = temp;
			indLast--;
			indFirst++;
			
		}//end while loop
		return new String(in);
	}//end reverse string
	
}