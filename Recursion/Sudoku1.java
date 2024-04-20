
package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Sudoku1 {
    private static final int BOARD_SIZE = 9;
    private static int[][] rowFreq = new int[BOARD_SIZE][BOARD_SIZE + 1];
    private static int[][] colFreq = new int[BOARD_SIZE][BOARD_SIZE + 1];
    private static int[][] subMatFreq = new int[BOARD_SIZE][BOARD_SIZE + 1];
    private static boolean isAnsFound = false;

    public int getSubArrIdx(int rowIdx, int colIdx) {
        int subArrRow = rowIdx / 3;
        int subArrCol = colIdx / 3;
        return 3 * subArrRow + subArrCol; // Calculate sub-grid index correctly
    }

    public boolean canPlace(int row, int col, int num){
        int matrixNum = getSubArrIdx(row, col);
        if(rowFreq[row][num] == 0 && colFreq[col][num] == 0 && subMatFreq[matrixNum][num] == 0){
            return true;
        }
        return false;
    }

    public void place(int row, int col, int num, char[][] board){
        int matrixNum = getSubArrIdx(row, col);
        board[row][col] = (char) (num + '0');
        rowFreq[row][num]++;
        colFreq[col][num]++;
        subMatFreq[matrixNum][num]++;
    }

    public void remove(int row, int col, int num, char[][] board){
        int matrixNum = getSubArrIdx(row, col);
        board[row][col] = '.';
        rowFreq[row][num]--;
        colFreq[col][num]--;
        subMatFreq[matrixNum][num]--;
    }

    public void solve(int row, int col, char[][] board){
        if(row == BOARD_SIZE || isAnsFound){
            isAnsFound = true;
            return;
        }
        int nextRow = col + 1 == BOARD_SIZE ? row + 1 : row;
        int nextCol = col + 1 == BOARD_SIZE ? 0 : col + 1;
        if(board[row][col] != '.' ){
            solve(nextRow, nextCol, board);
        }
        else{
            for(int i=1; i<=BOARD_SIZE; i++){
                if(canPlace(row, col, i)){
                    place(row, col, i, board);
                    solve(nextRow, nextCol, board);
                    if(isAnsFound){
                        return;
                    }
                    remove(row, col, i, board);
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        isAnsFound = false;
        for(int i=0; i<BOARD_SIZE; i++){
            for(int j=0; j<=BOARD_SIZE; j++){
                rowFreq[i][j] = 0;
                colFreq[i][j] = 0;
                subMatFreq[i][j] = 0;
            }
        }

        for(int row=0; row<BOARD_SIZE; row++){
            for(int col=0; col<BOARD_SIZE; col++){
                if(board[row][col] == '.'){
                    continue;
                }
                int num = Integer.parseInt(String.valueOf(board[row][col]));
                rowFreq[row][num]++;
                colFreq[col][num]++;
            }
        }

        for(int i=0; i<BOARD_SIZE; i+=3){
            for(int j=0; j<BOARD_SIZE; j+=3){
                
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        if(board[k][l] == '.'){
                            continue;
                        }
                        int num = Integer.parseInt(String.valueOf(board[k][l]));
                        int matrixNum = getSubArrIdx(k, l);
                        subMatFreq[matrixNum][num]++;
                    }
                }

            }
        }

        int row = 0;
        int col = 0;
        solve(row, col, board);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

        for(int i=0; i<BOARD_SIZE; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<BOARD_SIZE; j++){
                board[i][j] = s[j].charAt(0);
            }
        }

        Sudoku1 sudoku = new Sudoku1();
        Sudoku1 sudoku1 = new Sudoku1();

        sudoku.solveSudoku(board);
        for(int i=0; i<BOARD_SIZE; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();

        for(int i=0; i<BOARD_SIZE; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<BOARD_SIZE; j++){
                board[i][j] = s[j].charAt(0);
            }
        }
        sudoku1.solveSudoku(board);
        for(int i=0; i<BOARD_SIZE; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}