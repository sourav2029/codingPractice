package com.sourav.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }
                flag = false;
                break;
            }
            if (flag) {
                stack.push(asteroid);
            }
        }
        int len = stack.size();
        int[] res = new int[len];
        while (!stack.isEmpty()) {
            res[len - 1] = stack.pop();
            len--;
        }
        return res;
    }

    public static boolean hasSameSign(int a, int b) {
        if (a < 0 && b < 0) {
            return true;
        }
        return a > 0 && b > 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-8, 8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
    }

}
