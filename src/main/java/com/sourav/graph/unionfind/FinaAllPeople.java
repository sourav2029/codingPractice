package com.sourav.graph.unionfind;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-people-with-secret/
public class FinaAllPeople {
    int[] parent;
    int[] rank;

//    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        Arrays.sort(meetings, (a,b) -> (a[2] -b[2]));
//
//
//    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px == py){
            return;
        }

        if(rank[px] > rank[py]){
            parent[py] = px;
            rank[px] += rank[py];
        } else {
            parent[px] = py;
            rank[py] += rank[px];
        }
    }

    public  boolean isConnected(int x, int y){
        return  find(x) == find(y);
    }


    public int find(int x) {
        if( x == parent[x]){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }


}
