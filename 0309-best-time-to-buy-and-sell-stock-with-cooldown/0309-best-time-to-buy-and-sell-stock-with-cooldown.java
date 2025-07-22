class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(0,0,prices,n,dp);
    }
     public int f(int ind,int buy,int[] prices,int n,int[][] dp){
        //if(cap==0)return 0;
        if(ind>=n)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];

        int profit=0;

        if(buy==0){
            profit = Math.max(-prices[ind]+f(ind+1,1,prices,n,dp),0+f(ind+1,0,prices,n,dp));
        }else{
            profit = Math.max(prices[ind]+f(ind+2,0,prices,n,dp),0+f(ind+1,1,prices,n,dp));
        }
       
        return dp[ind][buy] = profit;
    }
}