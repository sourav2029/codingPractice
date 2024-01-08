package com.sourav.arrayandstring;

public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int s = 0; s < n - 2; s++) {
            int d = nums[s + 1] - nums[s];
            for (int e = s + 2; e < n; e++) {
                int i = 0;
                for (i = s + 1; i <= e; i++) {
                    if (nums[i] - nums[i - 1] != d) {
                        break;
                    }
                }
                if (i > e) {
                    int[] res = new int[e - s + 1];
                    for (int j = s; j <= e; j++) {
                        res[j - s] = nums[j];
                        System.out.print(nums[j]);
                    }
                    System.out.println();
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int s = 0; s < n - 2; s++) {
            int d = nums[s + 1] - nums[s];
            for (int e = s + 2; e < n; e++) {
                if (nums[e] - nums[e - 1] == d) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;
        for (int s = 2; s < n; s++) {
            if (nums[s] - nums[s - 1] == nums[s - 1] - nums[s - 2]) {
                dp[s] = dp[s - 1] + 1;
                count += dp[s];
            }
        }
        return count;
    }


    public int numberOfArithmeticSlices4(int[] nums) {
        int n = nums.length;
        int dp = 0;
        int count = 0;
        for (int s = 2; s < n; s++) {
            if (nums[s] - nums[s - 1] == nums[s - 1] - nums[s - 2]) {
                dp += 1;
                count += dp;
            } else {
                dp =0;
            }
        }
        return count;
    }
}
