class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum = sum + n;
        }
        if(sum%2==1){
            return false;
        }
            int k = sum/2;
            Boolean[][] dp = new Boolean[nums.length][k+1];
            // for(boolean d[]:dp){
            //     Arrays.fill(d,0);
            // }
        
        return partition(nums,k,nums.length-1,dp);
    }
    public boolean partition(int[] nums,int target,int idx,Boolean[][] dp){
        if(target==0)return true;
        if(idx==0)return nums[0]==target;
        if(dp[idx][target] != null) return dp[idx][target];
        
        boolean nottake = partition(nums,target,idx-1,dp);
        boolean take=false;

        if(nums[idx]<=target){
            take = partition(nums,target-nums[idx],idx-1,dp);
        }
        dp[idx][target] = take || nottake;
        return dp[idx][target];
    }
}