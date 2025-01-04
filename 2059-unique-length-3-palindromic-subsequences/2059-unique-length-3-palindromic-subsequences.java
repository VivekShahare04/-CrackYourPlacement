class Solution {
    public int countPalindromicSubsequence(String s) {
        int cnt = 0, n = s.length();
        int[] freq = new int[26];
        int[][] mark = new int[26][26];
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                for(int x=hm.get(ch)+1; x < i; x++){
                    mark[ch-'a'][s.charAt(x)-'a'] = 1;
                }
            }
            hm.put(ch, i);
            freq[ch - 'a'] += 1;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(mark[i][j] == 1){
                    cnt += 1;
                }
            }
            if(freq[i] >= 3){
                cnt += 1;
            }
        }
        return cnt;
    }
}