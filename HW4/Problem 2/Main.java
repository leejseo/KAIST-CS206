package elice;

import java.io.*;
import java.util.*;
import elice.EliceUtils;


public class Main {
	public static void main(String args[]) {
        System.out.println("Enter an integer (up to 6500000): ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int rand;
		for(int i=0;i<num;i++) {
			list.add((int)(Math.random()*num));
		}
		System.out.println("We have generated "+list.size()+"  items.");
		
		DistinctQueue test = new DistinctQueue();
		
		StopWatch timer1 = new StopWatch();
        for(int i=0; i<num;i++) {
        	test.enqueue(list.get(i));
        }
        double time1 = timer1.elapsedTime();
	    System.out.printf("\n(%.2f seconds)\n", time1);
		System.out.println("How many distinct keys do we have after adding all the keys? "+test.size());
		System.out.println("**************************************************");
        
		int n = test.size();
		StopWatch timer2 = new StopWatch();
		for(int i=0;i<n;i++) {
			test.dequeue();
		}
		double time2 = timer2.elapsedTime();
		System.out.printf("(%.2f seconds)\n", time1);
		System.out.println("How many distinct keys do we have after removing all the keys? "+test.size());
		System.out.println("***************************************************");
        test.show();
		
	}
}

