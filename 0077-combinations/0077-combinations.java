class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1,n,k,new ArrayList<>(),res);
        return res;
    }
    public static void backtrack(int start,int n,int k,List<Integer> ls,List<List<Integer>> res){
        if(ls.size()==k){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=start;i<=n;i++){
            
            ls.add(i);
            backtrack(i+1,n,k,ls,res);
            ls.remove(ls.size()-1);
        }
    }
}