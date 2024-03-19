package com.sourav.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String all = "123456789";
        int len = all.length();
        List<Integer> ans = new ArrayList<>();
        int lowLen = Integer.toString(low).length();
        int highLen = Integer.toString(high).length();

        for(int length = lowLen; length<= highLen; length++){
            for (int start = 0; start <= len-length; start++){
                int num = Integer.parseInt(all.substring(start, start+length));
                if(num>= low & num<= high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}
