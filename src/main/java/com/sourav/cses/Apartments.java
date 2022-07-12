package com.sourav.cses;

import java.io.*;
import java.util.*;

public class Apartments {
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

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] req = new int[n];
        int[] av = new int[m];
        for (int i = 0; i < n; i++) {
            req[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            av[i] = in.nextInt();
        }
        Arrays.sort(req);
        Arrays.sort(av);
        int ans = 0;
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (Math.abs(req[i] - av[j]) <= k) {
                i++;
                j++;
                ans++;
            } else {
                if (req[i] < av[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        out.println(ans);
        out.close();
    }
}
