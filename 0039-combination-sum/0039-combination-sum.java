class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bt(0,target,candidates,new ArrayList<>(),res);
        return res;
    }
    public static void bt(int start,int target,int[] candidates,List<Integer> ls,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(target<0)return;
        for(int i=start;i<candidates.length;i++){
            ls.add(candidates[i]);
            bt(i,target-candidates[i],candidates,ls,res);
            ls.remove(ls.size()-1);
        }
    }
}