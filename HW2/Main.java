package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		System.out.println("Testing SinglyLinkedlist");
		SinglyLinkedList<Integer> s = new SinglyLinkedList<Integer>();
		
		int size = (int)(Math.random()*10)+2;
		for(int i=0; i<size; i++) {
			s.addFirst((int)(Math.random()*10)); //add pseudo-random integers to the list
		}
		System.out.println("What do we have in our list?: ");
		System.out.println(s); //what do we have in our list?
		
		System.out.println("\nWe removed "+s.removeLast());
		System.out.println("After removing a tail of the list: ");
        System.out.println(s); 
        		
		s.reverse();	
		System.out.println("\nAfter reversing the list: ");
		System.out.println(s); 
		
		System.out.println("Enter any integer between 0 and 2^31-1: ");
        Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println("\nDo we have this number in our list?: (using sequential search) "+num);
		Boolean result1 = s.contains(num); //sequential search
		if(result1 == true) {
			System.out.println(num+"  is in our list.");
			System.out.println("How many times does "+num+" appear?: "+s.count(num));
		}		
		else
			System.out.println(num+" is not in our list.");
		
		
		System.out.println("Do we have this number in our list?: (using recursive search) "+ num);
		result1 = s.contains_rc(num); //recursive search
		if(result1 == true) {
			System.out.println(num+"  is in our list.");
			System.out.println("How many times does "+num+" appear?: "+s.count(num));
		}		
		else	           
			System.out.println(num+" is not in our list.");
	}
}
