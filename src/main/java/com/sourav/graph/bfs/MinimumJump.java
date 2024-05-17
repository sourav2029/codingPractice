package com.sourav.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumJump {
    public static class State {
        int pos;
        boolean isBackward;
        int dist;

        public State(int pos, boolean isBackward, int dist) {
            this.pos = pos;
            this.isBackward = isBackward;
            this.dist = dist;
        }
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[] visited = new boolean[5000001];
        for (int pos : forbidden) {
            visited[pos] = true;
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(0, false, 0));
        visited[0] = true;
        int limit = 6000 + 2 * b;

        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.pos == x) {
                return curr.dist;
            }
            int forward = curr.pos + a;
            if (forward < limit && !visited[forward]) {
                visited[forward] = true;
                q.add(new State(forward, false, curr.dist + 1));
            }

            int backward = curr.pos - b;
            if (!curr.isBackward && backward > 0 && !visited[backward]) {
                visited[backward] = true;
                q.add(new State(backward, true, curr.dist + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumJumps(new int[]{1}, 6,5,8));
    }

}
