package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		LinkedStack<String> cities = new LinkedStack<>();
        
        Scanner input = new Scanner(System.in);
	    int num = input.nextInt();
        input.nextLine(); //consumes \n
	  
	    System.out.println("Enter "+num+" cities: (e.g., Daejeon)");
	    for(int i=0; i<num; i++) {
		    cities.push(input.nextLine());
	    }
	  
	    System.out.println("You pushed those cities onto the Stack cities: ");
	    System.out.println(cities); //ordered from top to bottom
		
	    //HW assignment 2: Problem 1
	    LinkedStack<String> A = new LinkedStack<String>();
        
        LinkedStack.transfer(cities, A); // contents in A are in reverse order as original
        System.out.println("-------------Transfer all elements----------");
        System.out.println("What do we have in the stack cities?: "+cities);
        System.out.println("What have we transferred to a new stack A?: "); 
        System.out.println(A); //ordered from top to bottom
	}
}

