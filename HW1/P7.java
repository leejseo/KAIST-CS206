package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static boolean test(String x, String y) {
        //implement here.
        //One can use greedy algorithm
        int n = x.length();
        int m = y.length();
        if (n > m) return false;
        if (n == m) return x.equals(y);
        int idx = 0;
        for (int i=0; i<m; i++){
            if (x.charAt(idx) == y.charAt(i)) ++idx;
            if (idx == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	//implement here.
        
        Scanner input = new Scanner(System.in);
        
        String x = input.nextLine(); //Use this variable to store the first string entered at run time.
        String y = input.nextLine(); //Use this variable to store the second string entered at run time.
       
       
        System.out.println(test(x, y)); //Do not modify this line of code.
    
	}
}

