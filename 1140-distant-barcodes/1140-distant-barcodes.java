class Solution {
     class Pair{
        int element;
        int freq;

        public Pair(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:barcodes){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Pair> hp = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            hp.add(new Pair(entry.getKey(),entry.getValue()));
        }
        ArrayList<Integer> ls = new ArrayList<>();
        PriorityQueue<Pair> hp2 = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        while(!hp.isEmpty()){
            Pair ele = hp.poll();
            ls.add(ele.element); 
            ele.freq--;
            
            //hp2.add(ele.element,map.get(ele.element)-1);
            while(!hp2.isEmpty()){
                hp.add(hp2.poll());
            }

            if(ele.freq>0)hp2.add(ele);
        }

        int n = ls.size();
        int[] ans = new int[n];
        int i=0;
        for(int num:ls){
            ans[i] = num;
            i++;
        }
        return ans;
    }
}