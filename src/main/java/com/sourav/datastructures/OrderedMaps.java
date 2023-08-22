package com.sourav.datastructures;

import java.util.Map;
import java.util.TreeMap;


public class OrderedMaps {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(3, 5);
        map.put(11, 4);
        map.put(10, 491);
        map.put(-1, 1234);
        printMap(map);
        // All the operations are log(n)
        System.out.println(map.firstKey());
        System.out.println(map.firstEntry());
        System.out.println(map.lastKey());
        System.out.println(map.lastEntry());
        System.out.println();
    }

    public static void printMap(Map<Integer, Integer> map) {
        //Traversal will be in sorted order
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
