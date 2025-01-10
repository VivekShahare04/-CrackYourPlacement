class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] maxf = new int[26];
        for(String s:words2){
            int[] freq = new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            for(int i=0;i<26;i++){
                maxf[i] = Math.max(maxf[i],freq[i]);
            }
        }
        
        for(String t:words1){
            int[] freq = new int[26];
            for(char c:t.toCharArray()){
                freq[c-'a']++;
            }
            boolean isvalid=true;
            for(int i=0;i<26;i++){
                if(freq[i]<maxf[i]){
                    isvalid=false;
                    break;
                }
            }
            if(isvalid){
                list.add(t);
            }
        }
        return list;
    }
}