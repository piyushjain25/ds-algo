package com.interview.array;

/**
 * http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
 * Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
 * Examples:
 * a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
 * b) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
 * 
 * Below solution would only work for positive numbers since we use the array to mark the seen 
 * number and store the negative value.
 * 
 * For the solution to work for both positive/negative numbers:
 * If given array elements are consecutive that means they are in AP. 
 * So, find min element i.e. first term of AP then calculate ap_sum = n/2 * [2a +(n-1)*d] where d = 1. 
 * So, ap_sum = n/2 * [2a +(n-1)]
 * Compare both sums.
 */
public class CheckIfArrayElementsAreConsecutive {

    public boolean areConsecutive(int input[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i < input.length; i++){
            if(input[i] < min){
                min = input[i];
            }
        }
        for(int i=0; i < input.length; i++){
            if(Math.abs(input[i]) - min >= input.length){
                return false;
            }
            if(input[Math.abs(input[i]) - min] < 0){
                return false;
            }
            input[Math.abs(input[i]) - min] = -input[Math.abs(input[i]) - min];
        }
        for(int i=0; i < input.length ; i++){
            input[i] = Math.abs(input[i]);
        }
        return true;
    }
    
    public static void main(String args[]){
        int input[] = {76,78,76,77,73,74};
        CheckIfArrayElementsAreConsecutive cia = new CheckIfArrayElementsAreConsecutive();
        System.out.println(cia.areConsecutive(input));
    }
}
