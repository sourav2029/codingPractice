package com.sourav.leetcode.greedy;

import java.util.TreeSet;

public class NumRscueBoat {
    public int numRescueBoats(int[] people, int limit) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int temp : people) {
            set.add(temp);
        }
        int ans = 0;
        while (!set.isEmpty()) {
            int maxWeigt = set.last();
            int allowedWeight = limit - maxWeigt;
            Integer exist= set.floor(allowedWeight);
            if (exist != null){
                set.remove(maxWeigt);
                set.remove(exist);
            }
            ans++;
        }
        return ans;
    }
}
