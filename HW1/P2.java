package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		//implement here.
        // Use this average varaible to compute the average.
        double average = 0;
        int N = 0;
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()){
            N++;
            double x = input.nextDouble();
            average += x;
        }
        average /= N;

        // print the result using the given variable:
        System.out.println("Average is "+average);//Do not modify this line of code. 
	}
}
