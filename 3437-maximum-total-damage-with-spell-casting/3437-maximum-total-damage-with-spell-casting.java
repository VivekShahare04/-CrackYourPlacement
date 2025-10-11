import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Step 1: Count the frequency of each spell power
        Map<Integer, Integer> count = new HashMap<>();
        for (int p : power) {
            count.put(p, count.getOrDefault(p, 0) + 1);
        }

        // Step 2: Get and sort the unique spell powers
        List<Integer> uniqueDamages = new ArrayList<>(count.keySet());
        Collections.sort(uniqueDamages);

        int n = uniqueDamages.size();
        // dp[i] stores the maximum damage considering spells up to uniqueDamages[i]
        long[] dp = new long[n];

        // Step 3: Base case for the first unique damage
        long currentPower = uniqueDamages.get(0);
        long currentCount = count.get(uniqueDamages.get(0));
        dp[0] = currentPower * currentCount;

        // Step 4: Iterate and compute the maximum damage
        for (int i = 1; i < n; i++) {
            currentPower = uniqueDamages.get(i);
            currentCount = count.get(uniqueDamages.get(i));
            
            // Option 1: Skip the current power.
            long skipDamage = dp[i - 1];
            
            // Option 2: Take the current power.
            long takeDamage = currentPower * currentCount;
            
            // Find the last valid power we can take before the current one
            // Use binary search for efficiency. We need to find the largest unique damage
            // less than (currentPower - 2)
            int prevValidIndex = -1;
            int low = 0, high = i - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(uniqueDamages.get(mid) < currentPower - 2){
                    prevValidIndex = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (prevValidIndex != -1) {
                takeDamage += dp[prevValidIndex];
            } else {
                // Check if the previous power (i-1) is a valid option
                if (uniqueDamages.get(i - 1) < currentPower - 2) {
                     takeDamage += dp[i - 1];
                }
            }
            
            // Step 5: Choose the maximum of taking or skipping
            dp[i] = Math.max(takeDamage, skipDamage);
        }

        return dp[n - 1];
    }
}
