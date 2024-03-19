package com.sourav.leetcode.design;

import java.util.*;

public class RandomSet {

    Map<Integer, Integer> valueToIndexMap;
    List<Integer> values;
    Random rand;

    public RandomSet() {
        valueToIndexMap = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndexMap.containsKey(val)) {
            return false;
        }
        valueToIndexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndexMap.containsKey(val)) {
            return false;
        }
        int lastElement = values.get(values.size() - 1);
        int index = valueToIndexMap.get(val);
        values.set(index, lastElement);
        valueToIndexMap.put(lastElement, index);
        values.remove(values.size() - 1);
        valueToIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }

}
