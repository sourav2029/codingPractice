package com.sourav.codility;

import java.util.Arrays;

public class Problem2 {
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int count = 0;
        int prev = -1;
        for(int i=0; i<A.length; i++){
            if(A[i] != prev){
                count++;
                prev = A[i];
            }
        }
        return count;
    }
}
