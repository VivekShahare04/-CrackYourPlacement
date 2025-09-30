class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ls = new ArrayList<>();
        for(int num:nums){
            ls.add(num);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<ls.size()-1;j++){
                ls.set(j,(ls.get(j)+ls.get(j+1))%10);
            }
            ls.remove(ls.size() - 1);
        }
        return ls.get(0);
    }
}