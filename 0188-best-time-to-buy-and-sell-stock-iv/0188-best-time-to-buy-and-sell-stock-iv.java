class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer dp[][][] = new Integer[n][2][k+1];
        return f(0,1,k,prices,n,dp);
    }
     public int f(int ind,int buy,int cap,int[] prices,int n,Integer[][][] dp){
        if(cap==0)return 0;
        if(ind==n)return 0;
        if(dp[ind][buy][cap]!=null)return dp[ind][buy][cap];

        int profit=0;

        if(buy==1){
            profit = Math.max(-prices[ind]+f(ind+1,0,cap,prices,n,dp),0+f(ind+1,1,cap,prices,n,dp));
        }else{
            profit = Math.max(prices[ind]+f(ind+1,1,cap-1,prices,n,dp),0+f(ind+1,0,cap,prices,n,dp));
        }
       
        return dp[ind][buy][cap] = profit;
    }
}