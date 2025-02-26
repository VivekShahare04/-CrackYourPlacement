class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int INF = Integer.MAX_VALUE / 2;

        int[][] dp = new int[n][4]; // 3 lanes + dummy 0th index

        // Fill DP table with INF
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Initial conditions: Start at lane 2 with 0 jumps
        dp[0][1] = 1; // Lane 1 initially takes 1 side jump
        dp[0][2] = 0; // Lane 2 starts with 0 jumps
        dp[0][3] = 1; // Lane 3 initially takes 1 side jump

        for (int i = 1; i < n; i++) {
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[i] != lane) { // If lane is not blocked
                    dp[i][lane] = dp[i - 1][lane]; // Continue forward
                }
            }

            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[i] != lane) { // If lane is not blocked
                    dp[i][lane] = Math.min(dp[i][lane], Math.min(dp[i][(lane % 3) + 1], dp[i][(lane + 1) % 3 + 1]) + 1);
                }
            }
        }

        // Minimum jumps required to reach the last position
        return Math.min(dp[n - 1][1], Math.min(dp[n - 1][2], dp[n - 1][3]));
    }
}