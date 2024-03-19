package com.sourav.leetcode.easy.easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if(flowerbed[i] == 0){
                boolean isLeftPlotEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean isRightPlotEmpty = (i == len - 1) || (flowerbed[i + 1] == 0);

                if (isLeftPlotEmpty && isRightPlotEmpty) {
                    count++;
                    flowerbed[i] = 1;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
