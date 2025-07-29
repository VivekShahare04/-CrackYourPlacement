class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] NGE = new int[n];
        int[] PGE = new int[n];

        for(int i=0;i<n;i++){
            NGE[i]=n;
            PGE[i]=-1;
        }

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int top = st.pop();
                NGE[top] = i;
            }
            if(!st.isEmpty()){
                PGE[i] = st.peek();
            }
            st.push(i);
        }

        int maxarea=0;
        for(int i=0;i<n;i++){
            int currh = heights[i];
            int currw = NGE[i]-PGE[i]-1;
            maxarea = Math.max(maxarea,currh*currw);
        }
        return maxarea;
    }
}