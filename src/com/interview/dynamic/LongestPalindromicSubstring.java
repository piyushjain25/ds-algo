package com.interview.dynamic;

public class LongestPalindromicSubstring {

	public int calculate(char[] str) {
		boolean T[][] = new boolean[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			T[i][i] = true;
		}
		int min = 0;
		int max = 0;
		
		for(int loop = 1; loop < str.length; loop++) {
			for (int i = 0, j = loop; i < str.length & j < str.length; i++, j++) {
				if(str[i] == str[j]) {
					if(j - i == 1) {
						T[i][j] = true;
					} else {
						T[i][j] = T[i+1][j-1];
					}
					if(T[i][j] && j-i > max-min) {
						min = i;
						max = j;
					}
				}
			}
		}
		//printMatrix(T);
		for(int i=min; i<=max; i++) {
			System.out.print(str[i]);
		}
		System.out.println("");
		return max-min+1;
	}
	
	/*public void printMatrix(boolean T[][]) {
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[i].length; j++) {
				System.out.print(T[i][j]+"\t");
			}
			System.out.println("");
		}
	}*/

	public static void main(String args[]) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String str = "AABABABA";
		int r = lps.calculate(str.toCharArray());
		System.out.println(r);
	}
}
