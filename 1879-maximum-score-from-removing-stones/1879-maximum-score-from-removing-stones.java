class Solution {
    public class Pair{
        int key;
        int val;
        Pair(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Pair> hp = new PriorityQueue<>((x,y)->y.val-x.val);
        if(a>0)hp.add(new Pair('a',a));
        if(b>0)hp.add(new Pair('b',b));
        if(c>0)hp.add(new Pair('c',c));

        int count=0;
        while(!hp.isEmpty()){
            Pair curr1 = hp.poll();
            Pair curr2 = hp.poll();

            curr1.val--;
            curr2.val--;

            count++;
            if(curr1.val>0)hp.add(curr1);
            if(curr2.val>0)hp.add(curr2);

            if(hp.isEmpty() || hp.size()<2){
                return count;
            }
        }
        return -1;
    }
}