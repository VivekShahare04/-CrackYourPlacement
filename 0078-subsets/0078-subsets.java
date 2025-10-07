class Solution {
    HashSet<HashSet<Integer>> ans=new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> res = new ArrayList<>();
        // boolean[] visited = new boolean[nums.length];
        // solve(nums,visited,new ArrayList<>(),res);
        // return res;
        ans.clear();
        HashSet<Integer> cur=new HashSet<>();
         
       
        int i=0;
        sol(nums,i,cur);
          List<List<Integer>> listOfLists = new ArrayList<>();

        for (HashSet<Integer> innerSet : ans) {
            listOfLists.add(new ArrayList<>(innerSet));
        }
        return listOfLists;

        
       
        
    }
    public static void solve(int[] nums,boolean[] visited,List<Integer> ls,List<List<Integer>> res){
        res.add(new ArrayList<>(ls));

        for(int i=0;i<nums.length;i++){
            if(!visited[nums[i]]){
                solve(nums,visited,ls,res);
                res.add(ls);
                res.remove(res.size()-1);
            }
        }
    }
    public void sol(int[] nums,int i,HashSet<Integer> cur){
        if(i==nums.length){
             ans.add(new HashSet<>(cur));
            return;
        }
      
      
       sol(nums,i+1,cur);
       cur.add(nums[i]);
       sol(nums,i+1,cur);
       cur.remove(nums[i]);
      
    }

}