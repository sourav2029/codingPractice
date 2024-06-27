package com.sourav.leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeGame {
    Queue<int[]> q;
    int width;
    int height;
    Map<Pair, Boolean> snake;

    int[] head;
    int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        score = 0;
        q = new LinkedList<>();
        for (int[] entry : food) {
            q.offer(entry);
        }
        snake = new HashMap<>();
        snake.put(new Pair(0, 0), true);
        head = new int[]{0, 0};
    }

    public int move(String direction) {
        int[] next = nextPosition(direction);
        if (!isValid(next[0], next[1])) {
            return -1;
        }
        if (!q.isEmpty()) {
            int[] food = q.peek();
            if (food[0] == next[0] && food[1] == next[1]) {
                score++;
                snake.put(new Pair(next[0], next[1]), true);
            }
        }
        head = next;
        return score;
    }

    private int[] nextPosition(String direction) {
        int[] newPosition = new int[2];
        switch (direction.charAt(0)) {
            case 'L':
                newPosition = new int[]{head[0] - 1, head[1]};
            case 'R':
                newPosition = new int[]{head[0] + 1, head[1]};
            case 'U':
                newPosition = new int[]{head[0], head[1] + 1};
            case 'D':
                newPosition = new int[]{head[0], head[1] - 1};
        }
        return newPosition;
    }


    private boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= height || y >= width) {
            return false;
        }
        return !snake.containsKey(new Pair(x, y));
    }


    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("UI"));
    }
}
