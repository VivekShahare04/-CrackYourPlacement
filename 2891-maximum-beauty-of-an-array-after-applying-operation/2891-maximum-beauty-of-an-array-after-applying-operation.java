class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int max=1;
        int factor=2*k;
        int l=0;

        for(int r=0;r<n;r++){
            if(nums[r]-nums[l]<=factor){
                max = Math.max(max,r-l+1);
            }else{
                l++;
            }
        }
        return max;
    }
}