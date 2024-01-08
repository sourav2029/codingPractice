package com.sourav.arrayandstring;

//https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/description/
/*145
[[114,5],[115,7],[50,9],[105,11],[18,13],[47,16],[48,18],[39,19]]
*/
public class HardestWorker {

    public int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1];
        int entries = logs.length;
        int ans = logs[0][0];
        for(int i=1; i<entries; i++){
            int currTime = logs[i][1] - logs[i-1][1];
            if(currTime <maxTime ){
                maxTime  = currTime;
                ans = i;
            }
        }
        return ans;
    }
}
