
package sudoku;
public class SudokuBoard {
    int[][] board;
    final int INNER_DIMENSION=3;

    public SudokuBoard(int[][] board) // parameterised constructor
    {
        this.board=board;
    }
    public void print()
    {
        for (int row = 0; row < board.length; row++)
        {
            if(row%INNER_DIMENSION==0)
                System.out.println();

            for (int col = 0; col < board.length; col++)
            {
                if(col%INNER_DIMENSION==0)
                    System.out.print("  ");
                
                System.out.print(board[row][col] + " ");  //not println but print
            }
            System.out.println();
        }
    }

    public boolean solve(int row,int col)
    {
        if(row == board.length)
        {
            col++;

            if(col== board.length)
                return true;
            else
                row=0;
        }

        if(board[row][col] != 0)
            return solve(row+1,col);  //return statement very importatnt;-(

        for (int num = 1; num <= board.length; num++)
        {
            if(isValid(row,col,num))
            {
                board[row][col] = num;

                if (solve(row + 1, col))
                    return true;

                board[row][col] = 0; //backtrack
            }
        }
        return false;
    }


    public boolean isValid(int row,int col,int num)
    {
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==num)
                return false;
        }

        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==num)
                return false;
        }

        int startRow= (row/INNER_DIMENSION)*INNER_DIMENSION;
        int startCol= (col/INNER_DIMENSION)*INNER_DIMENSION;

        for (int i = startRow; i < startRow+INNER_DIMENSION; i++)
        {
            for (int j = startCol; j < startCol+INNER_DIMENSION; j++)
            {
                if (board[i][j]==num)
                    return false;
            }
        }
        return true;
    }

}

 
