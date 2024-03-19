package com.sourav.leetcode.prefixSum;

//leetcode.com/problems/find-good-days-to-rob-the-bank/

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;

        if (time == 0) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
        }
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = 1;
            }
        }
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                suffix[i] = suffix[i + 1] + 1;
            } else {
                suffix[i] = 1;
            }
        }


        for (int i = time; i < n - time; i++) {
            if (prefix[i - 1] >= time && suffix[i + 1] >= time) {
                ans.add(i);
            }
        }
        return ans;

    }
}
