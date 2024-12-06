class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Boolean> banlist = new HashMap<>();

        for(int i:banned){
            banlist.put(i,true);
        }

        for(int i=1;i<=n;i++){
            if(banlist.get(i)==null){
                list.add(i);
            }
        }
        int ans=0;
        int val=0;
        for(int i=0;i<list.size();i++){
            int x = val + list.get(i);
            if(x<=maxSum){
                ans++;
                val = val + list.get(i);
            }
        }
        return ans;
    }
}