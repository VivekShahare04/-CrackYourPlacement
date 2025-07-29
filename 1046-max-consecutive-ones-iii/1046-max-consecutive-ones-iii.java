class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left=0;
        int maxlen=0;
        int zeros=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0)zeros++;
            while(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;     
            }     
           
            int len = right-left+1;
            maxlen = Math.max(maxlen,len);
                
        }
        return maxlen;
    }
}