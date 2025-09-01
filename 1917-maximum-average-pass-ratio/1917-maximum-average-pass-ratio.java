import java.util.*;

class Solution {
    // Function to calculate the possible gain if we add one more student
    private double gain(int pass, int total) {
        double curr = (double) pass / total;
        double next = (double) (pass + 1) / (total + 1);
        return next - curr;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Max-heap based on gain
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                gain(b[0], b[1]),
                gain(a[0], a[1])
            )
        );

        // Push all classes
        for (int[] c : classes) {
            pq.add(c);
        }

        // Assign extra students
        while (extraStudents-- > 0) {
            int[] curr = pq.poll();
            curr[0]++;  // increment passes
            curr[1]++;  // increment total
            pq.add(curr); // push back
        }

        // Compute final average
        double sum = 0.0;
        for (int[] c : classes) {
            sum += (double) c[0] / c[1];
        }

        return sum / n;
    }
}
