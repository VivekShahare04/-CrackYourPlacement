class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int miss = 0;
        int repeat = 0;

        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                miss = i;
            }
            if(map.getOrDefault(i,0)>1){ //imp part
                repeat = i;
            }
        }
        return new int[]{repeat,miss};
    }
}