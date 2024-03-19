package com.sourav.leetcode.dailyProblem;

import java.util.Arrays;

//https://leetcode.com/problems/bag-of-tokens/description/?envType=daily-question&envId=2024-03-04
public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int len = tokens.length;
        int s = 0, e = len - 1, ans = 0, score = 0;
        while (s <= e) {
            if (power >= tokens[s]) {
                power -= tokens[s];
                score++;
                s++;
                ans = Math.max(ans, score);
            } else if (score > 0) {
                power += tokens[e];
                score--;
                e--;
            } else {
                return ans;
            }
        }
        return ans;
    }
}
