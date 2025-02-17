class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> hp = new PriorityQueue<>((a,b)->a.getValue().equals(b.getValue()) ? 
                      a.getKey().compareTo(b.getKey()) : 
                      b.getValue() - a.getValue() );
        hp.addAll(map.entrySet());

        ArrayList<String> ls = new ArrayList<>();
        for(int i=0;i<k;i++){
            ls.add(hp.poll().getKey());
        }
        return ls;
    }
    
}