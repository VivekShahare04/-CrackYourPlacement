class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        int f1[] = new int[26];
        int f2[] = new int[26];
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();

        for(char c:word1.toCharArray()){
            f1[c-'a'] = f1[c-'a'] + 1;
            s1.add(c);
        }  
        for(char c:word2.toCharArray()){
            f2[c-'a'] = f2[c-'a'] + 1;
            s2.add(c);
        }    
        Arrays.sort(f1);
        Arrays.sort(f2);
        return s1.equals(s2) && Arrays.equals(f1,f2);
    }
}