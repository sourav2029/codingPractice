package com.sourav.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumofTwoValues {
    public static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

    public static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int a, int b) {
            this.value = a;
            this.index = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(value, o.value);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int x = in.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(in.nextInt(), i+1);
        }
        Arrays.sort(pairs);
        int st = 0;
        int end = n-1;
        boolean found = false;
        while (st < end) {
            int sum = pairs[st].value + pairs[end].value;
            if (sum == x) {
                out.println(pairs[st].index + " " + pairs[end].index);
                found = true;
                break;
            } else if (sum < x){
                st++;
            } else {
                end--;
            }
        }
        if (!found) {
            out.println("IMPOSSIBLE");
        }
        out.close();
    }
}
