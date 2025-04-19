class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0]=true;

        Stack<Integer> st = new Stack<>();
        st.push(0);
        while(!st.isEmpty()){
            int curr_key = st.pop();
            for(int new_key:rooms.get(curr_key)){
                if(!seen[new_key]){
                    seen[new_key]=true;
                    st.add(new_key);
                }
            }
        }

        for(boolean visit:seen){
            if(!visit)return false;
        }
        return true;
    }
}