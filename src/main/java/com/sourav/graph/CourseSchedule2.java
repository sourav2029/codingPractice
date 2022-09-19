package com.sourav.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule2 {
    boolean ans = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites){
            graph[edge[0]].add(edge[1]);
        }
        List<Integer> res = new ArrayList<>();
        int[] color = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if (color[i] == 0){
                dfs(graph, color, res, i);
            }
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void dfs(List<Integer>[] graph, int[] color, List<Integer> res, int v){
        color[v] = 1;
        for(int u: graph[v]){
            if (color[u] == 1){
                ans = false;
                return;
            }
            if (color[u] == 0){
                dfs(graph, color, res, u);
            }
        }
        color[v] = 2;
        res.add(v);
    }

}
