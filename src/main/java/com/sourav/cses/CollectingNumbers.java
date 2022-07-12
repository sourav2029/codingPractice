package com.sourav.cses;

import java.io.*;
import java.util.StringTokenizer;

public class CollectingNumbers {
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
        int[] pos = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int temp = in.nextInt();
            pos[temp] = i;
        }
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (pos[i] < pos[i - 1])
                ans++;
        }
        out.println(ans);
        out.close();


    }

}
