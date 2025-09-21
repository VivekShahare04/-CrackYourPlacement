class Solution {
    public int maxRepeating(String sequence, String word) {
        int count=0; //track k count
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        while(sequence.contains(sb.toString())){
            count++;
            sb.append(word);
        }
        return count;
    }
}