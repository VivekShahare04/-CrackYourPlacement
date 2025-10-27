class Solution {
    public int numberOfBeams(String[] bank) {
        ArrayList<Integer> ls = new ArrayList<>();
        for(String s:bank){
            int count=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    count++;
                }
            }
            if(count!=0){
                ls.add(count);
            }
        }
        int sum =0;
        for(int i=1;i<ls.size();i++){
            sum += ls.get(i-1)*ls.get(i);
        }
        return sum;
    }
}