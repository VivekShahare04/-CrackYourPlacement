class Solution {
    int mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][k];
        return helper(grid,0,0,0,k,dp);
    }
    public int helper(int[][] grid,int i,int j,int sum,int k,Integer[][][] dp){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return 0;

        sum = (sum+grid[i][j])%k;

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return sum==0?1:0;
        }

        if(dp[i][j][sum]!=null)return dp[i][j][sum]; 

        int down = helper(grid,i+1,j,sum,k,dp);
        int right = helper(grid,i,j+1,sum,k,dp);

        return dp[i][j][sum]= (down+right)%mod;

    }
}