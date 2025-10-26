class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }

        int[] result = new int[2];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If union returns false, this edge forms a cycle
            if (!union(parent, rank,u, v)) {
                result = edge;
            }
        }
        return result;
    }
    public static int find(int n,int[] parent){
        if(n!=parent[n]){
            parent[n] = find(parent[n],parent);
        }
        return parent[n];
    }

    public static boolean union(int[] parent,int[] rank,int x,int y){
        int rootx = find(x,parent);
        int rooty = find(y,parent);

        if(rootx==rooty)return false; //cycle detected

        if(rank[rootx]<rank[rooty]){
            parent[rootx] = rooty;
        }else if(rank[rootx]>rank[rooty]){
            parent[rooty] = rootx;
        }else{
            parent[rooty] = rootx;
            rank[rootx]++;
        }

        return true;
    }
}