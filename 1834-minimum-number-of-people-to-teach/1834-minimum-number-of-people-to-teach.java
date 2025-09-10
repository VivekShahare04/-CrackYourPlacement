class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int users = friendships.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<users;i++){
            int u = friendships[i][0]-1;
            int v = friendships[i][1]-1;
            boolean cantalk=false;

            for(int x:languages[u]){
                for(int y:languages[v]){
                    if(x==y){
                        cantalk=true;
                        break;
                    }
                }
            }

            if(!cantalk){
                set.add(u);
                set.add(v);
            }
        }

        //hashmap banana hailanguage set check krne k liye
        HashMap<Integer,Integer> lang = new HashMap<>();
        for(int user:set){
            for(int language:languages[user]){
                lang.put(language,lang.getOrDefault(language,0)+1);
            }
        }

        int maxknownl=0;
        for(int v:lang.values()){
            maxknownl = Math.max(maxknownl,v);
        }

        return set.size()-maxknownl;
    }
}