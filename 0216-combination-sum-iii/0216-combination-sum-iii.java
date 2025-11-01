class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(1,k,n,new ArrayList<>(),ans);
        return ans;
    }
    public static void bt(int i,int k,int n,List<Integer> arr,List<List<Integer>> res){
        if(arr.size()==k){
            if(n==0){
                res.add(new ArrayList<>(arr));
                return;
            }
        }

        if(i<=9){
            arr.add(i); //choose the curent element
            bt(i+1,k,n-i,arr,res);//add this number to our arr element and increase the index
            arr.remove(arr.size()-1);
            bt(i+1,k,n,arr,res);
        }
    }
}