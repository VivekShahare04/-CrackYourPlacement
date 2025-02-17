class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> hp =new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        hp.addAll(map.entrySet());

        for(int i=0;i<k;i++){
            arr[i] = hp.poll().getKey();
        }
        return arr;
    }
}