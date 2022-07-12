package com.sourav.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RestaurantCustomers {
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
                } catch (IOException exception) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public Long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(a, other.a);
        }
    }

    public static void main(String args[]) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        Pair[] times = new Pair[2 * n];
        for (int i = 0; i < n; i++) {
            times[2 * i] = new Pair(in.nextInt(), 1);
            times[2 * i + 1] = new Pair(in.nextInt(), -1);
        }
        Arrays.sort(times);
        int sum = 0;
        int ans = 0;
        for (Pair pair : times) {
            sum += pair.b;
            ans = Math.max(ans, sum);
        }
        out.println(ans);
        out.close();
    }

}
