package com.sourav.arrayandstring;

import java.util.Arrays;

public class RankTeam {
    public static String rankTeams(String[] votes) {
        int n = votes.length;
        int m = votes[0].length();
        int[][] freq = new int[26][m + 1];
        for (int i = 0; i < 26; i++) {
            freq[i][m] = i;
        }

        for (String vote : votes) {
            for (int j = 0; j < m; j++) {
                freq[vote.charAt(j) - 'A'][j]++;
            }
        }

        Arrays.sort(freq, (a, b) -> {
            for (int i = 0; i < m; i++) {
                if (a[i] < b[i])
                    return 1;
                if (a[i] > b[i])
                    return -1;
            }
            return 0;
        });

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m; i++) {
            res.append((char) ('A' + freq[i][m]));
        }
        return res.toString();
    }


    public static void main(String[] args) {
//        System.out.println(rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        System.out.println(rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB"}));

    }
}
