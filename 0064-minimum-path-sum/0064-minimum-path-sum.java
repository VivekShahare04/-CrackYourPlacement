class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return moves(grid,m-1,n-1,dp);
    }

    public int moves(int[][] grid,int i,int j,int[][] dp){
        if(i==0 && j==0)return grid[0][0];
        if(i<0 || j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];

        int top = moves(grid,i-1,j,dp);
        int left = moves(grid,i,j-1,dp);

        dp[i][j] = grid[i][j]+Math.min(top,left);
        return dp[i][j];
    }
}