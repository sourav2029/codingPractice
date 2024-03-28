package com.sourav.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-all-people-with-secret/description/
public class FindAllPeople {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] graph = createWeightedGraph(meetings, n);
        int[] secretTime = new int[n];
        Arrays.fill(secretTime, Integer.MAX_VALUE);
        secretTime[0] = 0;
        secretTime[firstPerson] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0});
        pq.add(new int[]{0, firstPerson});
        while (!pq.isEmpty()){
            int[] top = pq.poll();
            int personId = top[1];
            int timeWhenPersonKnowSecret = top[0];
            for(int[] adj : graph[personId]){
                if(adj[1] >= timeWhenPersonKnowSecret && secretTime[adj[0]] > adj[1]){
                    secretTime[adj[0]] = adj[1];
                    pq.add(new int[]{adj[1], adj[0]});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secretTime[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }


    public List<int[]>[] createWeightedGraph(int[][] meetings, int n) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] meeting : meetings) {
            int p0 = meeting[0];
            int p1 = meeting[1];
            int time = meeting[2];
            graph[p0].add(new int[]{p1, time});
            graph[p1].add(new int[]{p0, time});
        }
        return graph;
    }
}
