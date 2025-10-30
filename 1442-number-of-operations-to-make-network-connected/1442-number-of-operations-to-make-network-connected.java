class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1)return -1;

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }

        for(int[] connection:connections){
            res.get(connection[0]).add(connection[1]);
            res.get(connection[1]).add(connection[0]);
        }
        
        boolean[] visited = new boolean[n];
        int connected =0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                connected++;
                dfs(n,res,i,visited);
            }
        }
        return connected-1;
    }

    public static void dfs(int n,List<List<Integer>> res,int i,boolean[] visited){
        visited[i]=true;
        for(int neigh:res.get(i)){
            if(!visited[neigh]){
                dfs(n,res,neigh,visited);
            }
        }
    }
}