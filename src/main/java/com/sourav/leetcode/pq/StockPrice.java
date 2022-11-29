package com.sourav.leetcode.pq;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPrice {
    public class Pair implements Comparable<Pair> {
        int price;
        int timestamp;

        public Pair(int price, int t){
            this.price = price;
            this.timestamp = t;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.price, o.price);
        }
    }

    PriorityQueue<Pair> minPQ;
    PriorityQueue<Pair> maxPQ;
    Map<Integer, Integer> map;
    int latestTimeStamp;

    public StockPrice() {
        map = new HashMap<>();
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        latestTimeStamp = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int previousPrice = map.get(timestamp);

        }
        if (timestamp > latestTimeStamp) {
            latestTimeStamp = timestamp;
        }
        Pair pair = new Pair(price, timestamp);
        minPQ.add(pair);
        maxPQ.add(pair);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(latestTimeStamp);
    }

    public int maximum() {
        Pair max = maxPQ.peek();
        while(max.price != map.get(max.timestamp)){
            maxPQ.poll();
            max = maxPQ.peek();
        }
        return max.price;
    }

    public int minimum() {
        Pair min =  minPQ.peek();
        while(min.price != map.get(min.timestamp)){
            minPQ.poll();
            min = minPQ.peek();
        }
        return min.price;
    }



    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(38, 2308);
        stockPrice.update(47, 7876);
        stockPrice.update(58, 1886);
        stockPrice.update(43, 121);
        stockPrice.update(40, 5339);
        stockPrice.update(32, 5339);
        stockPrice.update(43, 6414);
        stockPrice.update(49, 9369);
        System.out.println(stockPrice.minimum());
        System.out.println(stockPrice.minimum());
    }
}