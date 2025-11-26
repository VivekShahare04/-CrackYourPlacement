class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left=0;
        int zeros=0;
        int maxlen=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros>0){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}