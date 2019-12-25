package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		String[] months = {
	        "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
	        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
	    }; //Use this given array for the problem 6.
        int[] days = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
	    //implement here.
	    String name; //Use the variable to store the name of a month entered at run time.
        
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        
        String prefix = name.substring(0, 3);
        
        int numday = 0;
        for (int i=0; i<12; i++){
            if(prefix.compareToIgnoreCase(months[i]) == 0) numday = days[i];
        }
        
	    System.out.print(name + " has " + numday/*put the variable here*/+ " days");//Do not modify the part of the code given in this line. 
	}
}
