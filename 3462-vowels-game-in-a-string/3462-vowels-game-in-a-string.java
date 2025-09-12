class Solution {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If any vowel is found, Alice wins immediately
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return true;
        }
        // No vowels found → Alice cannot win
        return false;
    }
}