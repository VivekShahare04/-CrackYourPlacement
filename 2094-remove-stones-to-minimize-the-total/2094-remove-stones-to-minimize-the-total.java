class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>((a,b)->b-a);
        for(int n:piles){
            hp.add(n);
        }

        while(k>0){
            int curr = hp.poll();
            if(curr%2==1){
                int x = curr/2;
                hp.add(x+1);
            }else{
                hp.add(curr/2);
            }
            k--;
        }
        int sum=0;
        while(!hp.isEmpty()){
            int curr = hp.poll();
            sum = sum + curr;
        }
        return sum;
    }
}