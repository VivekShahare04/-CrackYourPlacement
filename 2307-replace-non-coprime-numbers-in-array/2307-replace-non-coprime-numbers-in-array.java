import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int n : nums) {
            stack.addLast(n); 
            
            
            while (stack.size() > 1) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                int g = gcd(a, b);
                
                if (g > 1) { 
                   
                    long merged = lcm(a, b, g);
                    stack.addLast((int) merged);
                } else {
                    
                    stack.addLast(b);
                    stack.addLast(a);
                    break;
                }
            }
        }
        return new ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // optimized lcm using precomputed gcd
    private long lcm(int a, int b, int g) {
        return (long) a / g * b; 
    }
}
