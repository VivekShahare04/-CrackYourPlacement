class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        //while loop to iterate over strin num
        for(char c:num.toCharArray()){
            while(!st.isEmpty() &&k>0&& st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0){
            st.pop();
            k--;
        }
        // convert into strin
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        //remove leading zeros
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        //if result is empty return 0
        return sb.length()==0?"0":sb.toString();
 
    }
}