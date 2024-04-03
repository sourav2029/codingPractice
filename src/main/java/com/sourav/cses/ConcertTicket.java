package com.sourav.cses;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcertTicket {
    //        How to implement multiset in java
//    Just use add and remove function in place of multiset.add and multiset.remove
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


    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 262144);
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

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] req = new int[m];
        for (int i = 0; i < n; i++) {
            add(in.nextInt());
        }
        for (int i = 0; i < m; i++) {
            req[i] = in.nextInt();
        }
        Map.Entry<Integer, Integer> val;
        for (int i = 0; i < m; i++) {
            val = multiSet.lowerEntry(req[i] + 1);
            if (val != null){
                out.println(val.getKey());
                remove(val.getKey());
            } else {
                out.println(-1);
            }
        }
        out.close();
    }
}
