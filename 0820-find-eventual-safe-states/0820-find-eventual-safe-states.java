class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        int[] outdeg = new int[n];

        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            outdeg[i] = graph[i].length;
            for(int neigh:graph[i]){
                res.get(neigh).add(i);
                //outdeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdeg[i]==0)q.offer(i);
        }

        List<Integer> safe = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            safe.add(curr);

            for(int neigh:res.get(curr)){
                outdeg[neigh]--;
                if(outdeg[neigh]==0)q.offer(neigh);
            }
        }
        Collections.sort(safe);
        return safe;
    }
}