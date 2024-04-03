package com.sourav.graph.dfs;

public class WordSearch {

    static boolean[][] visited;
    static int m, n;

    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && board[x][y] == word.charAt(index)) {
                if (dfs(board, word, x, y, index + 1)){
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
    }

}
