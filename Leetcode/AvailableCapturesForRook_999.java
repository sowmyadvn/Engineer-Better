/*
On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.

 

Example 1:
Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation: 
In this example the rook is able to capture all the pawns.

Example 2:
Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 0
Explanation: 
Bishops are blocking the rook to capture any pawn.

Example 3:
Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation: 
The rook can capture the pawns at positions b5, d6 and f5.
*/
class Solution {
    public int numRookCaptures(char[][] board) {
        int south = -1,north = 0, east = 0, west = 0, row = 0, col = 0;
        for(int i = 0; i < 8 && south != 0; i++) {
            for(int j=0; j < 8; j++) {
                if(board[i][j] == 'R') {
                     row = i;
                     col = j;
                    south = 0;
                }
            }
        }
        
        for(int i = col-1; i >= 0 && board[row][i] != 'B' && north != 1; i--) {
               if(board[row][i] == 'p')
                   north = 1;
        }
        for(int i = col+1; i < 8 && board[row][i] != 'B' && south != 1; i++) {
               if(board[row][i] == 'p')
                   south = 1;
        }
        
         for(int i = row+1; i < 8 && board[i][col] != 'B' && east != 1; i++) {
               if(board[i][col] == 'p')
                   east = 1;
        }
        
        for(int i = row-1; i >= 0 && board[i][col] != 'B' && west != 1; i--) {
               if(board[i][col] == 'p')
                   west = 1;
        }
        return east+west+north+south;
}
}