package com.interview.bits;

/**
 * A numerical code used in computing in which consecutive integers are represented by binary numbers differing in only one digit.
 * @author piyush
 */
public class GrayCode {
	
	public static int[] grayCodeFor(int n) {
		if(n <= 0) {
			return new int[]{0};
		}
		
		int[] result = new int[(int)Math.pow(2, n)];
		
		for(int i = 0; i < n; i++) {
			for(int top = 0, bottom = (int) (Math.pow(2, i+1) - 1); top < bottom; top++, bottom-- ) {
				result[top] = result[top] << 1;
				result[bottom] = result[top] | 1;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] result = grayCodeFor(3);
		for(int i = 0; i < result.length; i++) {
			System.out.println(Integer.toBinaryString(result[i]));
		}
	}

}
/*
Approach 1:
Idea here is - When we add a bit we add the existing bit format reversed.
Like for single bit, 0 -> 1. moving to 2 bits, we reverse and add i.e. 0 1 1 0 for the 2 power 1 column 
and add 0's to the existing value and add 1's to the new reversed additions i.e. 0 0 1 1 for the 2 power 0 column.
0	00	000
1  	10	100
	11	110
	01	010
		011
		111
		101
		001
		
Approach 2:
Or simple, we can just go for gray code conversion of every number which is done as follows:
first digit remains same, second digit is XOR of first and second, third digit is XOR of second and third and so on.
Number	binary	graycode
0		000		000		
1		001		001
2		010		011
3		011		010
4		100		110
5		101		111
6		110		101
7		111		100

For reverse i.e. gray code to binary, first digit remains same, second digit is result for first digit XOR with second, 
third digit is XOR of result of second digit and third digit and so on. 
*/	