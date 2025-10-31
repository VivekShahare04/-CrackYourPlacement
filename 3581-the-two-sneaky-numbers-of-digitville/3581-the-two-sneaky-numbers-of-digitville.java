class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        if(nums.length==0)return new int[]{0,0};

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        ArrayList<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val>1){
                ls.add(key);
            }
        }
        for(int i=0;i<ls.size();i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}