package com.sourav.arrayandstring;

import java.util.*;

public class LeastNumberOfUniqueIntegers {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            if (!count.containsKey(num)) {
                count.put(num, 0);
            }
            count.put(num, count.get(num) + 1);
        }
        List<Integer> num = new ArrayList<>(count.values());
        Collections.sort(num);
        int res = 0;
        int i = 0, n = num.size();
        while (i < n && k > 0) {
            k -= num.get(i);
            i++;
        }
        if (k < 0) {
            res += 1;
        }
        return res + n - i;
    }


    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
    }


// 1 1 2 3 3 3 4
// 3 2 1 1

// 1 2
}
