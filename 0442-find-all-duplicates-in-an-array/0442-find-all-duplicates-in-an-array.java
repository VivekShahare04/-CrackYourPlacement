class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ls = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            boolean isduplicate = false;
            for(int j=0;j<i;j++){
                if(nums[i]==nums[j]){
                    isduplicate = true;
                    break;
                }
            }
            if(isduplicate){
                ls.add(nums[i]);
            }
        }
        return ls;
    }
}