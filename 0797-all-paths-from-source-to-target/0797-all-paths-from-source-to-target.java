class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0,graph,res,path);

        return res;
    }
    public void dfs(int node,int[][] graph,List<List<Integer>> res,List<Integer> path){

        path.add(node);

        if(node==graph.length-1){
            res.add(new ArrayList<>(path));
        }else{
            for(int it:graph[node]){
                dfs(it,graph,res,path);
            }
        }

        path.remove(path.size()-1);
    }
}