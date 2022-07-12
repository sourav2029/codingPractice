package com.sourav.graph;

//https://leetcode.com/problems/find-the-town-judge/
public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for(int[] edge : trust){
            inDegree[edge[1]]++;
            outDegree[edge[0]]++;
        }

        for (int i=1; i<=n; i++){
            if (inDegree[i] == n-1 && outDegree[i]==0){
                return i;
            }
        }
        return -1;
    }
}
