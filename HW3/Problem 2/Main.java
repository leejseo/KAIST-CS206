package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
    System.out.println("Enter 0|1 to convert binary to a decimal integer: (the length must be less than 32) ");
    Scanner input = new Scanner(System.in);
    String binary = input.nextLine();
    
    if(binary.length()>=32){ System.out.println("Invalid argument"); }
    else{
    LinkedStack<Character> s1 = new LinkedStack<Character>();
    //implement here
	for (int i=0; i<binary.length(); i++){
		s1.push(binary.charAt(i));
	}
    System.out.println("What do we have in the stack s1?: ");
    System.out.println(s1.toString());
        
    int a=0; //keeps track of the power
    int result=0; //computed value of a decimal integer
    
    //implement here
	for (;!s1.isEmpty();a++){
		char c = s1.pop();
		if (c == '1') result += Math.pow(2, a);
		System.out.println(a+"\t"+result); //print the computation
	}
	
    
    System.out.println(binary+" is converted to a decimal integer: "+result);
    System.out.println(s1.toString()); //Display what's in the stack after conversion is done.
	}
}
}
