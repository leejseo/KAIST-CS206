package elice;

import java.io.*;
import java.util.Scanner;
import elice.EliceUtils;

public class Main {
	public static void main(String args[]) {
	    BST<String, Integer> test = new BST<String, Integer>();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        
        String str;
        
        for(int i=0;i<num;i++) {
        	str =input.nextLine();
        	test.put(str, i);
        	
        }
        test.inorder();
        
        System.out.println("\nTotal number of leaves: "+test.leaves());
        System.out.println("Width of a binary search tree: "+test.width());
        System.out.println("The maximum number of nodes between two nodes: "+test.maxDistance());
        System.out.println("Is a tree balanced?: "+test.balanced());
	}
	
}
