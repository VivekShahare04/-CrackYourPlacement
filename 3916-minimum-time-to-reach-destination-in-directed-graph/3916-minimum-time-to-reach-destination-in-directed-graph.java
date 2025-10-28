class Solution {
    public int minTime(int n, int[][] edges) {
        List<List<int[]>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            res.get(edge[0]).add(new int[]{edge[1],edge[2],edge[3]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int time = node[0];
            int curr = node[1];

            if(curr==n-1)return time;
            if(time>dist[curr])continue;

            for(int[] neigh:res.get(curr)){
                int to=neigh[0],start=neigh[1],end=neigh[2];

                if (time > end) continue;
                
                int nextime = Math.max(time,start)+1;
                if(nextime < dist[to]){
                    dist[to]=nextime;
                    pq.offer(new int[]{nextime,to});
                }
            }
        }
        return -1;
    }
}