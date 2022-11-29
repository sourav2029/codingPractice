package com.sourav.cses;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GenerateAllSubsets {
    static List<Integer> subset = new ArrayList<>();

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 65536);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void search(int index, int[] arr) {
        if (index == arr.length) {
            print();
            return;
        }
        search(index + 1, arr);
        subset.add(arr[index]);
        search(index + 1, arr);
        subset.remove(new Integer(arr[index]));
    }

    public static void bitset(int arr[]) {
        for (int a = 0; a < (1 << arr.length); a++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if ((a & (1 << i)) > 0) {
                    subset.add(arr[i]);
                }
            }
            print(subset);
        }
    }

    public static void print() {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void print(List<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
//        search(0, arr);
        bitset(arr);
    }
}
