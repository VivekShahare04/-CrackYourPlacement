class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }

        int idx=0;
        Arrays.sort(heights);
        String[] sorted = new String[names.length];
        for(int i=heights.length-1;i>=0;i--){
            sorted[idx] = map.get(heights[i]);
            idx++;
        }
        return sorted;
    }
}