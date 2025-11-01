class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bt(n,0,0,"",res);
        return res;
    }

    public static void bt(int n,int left,int right,String s,List<String> res){
        if(s.length()==2*n){
            res.add(s);
            return;
        }

        if(left<n){
            bt(n,left+1,right,s+'(',res);
        }
        if(right<left){
            bt(n,left,right+1,s+')',res);
        }
    }
}