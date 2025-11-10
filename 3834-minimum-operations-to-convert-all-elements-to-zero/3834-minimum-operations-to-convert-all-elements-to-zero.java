class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        Deque<Integer>stack = new ArrayDeque<>();
        stack.addLast(0);

        for(int num : nums){
            while(stack.peekLast() > num){
                stack.removeLast();
            }
            if(stack.peekLast() < num){
                if(num > 0){
                    count++;
                    stack.addLast(num);
                }
            }
        }
        return count;
    }
}