class Solution {
    // public int triangleNumber(int[] nums) {
    //     int n = nums.length;
    //     int count=0;
    //     Arrays.sort(nums);
    //     for(int i=0;i<n-2;i++){
    //         for (int j = i + 1; j < n - 1; j++) {
    //             for (int k = j + 1; k < n; k++) {
    //                 if (nums[i] + nums[j] > nums[k]) {
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }
    public int triangleNumber(int[] nums){
        int n = nums.length;
        int count=0;
        Arrays.sort(nums);
        for(int k=n-1 ;k>=2;k--){
            int i=0,j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    count += (j-i);
                    j--;
                }else{
                    i++;
                }
            }
        }
        return count;
    }
}