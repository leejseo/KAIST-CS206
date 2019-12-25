package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
    public static String echo(String s) {
        System.out.println("Called the echo() function"); // Do not modify this line of code.
        return s+s;
        // Implement here   
		
	}
	public static void main(String args[]) {
        // Implement here.
		
        Scanner input = new Scanner(System.in);
        
		String s; // Use this variable to store the first string entered at run time.
		String t; // Use this variable to store the second string entered at run time.
        
        s = input.nextLine();
        t = input.nextLine();
        
		s = echo(s); // Do not modify this line of code.
		t = echo(echo(t));// Implement here. Hint: Consider calling the echo function as many times as you need to get the result.
		System.out.print(s + t); // Do not modify this line of code.
	}
}
