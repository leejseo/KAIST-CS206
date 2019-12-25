package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
        //implement here.
		
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = "";
        for (int i=0; i<4; i++){
            if (i > 0) t += '.';
            int st = 8*i;
            int ans = 0;
            for (int j=0; j<8; j++){
                if (s.charAt(st+j) == '1') ans += (1<<(7-j));
            }
            t += ans;
        }
        
        
        //Print the corresponding IP address using a dot-decimal notation:
		System.out.print(t/*put the varaible to print the corresponding IP address*/);//Do not modify the part of the code givein in this line.
		
	}
}
