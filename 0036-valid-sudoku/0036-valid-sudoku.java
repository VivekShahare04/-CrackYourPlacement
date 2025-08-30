class Solution {
    public boolean isValidSudoku(char[][] board) {
        //I need to store row element in one set
        //col on other
        // box on other
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char val = board[i][j];
                int b = (i/3)*3 + (j/3);
                if(val=='.')continue;
                if(rows[i].contains(val) || cols[j].contains(val) || boxes[b].contains(val)){
                    return false;
                }
                rows[i].add(val);
                cols[j].add(val);
                boxes[b].add(val);
            }
        }
        return true;
    }
}