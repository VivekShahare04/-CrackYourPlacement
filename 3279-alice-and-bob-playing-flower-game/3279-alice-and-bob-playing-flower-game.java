class Solution {
    public long flowerGame(int n, int m) {
        long even_n = n/2;
        long odd_n = n - n/2;

        long even_m = m/2;
        long odd_m = m - m/2;

        return (even_n*odd_m)+(even_m*odd_n);
    }
}