package com.sourav.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (String s : version1Arr) {
            int subVersion = Integer.parseInt(s);
            list1.add(subVersion);
        }
        for (String s : version2Arr) {
            int subVersion = Integer.parseInt(s);
            list2.add(subVersion);
        }
        while (list1.get(list1.size() - 1) == 0) {
            list1.remove(list1.size() - 1);
        }
        while (list2.get(list2.size() - 1) == 0) {
            list2.remove(list2.size() - 1);
        }
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                return -1;
            } else if (list1.get(i) > list2.get(j)) {
                return 1;
            }
            i++;
            j++;
        }
        if (i == list1.size() && j == list2.size()) {
            return 0;
        }
        if (i == list1.size()) {
            return -1;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.001"));
        System.out.println(compareVersion("1.0","1.0.0"));
        System.out.println(compareVersion("0.1","1.0"));

    }

}

