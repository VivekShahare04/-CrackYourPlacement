class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        // next smaller ele and prev smaller ele
        int[] PSE = new int[n];
        int[] NSE = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                PSE[i] = -1;
            }else{
                PSE[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                NSE[i] = n;
            }else{
                NSE[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        long sum=0;
        for(int i=0;i<n;i++){
            long left = i - PSE[i];
            long right = NSE[i]-i;
            long totalsub = (left*right)%mod;
            sum = (sum+(arr[i]*totalsub)%mod)%mod;
        }
        return (int)sum;
    }
}