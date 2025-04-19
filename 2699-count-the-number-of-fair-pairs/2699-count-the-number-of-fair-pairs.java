class Solution {
    public long countFairPairs(int[] nums, int lower, int upper){
        Arrays.sort(nums);
        int n = nums.length;
        long count=0;
        for(int i=0;i<n;i++){
            int left = lowerbound(nums,i+1,n-1,lower-nums[i]);
            int right = upperbound(nums,i+1,n-1,upper-nums[i]);
            count = count + (right-left+1);
        }
        return count;
    }
    public static int lowerbound(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    public static int upperbound(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid]<=target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}