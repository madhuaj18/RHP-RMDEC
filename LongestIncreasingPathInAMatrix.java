class Solution {
    final int diff[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int dfs(int matrix[][], int dp[][], int row, int col, int R, int C) {

        if(dp[row][col] != 0){
            return dp[row][col];
        }

        int adjmax = 0;

        for (int i = 0; i < 4; i++) {
            int ar = row + diff[i][0], ac = col + diff[i][1];

            if (ar >= 0 && ar < R && ac >= 0 && ac < C && matrix[row][col] < matrix[ar][ac]) {
                adjmax = Math.max(adjmax, dfs(matrix, dp, ar, ac, R, C));
            }
        }

        dp[row][col] = 1 + adjmax;
        return dp[row][col];
    }

    public int longestIncreasingPath(int[][] matrix) {

        int R = matrix.length, C = matrix[0].length;
        int dp[][] = new int[R][C];
        int maxlen = 1;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (dp[row][col] == 0) {
                    maxlen = Math.max(maxlen, dfs(matrix, dp, row, col, R, C));
                }
            }
        }
        return maxlen;
    }
}