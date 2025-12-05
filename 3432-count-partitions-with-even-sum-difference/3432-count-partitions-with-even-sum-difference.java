class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total=0;
        for(int num:nums){
            total += num;
        }
        int left=0;
        int count=0;

        for(int i=0;i<n-1;i++){
            left += nums[i];
            int right = total - left;

            if((left-right)%2==0){
                count++;
            }
        }
        return count;
    }
}