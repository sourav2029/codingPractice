package com.sourav.unionfind;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean ans = false;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
        }
        int[] color = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            color[i] = 0;
        }
        ans = true;
        detectCycle(graph, color);
        return ans;

    }

    public static void detectCycle(List<Integer>[] graph, int[] color) {
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0) {
                dfs(graph, color, i);
            }
        }
    }


    public static void dfs(List<Integer>[] graph, int[] color, int v) {
        color[v] = 1;
        for (int u : graph[v]) {
            if (color[u] == 1) {
                ans = false;
                return;
            }
            if (color[u] == 0) {
                dfs(graph, color, u);
            }
        }
        color[v] = 2;
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < 3; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[2].add(1);
        graph[0].add(2);

        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = 0;
        }
        detectCycle(graph, color);
        System.out.println(ans);
    }
}
