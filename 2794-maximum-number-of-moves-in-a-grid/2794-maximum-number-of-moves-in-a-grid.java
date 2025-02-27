class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int steps=0;
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<m;i++){
            steps = Math.max(steps,moves(grid,i,0,dp));
        }
        return steps;

    }
    public int moves(int[][] grid,int row,int col,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        int maxmoves=0;

        if(col==n-1)return 0;

        if(dp[row][col]!=-1)return dp[row][col];
        int[][] dir = {{-1,1},{0,1},{1,1}};

        for(int[] d:dir){
            int nrow = row + d[0];
            int ncol = col + d[1];

            if(nrow>=0 && nrow<m && grid[nrow][ncol]>grid[row][col]){
                maxmoves = Math.max(maxmoves,1+moves(grid,nrow,ncol,dp));
            }
        }
        return dp[row][col]=maxmoves;
        
    }
}