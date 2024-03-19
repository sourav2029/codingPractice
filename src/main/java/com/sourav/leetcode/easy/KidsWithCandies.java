package com.sourav.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies =-1;
        for(int candy : candies){
            maxCandies = Math.max(candy, maxCandies);
        }
        int len = candies.length;
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies > maxCandies);
        }
        return result;
    }
}
