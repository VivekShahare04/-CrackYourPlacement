class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // {r,c,h}

        // Push all boundary cells
        for (int r = 0; r < m; r++) {
            pq.offer(new int[]{r, 0, heightMap[r][0]});
            pq.offer(new int[]{r, n - 1, heightMap[r][n - 1]});
            visited[r][0] = true;
            visited[r][n - 1] = true;
        }
        for (int c = 1; c < n - 1; c++) {
            pq.offer(new int[]{0, c, heightMap[0][c]});
            pq.offer(new int[]{m - 1, c, heightMap[m - 1][c]});
            visited[0][c] = true;
            visited[m - 1][c] = true;
        }

        int water = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int r = cell[0], c = cell[1], h = cell[2];

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;
                visited[nr][nc] = true;

                int nh = heightMap[nr][nc];
                if (nh < h) water += (h - nh);
                pq.offer(new int[]{nr, nc, Math.max(nh, h)});
            }
        }
        return water;
}
}