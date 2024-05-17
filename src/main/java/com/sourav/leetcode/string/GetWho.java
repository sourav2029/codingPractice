package com.sourav.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class GetWho {

    public static List<String> getWho(List<String> s) {
        List<String> res = new ArrayList<>();
        for (String str : s) {
            int vowelCount = vowelCount(str);
            if (vowelCount == 0) {
                res.add("chris");
            } else {
                res.add("Alex");
            }
        }
        return res;
    }

    public static int vowelCount(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        List<String> in=  new ArrayList<>();
        in.add("ljis");
        in.add("lhr");
        in.add("gms");
        System.out.println(getWho(in));
    }
}
