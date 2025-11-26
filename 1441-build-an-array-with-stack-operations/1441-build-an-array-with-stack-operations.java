class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ls = new ArrayList<>();
        //Stack<String> st = new Stack<>();
        int j=0;

        for(int i=1;i<=n && j<target.length;i++){
            if(i==target[j]){
                ls.add("Push");
                j++;
            }else{
                ls.add("Push");
                ls.add("Pop");
            }
        }
        return ls;
    }
}