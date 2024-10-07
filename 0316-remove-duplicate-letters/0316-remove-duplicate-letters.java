class Solution {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        Stack<Character> st = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)map.put(s.charAt(i),i);

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);

            if(res[curr - 'a']==1)continue;

            while(!st.isEmpty() && curr<st.peek() && i<map.get(st.peek())){
                res[st.pop() - 'a'] = 0;
            }
            st.push(curr);
            res[curr-'a']=1;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}