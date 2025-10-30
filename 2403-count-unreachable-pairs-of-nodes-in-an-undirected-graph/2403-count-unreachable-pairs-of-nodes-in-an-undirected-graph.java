class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            res.get(edge[0]).add(edge[1]);
            res.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        List<Integer> composize = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                composize.add(dfs(i,res,visited));
            }
        }
        long totalsize = (long)n*(n-1)/2;
        long reachable=0;
        for(int size:composize){
            reachable += (long)size*(size-1)/2;
        } 
        return totalsize - reachable;
    }
    public static int dfs(int node,List<List<Integer>> res,boolean[] visited){
        visited[node]=true;
        int count=1;
        for(int neigh:res.get(node)){
            if(!visited[neigh]){
                count += dfs(neigh,res,visited);
            }
        }
        return count;
    }
}