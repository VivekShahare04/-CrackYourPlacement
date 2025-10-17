class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }

    public static void backtrack(int[] nums,int idx,List<Integer> ls,List<List<Integer>> res){
        res.add(new ArrayList<>(ls));

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i] == nums[i-1])continue;

            ls.add(nums[i]);
            backtrack(nums,i+1,ls,res);
            ls.remove(ls.size()-1);
        }
    }
}