class Solution {
    public class Pair{
        Character key;
        int val;
        Pair(Character key,int val){
            this.key = key;
            this.val = val;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> hp = new PriorityQueue<>((x,y)->y.val-x.val);
        if (a > 0) hp.add(new Pair('a', a));
        if (b > 0) hp.add(new Pair('b', b));
        if (c > 0) hp.add(new Pair('c', c));


        //PriorityQueue<Pair> hp2 = new PriorityQueue<>((x,y)->y.val-x.val);
        while(!hp.isEmpty()){
            Pair first = hp.poll();
            int n = sb.length();

            if(n>=2 && sb.charAt(n-1)==first.key && sb.charAt(n-2)==first.key){
                if(hp.isEmpty()) break;
                Pair second = hp.poll();
                sb.append(second.key);
                second.val--;
                if(second.val>0)hp.add(second);
                hp.add(first);
            }else{
                int take = Math.min(2, first.val);
                for(int i=0; i<take; i++) sb.append(first.key);
                first.val -= take;
                if(first.val>0)hp.add(first);
            }    
        }
        return sb.toString();
    }
}