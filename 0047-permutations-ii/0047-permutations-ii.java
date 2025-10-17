class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//duplicates ki condition jab aayi tab sort krna
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,new ArrayList<>(),res);
        return res;
    }
    public static void backtrack(int[] nums,boolean[] used,List<Integer> ls,List<List<Integer>> res){
        if(ls.size()==nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue; //already used hai toh
            if(i>0 && nums[i]==nums[i-1]&& !used[i-1])continue; // main condition duplicates ko skip krne k liye 
            //agr duplicates chalte toh hata do
            
            used[i] = true;
            ls.add(nums[i]);
            backtrack(nums,used,ls,res);
            ls.remove(ls.size()-1);
            used[i] = false;
        }
    }
}