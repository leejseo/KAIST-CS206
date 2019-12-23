package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		ArrayStack<String> cities = new ArrayStack<>();
        
        Scanner input = new Scanner(System.in);
	    int num = input.nextInt();
        input.nextLine(); //consumes \n
	  
	    System.out.println("Enter "+num+" cities: (e.g., Daejeon)");
	    for(int i=0; i<num; i++) {
		    cities.push(input.nextLine());
	    }
	  
	    System.out.println("You pushed those cities onto the Stack cities: ");
	    System.out.println(cities); //ordered from top to bottom
		
	    System.out.println("--------------Use an iterator-----------------");
        for(String s: cities)
            System.out.print(s+" ");
	}
}

