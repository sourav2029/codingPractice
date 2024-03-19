package com.sourav.arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStone {
    public int numJewelsInStones(String jewels, String stones) {
        int[] count = new int[256];
        for (char c : jewels.toCharArray()) {
            count[c - 'A']++;
        }
        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (count[c - 'A'] > 0) {
                ans++;
            }
        }
        return ans;
    }


    public int numJewelsInStones2(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int ans = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                ans++;
            }
        }
        return ans;
    }

    public int numJewelsInStones3(String jewels, String stones) {
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1){
                ans++;
            }
        }
        return ans;
    }
}
