class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char c:s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                map1.put(c,map1.getOrDefault(c,0)+1);
            }else{
                map2.put(c,map2.getOrDefault(c,0)+1);
            }
        }
        int vowel=0;
        int conso=0;
        for(int n:map1.values()){
            vowel = Math.max(vowel,n);
        }
        for(int n:map2.values()){
            conso = Math.max(conso,n);
        }

        return conso+vowel;
    }
}