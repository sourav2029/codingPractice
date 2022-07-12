package com.sourav.cses;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MovieFestival {
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

    static class Movie implements Comparable<Movie> {
        int start;
        int end;

        public Movie(int a, int b) {
            this.start = a;
            this.end = b;
        }

        @Override
        public int compareTo(Movie other) {
            return Integer.compare(end, other.end);
        }
    }

    public static void main(String args[]) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Movie(in.nextInt(), in.nextInt());
        }
        Arrays.sort(movies);
        int ans = 1;
        int end = movies[0].end;
        for (int i = 1; i < n; i++) {
            if (movies[i].start >= end) {
                ans++;
                end = movies[i].end;
            }
        }
        out.println(ans);
        out.close();
    }
}
