class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,0);

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int top = st.pop();
                ans[top]=i-top;
            }
            st.push(i);
        }
        return ans;
    }
}