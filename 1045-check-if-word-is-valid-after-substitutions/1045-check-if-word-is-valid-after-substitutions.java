class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            st.push(c);

            if(st.size()>=3){
                int n = st.size();
                if(st.get(n-3)=='a' && st.get(n-2)=='b' && st.get(n-1)=='c'){
                    st.pop();
                    st.pop();
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}