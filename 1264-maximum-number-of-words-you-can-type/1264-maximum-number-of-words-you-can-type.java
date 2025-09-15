class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int l=0;
        int h=0;
        ArrayList<String> ls = new ArrayList<>();
        while(h<text.length()){
            if(text.charAt(h)==' '){
                ls.add(text.substring(l,h));
                l=h+1;
            }
            h++;
        }
        ls.add(text.substring(l, h));
        //i have string array ["hello","world"]
        int count=0;
        for(String str:ls){
            boolean canType = true;
            for (char c : brokenLetters.toCharArray()) {
                if (str.indexOf(c) != -1) {
                    canType = false;
                    break;
                }
            }
            if (canType) count++;
        }
        return count;
    }
}