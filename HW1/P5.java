package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
		//implement here.
        
        Scanner input = new Scanner(System.in);
        
        int mem[] = new int[100];
        
        while (input.hasNextInt()){
            ++mem[input.nextInt()];
        }
        
        
        //Print the output:
		//System.out.println(/*put the variable*/+" "+/*put the variable*/);//Do not modify the part of the code given in this line.
		for (int i=0; i<100; i++){
            if (mem[i] != 0){
                System.out.println(i+" "+mem[i]);
            }
        }
	}

}
