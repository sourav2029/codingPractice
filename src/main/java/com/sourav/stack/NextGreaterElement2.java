package com.sourav.stack;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[2 * len];
        for (int i = 0; i < len; i++) {
            newNums[len + i] = nums[i];
        }
        int[] res = new int[len];
        for (int i=0; i<len ; i++){
            res[i] = -1;
        }
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(0, nums[0]));
        for(int i=1; i<2*len; i++){
            while(!stack.isEmpty() && stack.peek().value < nums[i]){
                Pair p = stack.pop();
                if (p.index < len){
                    res[p.index] = nums[i];
                }
            }
            stack.push(new Pair(i, nums[i]));
        }
        return res;
    }

    public class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
