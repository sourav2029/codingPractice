package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites){
            graph[edge[0]].add(edge[1]);
        }
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for (int i=0; i<numCourses; i++){
            if (!visited[i]){
                dfs(graph, visited, res, i);
            }
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void dfs(List<Integer>[] graph, boolean[] visited, List<Integer> res, int v){
        visited[v] = true;
        for(int u: graph[v]){
            if(!visited[u]){
                dfs(graph, visited, res, u);
            }
        }
        res.add(v);
    }

}
