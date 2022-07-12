package com.sourav.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedComponents {
    boolean[] visited; //stores whether the node has been visited or not
    int[] index; // stores the component a node belongs to
    int components;

    public boolean equationsPossible(String[] equations) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String equation : equations) {
            char l = equation.charAt(0);
            char r = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                if (!graph.containsKey(l)) {
                    graph.put(l, new ArrayList<>());
                }

                if (!graph.containsKey(r)) {
                    graph.put(r, new ArrayList<>());
                }
                graph.get(l).add(r);
                graph.get(r).add(l);
            } else {
                if (l == r) {
                    return false;
                }
            }
        }

        visited = new boolean[26];
        index = new int[26];
        components = 1;
        for (char c : graph.keySet()) {
            int i = c - 'a';
            if (!visited[i]) {
                dfs(graph, c);
                components++;
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                continue;
            }

            int l = equation.charAt(0) - 'a';
            int r = equation.charAt(3) - 'a';
            if (index[l] != 0 && index[l] == index[r]) {
                return false;
            }
        }
        return true;
    }


    public void dfs(Map<Character, List<Character>> graph, char v) {
        int i = v - 'a';
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        index[i] = components;
        for (char u : graph.get(v)) {
            dfs(graph, u);
        }
    }
}
