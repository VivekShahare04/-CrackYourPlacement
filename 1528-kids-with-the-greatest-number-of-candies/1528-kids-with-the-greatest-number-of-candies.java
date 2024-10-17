class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;
        for(int c:candies){
            max = Math.max(max,c);
        }
        for(int c:candies){
            list.add(c+extraCandies >= max);
        }
        return list;
    }
}