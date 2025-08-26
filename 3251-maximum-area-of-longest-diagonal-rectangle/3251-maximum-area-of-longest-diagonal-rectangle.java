class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double maxDiagonal=0;
        int bestArea=0;
        for(int i=0;i<n;i++){
            int n1 = dimensions[i][0];
            int n2 = dimensions[i][1];
            double diagonal = Math.sqrt((long)n1 * n1 + (long)n2 * n2);
            int area = n1 * n2;

            // If new diagonal is larger, update both diagonal and area
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                bestArea = area;
            } 
            // If diagonal is equal, take max area
            else if (diagonal == maxDiagonal) {
                bestArea = Math.max(bestArea, area);
            }
        }
        return bestArea;
    }
}