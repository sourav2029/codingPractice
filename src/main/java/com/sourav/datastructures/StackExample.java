package com.sourav.datastructures;

import java.util.Random;
import java.util.Stack;

// push , pop, peek, isEmpty are all o(1) operations.
public class StackExample {

    public static void main(String[] args) {
        Random random = new Random();
        Stack<Integer> stack = new Stack<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            int curr = random.nextInt(100);
            System.out.println("Pushing int:" + curr);
            stack.push(curr);
        }

        while (!stack.isEmpty()) {
            System.out.println("Stack Top Element :" + stack.peek());
            stack.pop();
        }
    }

    public static void stringOperations(){
        Stack<String> stack = new Stack<>();

    }
}
