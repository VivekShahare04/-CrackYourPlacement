class Solution {
    public int numSub(String s) {
        long count = 0;
        long curr = 0;
        int mod = 1000000007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                curr++;                      // extend current streak of 1s
                count = (count + curr) % mod; // add all substrings ending here
            } else {
                curr = 0;                    // reset when we hit a 0
            }
        }
        return (int) count;
    }
}
