class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        if(s.length()==0 || t.length()==0)return true;

        for(char c:s.toCharArray()){
            if(c=='#'){
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
            else{
                st1.push(c);
            }
        }
        for(char c:t.toCharArray()){
            if(c=='#'){
                if(!st2.isEmpty()){
                    st2.pop();
                }
            }
            else{
                st2.push(c);
            }
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            int a = st1.pop();
            int b = st2.pop();
            if(a!=b){
                return false;
            }
        }
        return st1.isEmpty()&&st2.isEmpty();
    }
}