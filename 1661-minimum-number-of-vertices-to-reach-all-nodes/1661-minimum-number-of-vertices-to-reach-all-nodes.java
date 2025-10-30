class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(List<Integer> edge:edges){
            res.get(edge.get(0)).add(edge.get(1));
        }
        int[] indeg = new int[n];
        for(int u=0;u<n;u++){
            for(int v:res.get(u)){
                indeg[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ls.add(node);

            // for(int neigh:res.get(node)){
            //     if(--indeg[neigh]==0)q.offer(neigh);
            // }
        }
        return ls;
    }
}