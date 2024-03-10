package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Sudoku {
    private static final int BOARD_SIZE = 9;
    private static boolean isSolved = false;

    public static int getSubArrIdx(int rowIdx, int colIdx) {
        int subArrRow = rowIdx / 3;
        int subArrCol = colIdx / 3;
        return 3 * subArrRow + subArrCol; // Calculate sub-grid index correctly
    }

    public static void solveSudoku(int[][] sudokuBoard, int[][] resultArr, int rowIdx, int colIdx,
            List<Set<Integer>> rowFreq,
            List<Set<Integer>> colFreq, List<Set<Integer>> subArrFreq) {

        if (rowIdx == BOARD_SIZE) {
            System.out.println("Output");
            System.out.println();
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    System.out.print(resultArr[i][j] + " ");
                }
                System.out.println();
            }
            isSolved = true;
            return;
        }

        if (isSolved) {
            return;
        }

        int nextRow = colIdx + 1 == BOARD_SIZE ? rowIdx + 1 : rowIdx;
        int nextCol = colIdx + 1 == BOARD_SIZE ? 0 : colIdx + 1;

        if (sudokuBoard[rowIdx][colIdx] != 0) {
            resultArr[rowIdx][colIdx] = sudokuBoard[rowIdx][colIdx];
            solveSudoku(sudokuBoard, resultArr, nextRow,
                    nextCol, rowFreq, colFreq, subArrFreq);
        }

        int subArrIdx = getSubArrIdx(rowIdx, colIdx);
        Set<Integer> rowSet = rowFreq.get(rowIdx);
        Set<Integer> colSet = colFreq.get(colIdx);
        Set<Integer> subArrSet = subArrFreq.get(subArrIdx);

        for (int i = 1; i <= BOARD_SIZE; i++) {
            if (!rowSet.contains(i) && !colSet.contains(i) && !subArrSet.contains(i)) {
                resultArr[rowIdx][colIdx] = i;
                rowSet.add(i);
                colSet.add(i);
                subArrSet.add(i);
                rowFreq.set(rowIdx, rowSet);
                colFreq.set(colIdx, colSet);
                subArrFreq.set(subArrIdx, subArrSet);

                solveSudoku(sudokuBoard, resultArr, nextRow,
                        nextCol, rowFreq, colFreq, subArrFreq);

                resultArr[rowIdx][colIdx] = 0;
                rowSet.remove(i);
                colSet.remove(i);
                subArrSet.remove(i);
                rowFreq.set(rowIdx, rowSet);
                colFreq.set(colIdx, colSet);
                subArrFreq.set(subArrIdx, subArrSet);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;

        int[][] sudokuBoard = new int[BOARD_SIZE][BOARD_SIZE];
        int[][] resultArr = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                sudokuBoard[i][j] = Integer.parseInt(s[j]);
                // resultArr[i][j] = sudokuBoard[i][j];
            }
        }

        List<Set<Integer>> rowFreq = new ArrayList<>();
        List<Set<Integer>> colFreq = new ArrayList<>();
        List<Set<Integer>> subArrFreq = new ArrayList<>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            Set<Integer> rowSet = new TreeSet<>();
            Set<Integer> columnSet = new TreeSet<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (sudokuBoard[i][j] != 0) {
                    rowSet.add(sudokuBoard[i][j]);
                }
                if (sudokuBoard[j][i] != 0) {
                    columnSet.add(sudokuBoard[j][i]);
                }
            }
            rowFreq.add(i, rowSet);
            colFreq.add(i, columnSet);
        }

        for (int i = 0; i < BOARD_SIZE; i += 3) {
            for (int j = 0; j < BOARD_SIZE; j += 3) {
                Set<Integer> subArrSet = new TreeSet<>();
                for (int i1 = i; i1 < i + 3; i1++) {
                    for (int j1 = j; j1 < j + 3; j1++) {
                        if (sudokuBoard[i1][j1] != 0) {
                            subArrSet.add(sudokuBoard[i1][j1]);
                        }
                    }
                }
                subArrFreq.add(subArrSet);
            }
        }

        int rowIdx = 0;
        int colIdx = 0;
        solveSudoku(sudokuBoard, resultArr, rowIdx, colIdx, rowFreq, colFreq, subArrFreq);

    }
}
