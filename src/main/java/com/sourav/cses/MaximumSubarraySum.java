package com.sourav.cses;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumSubarraySum {
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

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n= in.nextInt();
        long sum =0;
        long ans = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            int temp = in.nextInt();
            sum = Math.max(sum+temp, temp);
            ans = Math.max(ans, sum);
        }
        out.println(ans);
        out.close();
    }

}
