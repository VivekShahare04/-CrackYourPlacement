class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>();
        
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==c){
                count.push(count.pop()+1);
            }else{
                st.push(c);
                count.push(1);
            }
            if(count.peek()==k){
                count.pop();
                st.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            char c = st.pop();
            int x = count.pop();
            for(int i=0;i<x;i++){
                str.append(c);
            }
        }
        return str.reverse().toString();
    }
}