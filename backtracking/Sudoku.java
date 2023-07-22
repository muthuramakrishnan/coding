package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sudoku {
    final static int BOARD_SIZE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudokuBoard = new int[BOARD_SIZE][BOARD_SIZE];
        String[] s;
        for (int i = 0; i < BOARD_SIZE; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                sudokuBoard[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] colFreq = new int[BOARD_SIZE][BOARD_SIZE + 1];
        int[][] rowFreq = new int[BOARD_SIZE][BOARD_SIZE + 1];
        int[][] subMatrixFreq = new int[BOARD_SIZE][BOARD_SIZE + 1];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                colFreq[i][sudokuBoard[j][i]]++;
                rowFreq[i][sudokuBoard[i][j]]++;
            }
        }

        for(int[] col : colFreq){
            System.out.println(Arrays.toString(col));
        }

    }
}
