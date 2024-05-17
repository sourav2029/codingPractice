//package com.sourav.design;
//
//import java.util.*;
//
//public class MKAverage {
//    TreeSet<Integer> minPQ;
//    TreeSet<Integer> maxPQ;
//    Queue<Integer> q;
//    int sum = 0;
//    int minSum = 0;
//    int maxSum = 0;
//    int m, k;
//
//    public MKAverage(int m, int k) {
//        this.m = m;
//        this.k = k;
//        this.q = new LinkedList<>();
//        minPQ = new TreeSet<>();
//        maxPQ = new TreeSet<>(Collections.reverseOrder());
//    }
//
//    public void addElement(int num) {
//        if (q.size() >= m) {
//            int toRemove = q.poll();
//            if (minPQ.remove(toRemove)) {
//                minSum -= toRemove;
//            }
//            if (maxPQ.remove(toRemove)) {
//                maxSum -= toRemove;
//            }
//            sum -= toRemove;
//        }
//        q.offer(num);
//        sum += num;
//        maxPQ.add(num);
//        minSum += num;
//        if (maxPQ.size() > k + 1) {
//            minSum -= maxPQ.;
//        }
//        minPQ.add(num);
//        maxSum += num;
//        if (minPQ.size() > k) {
//            maxSum -= minPQ.poll();
//        }
//    }
//
//    public int calculateMKAverage() {
//        if (q.size() < m) {
//            return -1;
//        }
//        int rem = sum - (minSum + maxSum);
//        return rem / (m - 2 * k);
//    }
//
//
//    public static void main(String[] args) {
//        MKAverage mkAverage = new MKAverage(3, 1);
//        mkAverage.addElement(3);
//        mkAverage.addElement(1);
//        System.out.println(mkAverage.calculateMKAverage());
//        mkAverage.addElement(10);
//        System.out.println(mkAverage.calculateMKAverage());
//        mkAverage.addElement(5);
//        mkAverage.addElement(5);
//        mkAverage.addElement(5);
//        System.out.println(mkAverage.calculateMKAverage());
//    }
//}
//
///**
// * Your MKAverage object will be instantiated and called as such:
// * MKAverage obj = new MKAverage(m, k);
// * obj.addElement(num);
// * int param_2 = obj.calculateMKAverage();
// */
//
