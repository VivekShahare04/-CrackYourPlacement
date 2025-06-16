class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] node:times){
            int u = node[0]-1;
            int v = node[1]-1;
            int w = node[2];
            list.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k-1,1});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            for(int[] node:list.get(u)){
                int v = node[0];
                int wt = node[1];
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        int maxtime=0;
        for(int time:dist){
            if(time==Integer.MAX_VALUE)return -1;
            maxtime = Math.max(maxtime,time);
        }
        return maxtime-1;
    }
}