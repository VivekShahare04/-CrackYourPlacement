class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum=0;
        int count=0;
        for(int num:nums){
            sum = sum + num;
        }
        long leftsum = 0;
        for(int i=0;i<n-1;i++){
            leftsum = leftsum + nums[i];
            long rightsum = sum-leftsum;
            if(leftsum>=rightsum){
                count++;
            }
        }
        return count;
    }
}