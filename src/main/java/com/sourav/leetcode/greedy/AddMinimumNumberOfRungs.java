package com.sourav.leetcode.greedy;

import com.sourav.cses.Apartments;

import java.io.*;
import java.util.StringTokenizer;

public class AddMinimumNumberOfRungs {
    public static int addRungs(int[] rungs, int dist) {
        int added = 0;
        int currHeight = 0;
        for (int i=0; i<rungs.length;i++){
            if (rungs[i]> currHeight+ dist){
                added+= (rungs[i] - currHeight -1)/dist;
            }
            currHeight = rungs[i];
        }
        return added;
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

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        out.close();
    }
}
