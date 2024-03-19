package com.sourav.arrayandstring;

import java.util.*;

public class FrequencyCount {
    public static class CharFrequency implements Comparable<CharFrequency> {
        char c;
        int count;

        @Override
        public int compareTo(CharFrequency other) {
            return -1 * Integer.compare(this.count, other.count);
        }

        public CharFrequency(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public String frequencySort(String s) {
        int len = s.length();
        List<CharFrequency> list = new ArrayList<>();

        int[] count = new int[256];

        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0)
                list.add(new CharFrequency(count[i], (char) ('A' + i)));
        }
        Collections.sort(list);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int freqCount = list.get(i).count;
            while (freqCount-- > 0) {
                builder.append(list.get(i).c);

            }
        }
        return builder.toString();
    }


    public static String frequencySort2(String s) {

        // Count up the occurances.
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Make a list of the keys, sorted by frequency.
        List<Character> characters = new ArrayList<>(counts.keySet());
        Collections.sort(characters, (a, b) -> -1*Integer.compare(counts.get(a) , counts.get(b)));

        // Convert the counts into a string with a sb.
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int copies = counts.get(c);
            for (int i = 0; i < copies; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(frequencySort2("SouravPrem"));
    }
}
