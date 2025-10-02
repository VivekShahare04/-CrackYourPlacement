class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);//max heap to calculate maximum one

        for(int n:amount){
            if(n>0)pq.add(n);
        }

        int sec=0;
        while(!pq.isEmpty()){
            int first = pq.poll();
            int second=0;

            if(!pq.isEmpty()){
                second = pq.poll();
            }

            first--;
            if(second>0)second--;

            if(first>0)pq.add(first);
            if(second>0)pq.add(second);

            sec++;
        }
        return sec;
    }
}