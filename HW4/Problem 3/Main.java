package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String args[]) {
    /*******************Do not modify Main.java*******************/
		Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer (up to 5000): ");
        int size = input.nextInt();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        
        for(int i=1; i<size;i++) {
        	list.add(new Integer(i*(rand.nextBoolean()?-1:1)));
            //add distinct elements into the arraylist.
        }
       Collections.shuffle(list);
        
        
	    System.out.println("What do we have in the array?");
	    for(Integer n: list)
	    	System.out.print(n+" ");
	    
	    System.out.println();
	    StopWatch timer1 = new StopWatch();
	    FasterDesign.faster(list);
	    double time1 = timer1.elapsedTime();
	    System.out.printf("(%.2f seconds)\n", time1);
	    
	    System.out.println();
        StopWatch timer2 = new StopWatch();
	    FasterDesign.slow(list);
	    double time2 = timer2.elapsedTime();
	    System.out.printf("(%.2f seconds)\n", time2);
	}
}

