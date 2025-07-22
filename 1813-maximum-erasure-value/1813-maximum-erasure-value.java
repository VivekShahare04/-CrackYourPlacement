class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int currsum=0;
        int maxsum = Integer.MIN_VALUE;
        int left=0;

        for(int right=0;right<n;right++){
            while(set.contains(nums[right])){
                currsum = currsum - nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            currsum = currsum + nums[right];
            maxsum = Math.max(maxsum,currsum);
        }
        return maxsum;
    }
}