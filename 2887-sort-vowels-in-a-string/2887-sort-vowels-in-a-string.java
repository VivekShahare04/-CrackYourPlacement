class Solution {
    public String sortVowels(String s) {
        List<Character> ls = new ArrayList<>();
        char[] chs = s.toCharArray();
        for(char c:chs){
            char d = Character.toLowerCase(c);
            if(d=='a'||d=='e'||d=='i'||d=='o'||d=='u'){
                ls.add(c);
            }
        }
        Collections.sort(ls);
        for(int i=0,j=0;i<chs.length;i++){
            char d = Character.toLowerCase(chs[i]);
            if(d=='a'||d=='e'||d=='i'||d=='o'||d=='u'){
                chs[i] = ls.get(j);
                j++;
            }
        }
        return String.valueOf(chs);
    }
}