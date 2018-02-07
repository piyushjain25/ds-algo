package com.interview.array;
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * https://oj.leetcode.com/problems/trapping-rain-water/
 */
public class TrappingWater {

    public int trapWater1(int input[]){
        if(input.length < 2){
            return 0;
        }
        
        int maxFoundSoFar = 0;
        int result = 0;
        for(int i = 1; i < input.length; i++){
            if(input[i] < input[maxFoundSoFar]){
                continue;
            }
            else{
                int minOfTwo = Math.min(input[maxFoundSoFar], input[i]);
                for(int j = i-1; j > maxFoundSoFar; j--){
                    if(minOfTwo > input[j]){
                        result += minOfTwo - input[j];
                    }else{
                        minOfTwo = input[j];
                    }
                }
                maxFoundSoFar = i;
            }
        }
        
        int minOfTwo = input[input.length-1];
        for(int j = input.length-2; j > maxFoundSoFar; j--){
            if(minOfTwo > input[j]){
                result += minOfTwo - input[j];
            }else{
                minOfTwo = input[j];
            }
        }
        return result;
    }
   
    /**
     * Keep two array left and right which has max till that point
     * either from left side or right side. 
     * Now for every point i check if it is less than left[i] and right[i].
     * If yes then add this to total since water can be trapped here.
     * @param input
     * @return
     */
    public int trapWater2(int input[]){
        assert input != null && input.length > 0;
        int left[] = new int[input.length];
        int right[] = new int[input.length];
        left[0] = input[0];
        for(int i=1; i < input.length; i++){
            left[i] = (input[i] > left[i-1] ? input[i] : left[i-1]);
        }
        right[input.length-1] = input[input.length-1];
        for(int i=input.length-2; i >= 0; i--){
            right[i] = (input[i] > right[i+1] ? input[i] : right[i+1]);
        }
        
        int result = 0;
        for(int i=1; i < input.length-1; i++){
            int min = Math.min(left[i], right[i]) - input[i];
            if(min > 0){
                result += min;
            }
        }
        return result;
    }
    
    /**
     * Best Approach
     * Time complexity: O(n). Single iteration of O(n).
     * Space complexity: O(1) extra space. 
     * Only constant space required for left, right, left_max and right_max .
     */
    public int trapWater3(int input[]) {
        int left = 0, right = input.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if(input[left] < input[right]) {
            	if(input[left] >= left_max)
            		left_max = input[left];
            	else 
            		ans += (left_max - input[left]);
            	
                ++left;
            }
            else {
            	if(input[right] >= right_max) 
            		right_max = input[right];
            	else 
            		ans += (right_max - input[right]);
            	
                --right;
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        int input[] = {0,1,1,1,0};
        TrappingWater tw = new TrappingWater();
        System.out.println(tw.trapWater1(input));
        System.out.println(tw.trapWater2(input));
        System.out.println(tw.trapWater3(input));
    }
}
