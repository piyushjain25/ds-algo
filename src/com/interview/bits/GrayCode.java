package com.interview.bits;

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
