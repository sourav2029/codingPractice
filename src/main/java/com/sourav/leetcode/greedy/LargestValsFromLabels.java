package com.sourav.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestValsFromLabels {

    public class Pair implements Comparable<Pair> {
        int label;
        int value;

        public Pair(int l, int v) {
            this.label = l;
            this.value = v;
        }

        public int compareTo(Pair other) {
            return -1 * Integer.compare(value, other.value);
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Pair[] items = new Pair[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Pair(labels[i], values[i]);
        }
        Arrays.sort(items);
        Map<Integer,Integer> count = new HashMap<>();
        int ans = 0;
        for(int i=0;numWanted > 0 && i < n; i++) {
            int label = items[i].label;
            int val = items[i].value;

            if (count.containsKey(label)){
                int currCount  = count.get(label);
                if (currCount > useLimit){
                    continue;
                } else {
                    count.put(label, currCount+1);
                }
            } else{
                count.put(label, 1);
            }
            ans+= val;
            numWanted--;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
