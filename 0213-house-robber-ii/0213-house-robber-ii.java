class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];
        
        return Math.max(maxrob(nums,1,n-1),maxrob(nums,0,n-2));
    }
    public int maxrob(int[] nums,int start,int end){
        int prev2=0;
        int prev1=0;
        int n = nums.length;

        for(int i=start;i<=end;i++){
            int max = Math.max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1=max;
        }
        return prev1;
    }
}