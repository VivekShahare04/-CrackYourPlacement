class Solution {
    public double angleClock(int hour, int minutes) {
        double minute = 6*minutes;
        double hr = (hour*30)+(minutes*0.5);
        double angle = Math.abs(minute-hr); 
        double oangle = 360 - angle;
        return Math.min(angle,oangle); 
    }
}