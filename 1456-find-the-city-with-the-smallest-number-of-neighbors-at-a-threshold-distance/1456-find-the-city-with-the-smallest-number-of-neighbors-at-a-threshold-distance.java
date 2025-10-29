class Solution {
    public int reach(int n,int start,int distanceThreshold,List<List<int[]>> res){
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(d>distanceThreshold)continue;
            for(int[] neigh:res.get(node)){
                int next = neigh[0];
                int wt = neigh[1];

                if(d+wt<dist[next]){
                    dist[next] = d+wt;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
        int reachable=0;
        for(int i=0;i<n;i++){
            if(i!=start && dist[i]<=distanceThreshold){
                reachable++;
            }
        }
        return reachable;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            res.get(edge[0]).add(new int[]{edge[1],edge[2]});
            res.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int resultcity=-1;
        int minreach = Integer.MAX_VALUE;

        for(int city=0;city<n;city++){
            int count = reach(n,city,distanceThreshold,res);
            if(count<=minreach){
                minreach = count;
                resultcity = city;
            }
        }
        return resultcity;
    }
}