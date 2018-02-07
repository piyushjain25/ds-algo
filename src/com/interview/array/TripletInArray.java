package com.interview.array;

import java.util.Arrays;

/**
 * Given an array and a value, find if there is a triplet in array whose sum is equal 
 * to the given value. If there is such a triplet present in array, 
 * then print the triplet and return true. Else return false. 
 * For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, 
 * then there is a triplet (12, 3 and 9) present in array whose sum is 24.
 * 
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class TripletInArray {

    class Triplet {
        int a;
        int b;
        int c;

        public String toString() {
            return a + " " + b + " " + c;
        }
    }

    public Triplet findTriplet(int input[], int sum) {
        Arrays.sort(input);
        for (int i = 0; i < input.length - 2; i++) {

            int start = i + 1;
            int end = input.length - 1;
            int new_sum = sum - input[i];
            while (start < end) {
                if (new_sum == input[start] + input[end]) {
                    Triplet t = new Triplet();
                    t.a = input[i];
                    t.b = input[start];
                    t.c = input[end];
                    return t;
                }
                if (new_sum > input[start] + input[end]) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return null;
    }

    public static void main(String args[]){
        TripletInArray tip = new TripletInArray();
        int input[] = {1,2,6,9,11,18,26,28};
        int sum = 22;
        System.out.println(tip.findTriplet(input, sum));
    }
}
