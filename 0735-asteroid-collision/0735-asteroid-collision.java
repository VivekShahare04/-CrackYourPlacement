class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int n:asteroids){
            boolean isdestroy = false;

            while(!st.isEmpty() && n<0 && st.peek()>0){
                if(Math.abs(n)>Math.abs(st.peek())){
                    st.pop();
                }else if(Math.abs(n)==Math.abs(st.peek())){
                    st.pop();
                    isdestroy=true;
                    break;
                }else{
                    isdestroy=true;
                    break;
                }
            }
            if(!isdestroy){
                st.push(n);
            }
        }
        int ans[] = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
        
    }
}