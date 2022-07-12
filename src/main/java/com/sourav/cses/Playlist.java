package com.sourav.cses;

import java.io.*;
import java.util.*;

public class Playlist {
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
        int[] ids = new int[n];
        Map<Integer, Integer> uniq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ids[i] = in.nextInt();
        }
        int st = 0, end = 1;
        uniq.put(ids[st], st);
        int ans = 1;
        while (end < n) {
            if (uniq.containsKey(ids[end])) {
                int newStart = uniq.get(ids[end]) + 1;
                for (int i = st; i < newStart; i++) {
                    uniq.remove(ids[i]);
                }
                st = newStart;
                uniq.remove(ids[end]);
            } else {
                ans = Math.max(ans, end - st + 1);
            }
            uniq.put(ids[end], end);
            end++;
        }
        out.println(ans);
        out.close();
    }
}
