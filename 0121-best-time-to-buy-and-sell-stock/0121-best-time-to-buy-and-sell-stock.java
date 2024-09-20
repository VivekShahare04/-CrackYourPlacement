class Solution {
    public int maxProfit(int[] prices) {
        int min_val = prices[0];
        int max_prof = 0;
        for(int i=0;i<prices.length;i++){
            max_prof = Math.max(max_prof,prices[i]-min_val);
            min_val = Math.min(prices[i],min_val);
        }
        return max_prof;
    }
}