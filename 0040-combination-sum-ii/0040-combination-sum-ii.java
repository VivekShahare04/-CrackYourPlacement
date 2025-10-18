class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        bt(candidates,target,new ArrayList<>(),res,0);
        return res;
    }
    public static void bt(int[] candidates,int target,List<Integer> ls,List<List<Integer>> res,int start){
        if(target==0){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])continue;
            if (candidates[i] > target) break;
            ls.add(candidates[i]);
            bt(candidates,target-candidates[i],ls,res,i+1);
            ls.remove(ls.size()-1);
        }
    }
}