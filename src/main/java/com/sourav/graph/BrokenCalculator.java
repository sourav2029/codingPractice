package com.sourav.graph;

//https://leetcode.com/problems/broken-calculator/
//An initial approach could be BFS but it will timeout
public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue){
            if(target % 2 == 1){
                target += 1;
            } else {
                target/= 2;
            }
            ans++;
        }
        return  ans + (startValue - target);
    }

}
