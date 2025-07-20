class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child=0;
        int cookie=0;
        while(child < s.length && cookie < g.length){
            if(g[cookie]<=s[child]){
                cookie++;
            }
            child++;
        }
        return cookie;
    }
}