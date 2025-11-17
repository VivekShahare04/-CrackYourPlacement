class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int l=0;
        while(l<n && nums[l]!=1){
            l++;
        }
        
        if(l==n)return true;

        for(int r=l+1;r<n;r++){
            if(nums[r]==1){
                if(r-l-1<k){
                    return false;
                }
                l=r;
            }
        }
        return true;
    }
}