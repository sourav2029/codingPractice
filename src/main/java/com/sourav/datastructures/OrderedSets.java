package com.sourav.datastructures;

import java.util.Set;
import java.util.TreeSet;

//add, remove, contains, last, first, lower, higher are all log(n) operations
public class OrderedSets {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(14);
        set.add(9);
        set.add(2);
        // 1 2 9 14
        printSet(set);
        System.out.println(set.contains(1));
        System.out.println(set.first()); //1
        System.out.println(set.last()); //14
        System.out.println(set.higher(7)); // 9
        System.out.println(set.lower(7)); //2
    }

    public static void printSet(Set<Integer> set) {
        for (int el : set) {
            System.out.print(el + " ");
        }
    }
}
