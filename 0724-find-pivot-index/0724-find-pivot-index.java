class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftsum =0;
        int total=0;

        for(int num:nums){
            total = total + num;
        }

        for(int i=0;i<nums.length;i++){
            if(leftsum==total-leftsum-nums[i]){
                return i;
            }
            leftsum = leftsum + nums[i];
        }
        return -1;
    }
}