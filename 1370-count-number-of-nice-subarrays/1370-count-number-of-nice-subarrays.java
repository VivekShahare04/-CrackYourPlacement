class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return goalreached(nums,k) - goalreached(nums,k-1);
    }
    public int goalreached(int[] nums,int k){
        if(k<0)return 0;
        int n = nums.length;
        int left=0;
        int count=0;
        int sum=0;

        for(int right=0;right<n;right++){
            sum = sum + (nums[right]%2);
            while(sum>k){
                sum = sum - (nums[left]%2);
                left++;
            }
            count = count + (right-left+1);
        }
        return count;
    }
}