package com.sourav.graph;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-total-importance-of-roads/
public class MaximumImportance {
        public class Pair implements Comparable<Pair>{
            int node;
            int inDegree;

            public Pair(int node, int inDegree){
                this.node = node;
                this.inDegree = inDegree;
            }

            public int compareTo(Pair other){
                return Integer.compare(inDegree, other.inDegree);
            }
        }

        public long maximumImportance(int n, int[][] roads) {
            int[] inDegree = new int[n];
            for(int i=0; i<roads.length; i++){
                inDegree[roads[i][0]]++;
                inDegree[roads[i][1]]++;
            }

            Pair[]  pairs = new Pair[n];
            for(int i=0; i<n;i++){
                pairs[i] = new Pair(i, inDegree[i]);
            }
            Arrays.sort(pairs);
            int[] imp = new int[n];
            int maxImp = 1;
            for(int i=0; i<n;i++){
                imp[pairs[i].node] = maxImp;
                maxImp++;
            }
            long ans = 0;
            for(int i=0; i<roads.length;i++){
                ans += (imp[roads[i][0]] + imp[roads[i][1]]);
            }
            return ans;
        }

    public long maximumImportance2(int n, int[][] roads) {
        int[] inDegree = new int[n];
        for(int i=0; i<roads.length; i++){
            inDegree[roads[i][0]]++;
            inDegree[roads[i][1]]++;
        }
        Arrays.sort(inDegree);
        long ans = 0;
        for(int i=0; i<n;i++){
            ans += (i+1L)*inDegree[i];
        }
        return ans;
    }
}
