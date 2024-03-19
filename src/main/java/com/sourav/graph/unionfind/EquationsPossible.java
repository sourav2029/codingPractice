package com.sourav.graph.unionfind;

import java.util.ArrayList;
import java.util.List;

public class EquationsPossible {
    int[] parent, rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for (int i=0; i<26; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for (String str: equations){
            char[] arr = str.toCharArray();
            if (arr[1] == '='){
                union((int)arr[0]-'a', (int)arr[3]-'a');
            }
        }
        for (String str: equations){
            char[] arr = str.toCharArray();
            if (arr[1] == '!'){
                int first = find((int)arr[0]-'a');
                int second = find((int)arr[3]-'a');
                if (first == second){
                    return false;
                }
            }
        }
        return true;
    }


    public int find(int u){
        if (u == parent[u]){
            return u;
        }

        parent[u] = find(parent[u]);
        return parent[u];
    }

    public void union(int u, int v){
        u = find(u);
        v= find(v);

        if (u==v){
            return;
        }

        if(rank[u]>= rank[v]){
            parent[v] = u;
            rank[u]+= rank[v];
        } else {
            parent[u] = v;
            rank[v]+=rank[u];
        }
    }
}
