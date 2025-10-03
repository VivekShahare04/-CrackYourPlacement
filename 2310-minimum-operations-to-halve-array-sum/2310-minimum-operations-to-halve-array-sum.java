
class Solution {
    public int halveArray(int[] nums) {
        // use double for precision
        double initialSum = 0;
        for (int n : nums) {
            initialSum += n;
        }

        // max heap (store as doubles)
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int n : nums) {
            maxHeap.add((double) n);
        }

        double target = initialSum / 2.0;
        double currentSum = initialSum;
        int operations = 0;

        while (currentSum > target) {
            double largest = maxHeap.poll();
            double half = largest / 2.0;
            currentSum -= (largest - half); // reduce sum by the difference
            maxHeap.add(half);
            operations++;
        }

        return operations;
    }
}
