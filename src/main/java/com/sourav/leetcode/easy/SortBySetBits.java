package com.sourav.leetcode.easy;

import java.util.Arrays;

public class SortBySetBits {

    public class Pair implements Comparable<Pair> {
        int val;
        int countOfOnes;

        public Pair(int val, int c) {
            this.val = val;
            this.countOfOnes = c;
        }

        public int compareTo(Pair other) {
            int comp = Integer.compare(countOfOnes, other.countOfOnes);
            if (comp == 0) {
                Integer.compare(val, other.val);
            }
            return comp;
        }
    }

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            int setBits = finsSetBits(arr[i]);
            pairs[i] = new Pair(arr[i], setBits);
        }
        Arrays.sort(pairs);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pairs[i].val;
        }
        return res;

    }

    public int finsSetBits(int num) {
        int ans = 0;
        while (num > 0) {
            ans += (num % 2);
            num /= 2;
        }
        return ans;
    }
}
