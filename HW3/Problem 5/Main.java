package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
        QueueNode<String> q1 = new QueueNode<String>();
        
        Scanner input = new Scanner(System.in);
		int num = input.nextInt();
        input.nextLine(); //consumes \n character.
		  
		System.out.println("Enter "+num+" cities: (e.g., Daejeon)");
		for(int i=0; i<num; i++) {
			  q1.enqueue(input.nextLine());
		  }
		  
		System.out.println("You have added those cities to the queue q1: ");
		System.out.println(q1); //from the beginning to the end
        
        QueueNode<String> q2 = new QueueNode<String>();
        
        num = input.nextInt();
        input.nextLine(); //consumes \n character.
        System.out.println("Enter "+num+" cities: (e.g., Daejeon)");
		for(int i=0; i<num; i++) {
			  q2.enqueue(input.nextLine());
		  }
        
        System.out.println("You have added those cities to the queue q2: ");
		System.out.println(q2); //from the beginning to the end
        
        //HW2: Problem 5
        q2.concatenate(q1); //Takes all the elements of q1 and appends them to the end of the queue q2.
        //After the concatenate() operation, the queue q1 becomes an empty queue.
        System.out.println("----------After concatenating the queue----------");
        //HW2: Problem 6
        //Use the foreach statement
        for(String s: q2)
        	System.out.println(s);        
        
        System.out.println("(" + q1.size() + " left on queue (q1))");
		  
	}
}
