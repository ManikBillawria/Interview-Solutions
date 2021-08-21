class Solution {
    
    boolean isRowSafe(char[][] board, int row, char num) {
        for(int j = 0; j < 9; j++) {
            if(board[row][j] == num)
                return false;
        }
        return true;
    }
    
    boolean isColSafe(char[][] board, int col, char num) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == num)
                return false;
        }
        return true;
    }
    
    boolean isBoxSafe(char[][] board, int row, int col, char num) {
        int rowStart = row - row%3;
        int colStart = col - col%3;
        
        for(int i = rowStart; i < rowStart+3; i++) {
            for(int j = colStart; j < colStart+3; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
    
    boolean canPlaceNum(char[][] board, int row, int col, char num) {
        if(!isRowSafe(board, row, num))
            return false;
        if(!isColSafe(board, col, num))
            return false;
        if(!isBoxSafe(board, row, col, num))
            return false;
        
        return true;
    }
    
    boolean sudokuSolver(char[][] board) {
        int row = -1;
        int col = -1;
        boolean hasEmptyCell = false;
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    row = i;
                    col = j;
                    hasEmptyCell = true;
                    break;
                }
            }
            if(hasEmptyCell)
                break;
        }
        
        if(!hasEmptyCell) {
            return true;
        }
        
        for(char num = '1'; num <= '9'; num ++) {
            if(canPlaceNum(board, row, col, num)) {
                board[row][col] = num;
                if(sudokuSolver(board))
                    return true;   
            }
            board[row][col] = '.';
        }
        
        return false;
    } 
    
    public void solveSudoku(char[][] board) {
        
        sudokuSolver(board);
        
    }
}