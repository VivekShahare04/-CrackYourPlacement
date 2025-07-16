class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(0,nums,new ArrayList<>(),res);
        return res;
    }
    void bt(int index,int[] nums,List<Integer> ls,List<List<Integer>> res){
        res.add(new ArrayList<>(ls));

        for(int i=index;i<nums.length;i++){
            //choose fiorst ele
            ls.add(nums[i]);
            //find all possible subset according to it
            bt(i+1,nums,ls,res);
            //remove last unchoose one
            ls.remove(ls.size()-1);
        }
    }
}