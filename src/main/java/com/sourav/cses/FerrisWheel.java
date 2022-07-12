package com.sourav.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FerrisWheel {
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
        int x = in.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }
        Arrays.sort(weight);
        int ans = 0;
        for (int i = 0, j = n - 1; i <= j; ) {
            if (weight[i] + weight[j] <= x) {
                ans++;
                i++;
                j--;
            } else {
                ans++;
                j--;
            }
        }
        out.println(ans);
        out.close();
    }
}
