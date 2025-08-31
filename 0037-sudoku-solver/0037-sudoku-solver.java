class Solution {
    public void solveSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // fill initial constraints
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;

                int b = (i / 3) * 3 + (j / 3);
                rows[i].add(val);
                cols[j].add(val);
                boxes[b].add(val);
            }
        }

        backtrack(board, rows, cols, boxes, 0, 0);
    }

    private boolean backtrack(char[][] board, HashSet<Character>[] rows,
                              HashSet<Character>[] cols, HashSet<Character>[] boxes,
                              int r, int c) {
        if (r == 9) return true;  // solved

        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c + 1) % 9;

        if (board[r][c] != '.') {
            return backtrack(board, rows, cols, boxes, nextR, nextC);
        }

        int b = (r / 3) * 3 + (c / 3);
        for (char num = '1'; num <= '9'; num++) {
            if (rows[r].contains(num) || cols[c].contains(num) || boxes[b].contains(num)) {
                continue;
            }

            board[r][c] = num;
            rows[r].add(num);
            cols[c].add(num);
            boxes[b].add(num);

            if (backtrack(board, rows, cols, boxes, nextR, nextC)) return true;

            // undo
            board[r][c] = '.';
            rows[r].remove(num);
            cols[c].remove(num);
            boxes[b].remove(num);
        }

        return false;
    }
}
