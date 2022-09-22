package com.sourav.graph.dfs;

import java.util.List;

public class KeyAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        List<Integer> keys = rooms.get(room);
        for (int key : keys) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
