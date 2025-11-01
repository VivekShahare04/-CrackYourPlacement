class Solution {
    String[] map={
        "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)return res;
        bt(digits,0,"",res);
        return res;
    }
    public void bt(String digits,int i,String s,List<String> res){
        if(i==digits.length()){
            res.add(s);
            return;
        }

        String letters = map[digits.charAt(i)-'2'];

        for(char ch:letters.toCharArray()){
            bt(digits,i+1,s+ch,res);
        }
    }
}