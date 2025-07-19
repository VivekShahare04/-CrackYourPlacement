class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum = sum + n;
        }
        if(sum%2!=0){
            return false;
        }
        int k = sum/2;
        Boolean[][] dp = new Boolean[nums.length+1][k+1];
        return partition(nums,k,nums.length-1,dp);
    }
    public boolean partition(int[] nums,int k,int idx,Boolean[][] dp){
        if(k==0)return true;
        if(idx==0)return nums[0] == k;
        if(dp[idx][k] != null)return dp[idx][k];

        boolean notaken = partition(nums,k,idx-1,dp);
        boolean take = false;  

        if(nums[idx]<=k){
            take = partition(nums,k-nums[idx],idx-1,dp);
        }
        dp[idx][k] = notaken||take;
        return dp[idx][k];
    }
}