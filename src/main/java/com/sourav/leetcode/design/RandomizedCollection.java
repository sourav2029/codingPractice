package com.sourav.leetcode.design;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class RandomizedCollection {

    List<Integer> values;
    Map<Integer, Set<Integer>> map;

    Random random = new Random();

    public RandomizedCollection() {
        values = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean ans = true;
        Set<Integer> indexSet;
        if (map.containsKey(val) && !map.get(val).isEmpty()) {
            ans = false;
            indexSet = map.get(val);
        } else {
            indexSet = new LinkedHashSet<>();
        }
        int index = values.size();
        indexSet.add(index);
        map.put(val, indexSet);
        values.add(val);
        return ans;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        Set<Integer> indexSet = map.get(val);
        int indexToRemove = indexSet.iterator().next();
        indexSet.remove(indexToRemove);
        map.put(val, indexSet);
        int lastValue = values.get(values.size() - 1);
        values.set(indexToRemove, lastValue);
        map.get(lastValue).add(indexToRemove);
        map.get(lastValue).remove(values.size() - 1);
        values.remove(values.size() - 1);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }


    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(5);
        randomizedCollection.remove(5);
        randomizedCollection.insert(5);
        System.out.println(randomizedCollection.getRandom());

    }
}


/*
[[],[5],[6],[5],[7],[6],[]]

insert 0
index = 0
ans -> true
values - > []
map ->

["RandomizedCollection","insert","insert","insert","getRandom","remove","getRandom"]
[[],[1],[1],[2],[],[1],[]]

 */
