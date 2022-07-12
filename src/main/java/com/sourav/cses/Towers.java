package com.sourav.cses;

import java.io.*;
import java.util.*;

public class Towers {

    static TreeMap<Integer, Integer> multiSet = new TreeMap<>();

    static void add(int x) {
        if (multiSet.containsKey(x)) {
            multiSet.put(x, multiSet.get(x) + 1);
        } else {
            multiSet.put(x, 1);
        }
    }

    static void remove(int x) {
        multiSet.put(x, multiSet.get(x) - 1);
        if (multiSet.get(x) == 0) {
            multiSet.remove(x);
        }
    }

    static int size() {
        int size = 0;
        for (int key : multiSet.keySet()) {
            size += multiSet.get(key);
        }
        return size;
    }

    public static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
            } catch (IOException exception) {
                throw new RuntimeException();
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int cube = in.nextInt();
            Integer index = multiSet.higherKey(cube);
            if (index != null) {
                remove(index);
            }
            add(cube);
        }
        out.println(size());
        out.close();
    }
}
