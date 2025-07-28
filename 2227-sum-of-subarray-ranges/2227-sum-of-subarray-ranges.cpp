class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        int n = nums.size();

        stack<int> st; // decreasing stack
        vector<int> NGE(n); // iterating from right

        for(int i=n-1; i>=0; i--){
            while(!st.empty() && nums[st.top()] < nums[i]){
                st.pop();
            }
            if(st.empty()){
                NGE[i] = n;
            }
            else{
                NGE[i] = st.top();
            }

            st.push(i);
        }

        while(!st.empty()){
            st.pop();
        }

        vector<int> PGE(n);
        for(int i=0; i<n; i++){
            while(!st.empty() && nums[st.top()] <= nums[i]){
                st.pop();
            }
            if(st.empty()){
                PGE[i] = -1;
            }
            else{
                PGE[i] = st.top();
            }

            st.push(i);
        }

        while(!st.empty()){
            st.pop();
        }

        vector<int> NSE(n);

        for(int i=n-1; i>=0; i--){
            while(!st.empty() && nums[st.top()] > nums[i]){
                st.pop();
            }
            if(st.empty()){
                NSE[i] = n;
            }
            else{
                NSE[i] = st.top();
            }

            st.push(i);
        }

        while(!st.empty()){
            st.pop();
        }

        vector<int> PSE(n);
        for(int i=0; i<n; i++){
            while(!st.empty() && nums[st.top()] >= nums[i]){
                st.pop();
            }
            if(st.empty()){
                PSE[i] = -1;
            }
            else{
                PSE[i] = st.top();
            }

            st.push(i);
        }

        // to calculate maxSum
        long long maxSum = 0;
        for(int i=0; i<n; i++){
            long long left = i - PGE[i];
            long long right = NGE[i] - i;

            long long totalSubarrays = left * right;
            long long totalSum = nums[i] * totalSubarrays;

            maxSum += totalSum;
        }

        long long minSum = 0;
        for(int i=0; i<n; i++){
            long long left = i - PSE[i];
            long long right = NSE[i] - i;

            long long totalSubarrays = left * right;
            long long totalSum = nums[i] * totalSubarrays;

            minSum += totalSum;
        }

        return maxSum - minSum;
    }
};