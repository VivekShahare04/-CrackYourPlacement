class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<>();
        solve(new StringBuilder(s),0,ls);
        return ls;
    }
    public static void solve(StringBuilder s,int src,List<String>ls){
        if(src==s.length()){
            ls.add(s.toString());
            return;
        }else if(Character.isDigit(s.charAt(src))){
            solve(s,src+1,ls);
            return;
        }
        s.setCharAt(src,Character.toLowerCase(s.charAt(src)));
        solve(s,src+1,ls);
        s.setCharAt(src,Character.toUpperCase(s.charAt(src)));
        solve(s,src+1,ls);
    }
}