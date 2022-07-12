package com.sourav.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MissingCoinSum {
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
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] elems = new int[n];
        for (int i = 0; i < n; i++) {
            elems[i] = in.nextInt();
        }
        Arrays.sort(elems);
        long ans = 1;
        for(int i=0; i<n;i++){
            if (elems[i]> ans){
                break;
            }
            ans += elems[i];
        }
        out.println(ans);
        out.close();
    }
}
