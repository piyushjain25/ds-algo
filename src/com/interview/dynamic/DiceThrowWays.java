package com.interview.dynamic;

/**
 * Given n dice each with f faces, numbered from 1 to f, find the number of ways to get sum k
 * Sum(n, f, k)
 * 
 * http://www.geeksforgeeks.org/dice-throw-problem/
 * This solution assumes that 1,2,1 is different from 2,1,1 which is different from 1,1 2
 * so total 3 ways are possible
 */
public class DiceThrowWays {

    public int numberOfWays(int n, int f, int k){
        
        int T[][] = new int[n+1][k+1];
        T[0][0] = 1;
        //int defaults to 0, hence no need to set default values,
        //Entire first row & first column values would be 0
    	/*for(int i=0; i < T.length; i++){
            T[0][i] = 0;
        }*/
        
        for(int i=1; i <= n; i++){
            for(int j =1; j <= i*f && j <= k ; j++){
                if(j == i){
                    T[i][j] = 1;
                    continue;
                }
                if(j < i){
                    continue;
                }
                for(int l =1; l <=f ;l++){
                    if(j >= l){
                        T[i][j] += T[i-1][j-l];
                    }
                }
            }
        }
        // Uncomment these lines to see content of table
        /*for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= k; j++)
          	System.out.print(T[i][j] + " ");
          System.out.println("");
        }*/
        
        
        return T[n][k];
    }
    
    public static void main(String args[]){
        DiceThrowWays dtw = new DiceThrowWays();
        System.out.println(dtw.numberOfWays(2, 4, 5));
    }
}   
