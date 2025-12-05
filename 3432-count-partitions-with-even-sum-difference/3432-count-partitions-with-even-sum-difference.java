class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int leftsum=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            leftsum += nums[i];
            int rightsum=0;
            for(int j=i+1;j<n;j++){
                rightsum += nums[j];
            }
            if((rightsum-leftsum)%2==0){
                count++;
            }
        }
        return count;
    }
}