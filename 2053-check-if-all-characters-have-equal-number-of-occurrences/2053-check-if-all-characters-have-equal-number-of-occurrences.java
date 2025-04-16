class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int firstValue = map.values().iterator().next();
        return map.values().stream().allMatch(value -> value.equals(firstValue));
    }
}