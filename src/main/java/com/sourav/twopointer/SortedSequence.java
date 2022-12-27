package com.sourav.twopointer;

public class SortedSequence {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int p1 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                p1 = i;
            }
            nums[i] = (nums[i] * nums[i]);
        }
        if (p1 == -1) {
            return nums;
        }
        int p2 = p1 + 1;

        int[] res = new int[n];
        int i = 0;
        while (p1 >= 0 && p2 <= n - 1) {
            if (nums[p1] > nums[p2]) {
                res[i++] = nums[p2++];
            } else if (nums[p1] < nums[p2]) {
                res[i++] = nums[p1--];
            } else {
                res[i++] = nums[p1--];
                res[i++] = nums[p2++];
            }
        }
        while (p1 >= 0) {
            res[i++] = nums[p1--];
        }
        while (p2 <= n - 1) {
            res[i++] = nums[p2++];
        }
        return res;
    }
}
