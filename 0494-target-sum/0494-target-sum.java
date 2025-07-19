class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        //boolean[][] dp = new boolean[n+1][target+1];
        return traverse(nums,0,target,0);
    }
    public int traverse(int[] nums,int idx,int target,int sum){
        //if(target==0)return 0;
        if(idx==nums.length){
            return sum == target?1:0;
        }
        //choose + adn -
        int add = traverse(nums,idx+1,target,sum+nums[idx]);
        int sub = traverse(nums,idx+1,target,sum-nums[idx]);
        return add+sub;
    }
}