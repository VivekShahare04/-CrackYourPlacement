class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int longest=0;

        for(int n:set){
            if(!set.contains(n-1)){
                int curr=n;
                int streak=0;

                while(set.contains(curr)){
                    curr++;
                    streak++;
                }
                longest = Math.max(longest,streak);
            }
            
        }
        return longest;
    }
}