package com.sourav.leetcode.easy.easy;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i=0; i< image.length; i++){
            flipHorizontally(image[i]);
        }
        return image;
    }

    public void flipHorizontally(int[] row){
        int len = row.length;
        for (int i=0; i<len/2; i++){
            int indexToSwap = len - 1-i;
            int temp = row[i];
            row[i] = row[indexToSwap];
            row[indexToSwap] = temp;
        }
        for (int i=0;i<len;i++){
            row[i] = 1^row[i];
        }
    }

}
