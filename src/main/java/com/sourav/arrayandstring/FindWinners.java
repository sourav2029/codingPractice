package com.sourav.arrayandstring;

import java.util.*;

public class FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winnerCount = new HashMap<>();
        Map<Integer, Integer> loserCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (winnerCount.containsKey(winner)) {
                winnerCount.put(winner, winnerCount.get(winner) + 1);
            } else {
                winnerCount.put(winner, 1);
            }
            if (loserCount.containsKey(loser)) {
                loserCount.put(loser, loserCount.get(loser) + 1);
            } else {
                loserCount.put(loser, 1);
            }
        }
        List<Integer> onlyWinners = new ArrayList<>();
        List<Integer> singleMatchLoser = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : winnerCount.entrySet()) {
            if (!loserCount.containsKey(entry.getKey())) {
                onlyWinners.add(entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> entry : loserCount.entrySet()) {
            if (entry.getValue() == 1) {
                singleMatchLoser.add(entry.getKey());
            }
        }
        Collections.sort(onlyWinners);
        Collections.sort(singleMatchLoser);
        List<List<Integer>> res = new ArrayList<>();
        res.add(onlyWinners);
        res.add(singleMatchLoser);
        return res;
    }

    public List<List<Integer>> findWinners2(int[][] matches) {
        int max = 100005;
        int[] lossCount = new int[max];
        Arrays.fill(lossCount, -1);

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (lossCount[winner] == -1) {
                lossCount[winner] = 0;
            }
            if (lossCount[loser] == -1) {
                lossCount[loser] = 1;
            } else {
                lossCount[loser]++;
            }
        }
        List<Integer> onlyWinners = new ArrayList<>();
        List<Integer> singleMatchLoser = new ArrayList<>();

        for (int i=0; i<max; i++) {
            if(lossCount[i] == 0){
                onlyWinners.add(i);
            }
            if(lossCount[i] == 1){
                singleMatchLoser.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(onlyWinners);
        res.add(singleMatchLoser);
        return res;
    }
}
