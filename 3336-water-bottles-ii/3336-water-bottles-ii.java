class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullbottles = numBottles;
        int empty = numBottles;
        int exchange = numExchange;
        int newBottle = 0;

        while(empty>=exchange){
            empty = empty - exchange;
            empty++;
            newBottle++;
            exchange++;
        }
        fullbottles += newBottle;
        return fullbottles;
    }
}