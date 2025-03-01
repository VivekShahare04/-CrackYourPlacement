class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n:nums){
            sum = sum + n;
        }
        if(sum-target<0){
            return 0;
        }
        if((sum-target)%2==1){
            return 0;
        }
        int k = (sum-target)/2;
        int[][] dp = new int[nums.length][k+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return express(nums,nums.length-1,k,dp);
    }
    public int express(int[] nums,int idx,int target,int[][] dp){
        if(idx==0){
            if(target==0 && nums[0]==0){
                return 2;
            }
            if(target==0 || target==nums[0]){
                return 1;
            }
            return 0;
        }
        if(dp[idx][target]!=-1)return dp[idx][target];
        int notake = express(nums,idx-1,target,dp);
        int take=0;
        if(nums[idx]<=target){
            take =  express(nums,idx-1,target-nums[idx],dp);
        }
        dp[idx][target] = notake+take;
        return dp[idx][target];
    }
}