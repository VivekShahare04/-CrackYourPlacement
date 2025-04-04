class Solution {
    public String decodeString(String s) {
        Stack<Pair<StringBuilder,Integer>> st = new Stack<>();
        StringBuilder currstr = new StringBuilder();
        int currnum=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                currnum = currnum*10 + (c-'0');
            }else if(c=='['){
                st.push(new Pair<>(currstr,currnum));
                currstr = new StringBuilder();
                currnum=0;
            }else if(c==']'){
                Pair<StringBuilder,Integer> pair = st.pop();
                StringBuilder prevstr = pair.getKey();
                int n = pair.getValue();
                currstr = prevstr.append(getRepeatstr(currstr,n));
            }else{
                currstr.append(c);
            }
        }
        return currstr.toString();
    }
    public StringBuilder getRepeatstr(StringBuilder str,int n){
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            sb.append(str);
        }
        return sb;
    }
}