package elice;

import java.util.*;

public class FasterDesign {
	/*
	 * Count the number of triples (i, j, k) where i< j < k
	 * such that n[i] + n[j] + n[k] == 0 
	 */
	public static void slow(ArrayList<Integer> n) {		
		System.out.println("Using the brute-force algorithm : ");
		int count=0;
		for(int i=0;i<n.size();i++)
			for(int j=i+1;j<n.size();j++) 
				for(int k=j+1; k<n.size();k++){
				if(n.get(i)+n.get(j)+n.get(k)==0)
					count++;
			}
		System.out.println(count);
	}
	
    /****************Homework Assignment 4: Problem 3*******************/
	/*
	 * Count the number of triples (i, j, k) where i< j < k
	 * such that n[i] + n[j] + n[k] == 0 
	 *******************************************************************/
	public static int faster(ArrayList<Integer> n) {		
		System.out.println("Using the faster algorithm : ");
        int ans = 0;
        Collections.sort(n);
		int N = n.size();
		for (int i=0; i<N-1; i++){
			int lo = i+1, hi = N-1;
			while (lo < hi){
				if (n.get(lo)+n.get(hi)+n.get(i) == 0){
					++ans; ++lo; --hi;
				}
				else if (n.get(lo)+n.get(hi) > -n.get(i)){
					--hi;
				}
				else{
					++lo;
				}
			}
		}
        return ans;
	}
}
