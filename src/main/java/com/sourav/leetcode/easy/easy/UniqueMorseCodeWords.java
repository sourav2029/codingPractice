package com.sourav.leetcode.easy.easy;

import javax.print.attribute.standard.MediaPrintableArea;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
    final static String[] morseCodes =
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> morseCodeSet = new HashSet<>();
        for (int j = 0; j < words.length; j++) {
            final String word = words[j];
            StringBuilder morseCodeBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                morseCodeBuilder.append(morseCodes[c - 'a']);
            }
            morseCodeSet.add(morseCodeBuilder.toString());
        }
        return morseCodeSet.size();
    }
}
