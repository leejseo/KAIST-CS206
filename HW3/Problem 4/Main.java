package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		LinkedQueue<Integer> cities = new LinkedQueue<>();
		
		 Scanner input = new Scanner(System.in);
		  int num = input.nextInt();
          input.nextLine(); //consumes \n character.
		  
		  System.out.println("Enter "+num+" cities: (e.g., Daejeon)");
		  for(int i=0; i<num; i++) {
			  cities.enqueue(input.nextInt());
		  }
		  
		  System.out.println("You added those cities to the queue cities: ");
		  System.out.println(cities);
		  
		  System.out.print("Enter the city you want to search: ");
		  Integer query= input.nextInt();
		  System.out.println(cities.contains(query));
		  
		  System.out.println("------After a search process------");
		  System.out.println(cities);
	}
}

