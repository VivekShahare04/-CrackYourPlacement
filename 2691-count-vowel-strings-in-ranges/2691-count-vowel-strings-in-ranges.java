class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int m = words.length;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int[] prefix = new int[m+1];

        for(int i=0;i<m;i++){
            String w = words[i];
            char fs = w.charAt(0);
            char ls = w.charAt(w.length()-1);

            if(set.contains(fs) && set.contains(ls)){
                prefix[i+1] = prefix[i] + 1;
            }else{
                prefix[i+1] = prefix[i];
            }
        }

        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int left = queries[i][0];
            int right = queries[i][1];

            res[i] = prefix[right+1] - prefix[left];
        }

        return res;
    }
}