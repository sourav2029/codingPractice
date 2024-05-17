package com.sourav.binarySearch;

//https://www.spoj.com/problems/EKO/
public class EKO {
    public static int minHeight(int[] trees, int m) {
        int maxHeight = Integer.MIN_VALUE;
        for (int tree : trees) {
            maxHeight = Math.max(maxHeight, tree);
        }
        int min = 0, max = maxHeight;
        int ans = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int collectedWood = findCollectedWood(trees, mid);
            if (collectedWood >= m) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    public static int findCollectedWood(int[] trees, int h) {
        int res = 0;
        for (int tree : trees) {
            res += Math.max(0, tree - h);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minHeight(new int[]{20, 15, 10, 17}, 7));
        System.out.println(minHeight(new int[]{20, 15, 10, 17}, 9));
        System.out.println(minHeight(new int[]{20, 15, 10, 17}, 15));
        System.out.println(minHeight(new int[]{20, 15, 10, 17}, 1));
        System.out.println(minHeight(new int[]{20, 15, 10, 17}, 35));
    }
}
