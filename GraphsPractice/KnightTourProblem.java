package GraphsPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightTourProblem {

    // private static final int MAX_GRID_SIZE = (int) Math.pow(10, 6);

    static private class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static private class Pair {
        Cell cell;
        int dist;

        Pair(Cell cell, int dist) {
            this.cell = cell;
            this.dist = dist;
        }
    }

    public static boolean isValidMove(Cell currCell, Cell adjCell, int n) {
        if (currCell.x + adjCell.x < 0 || currCell.x + adjCell.x >= n) {
            return false;
        }
        if (currCell.y + adjCell.y < 0 || currCell.y + adjCell.y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);

        s = br.readLine().split(" ");

        Cell src = new Cell(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        Cell dest = new Cell(Integer.parseInt(s[2]), Integer.parseInt(s[3]));

        List<Cell> possibleMoves = List.of(new Cell[] { new Cell(-2, -1), new Cell(-2, 1), new Cell(2, -1),
                new Cell(2, 1), new Cell(-1, -2), new Cell(-1, 2), new Cell(1, -2), new Cell(1, 2) });

        boolean[][] visitedNodes = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();
        visitedNodes[src.x][src.y] = true;
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            Cell currCell = pair.cell;
            int currDist = pair.dist;

            if (currCell.x == dest.x && currCell.y == dest.y) {
                System.out.println(currDist);
                System.exit(0);
            }

            for (Cell adjacentCell : possibleMoves) {
                if (isValidMove(currCell, adjacentCell, n)) {
                    int newCellX = currCell.x + adjacentCell.x;
                    int newCellY = currCell.y + adjacentCell.y;
                    if (!visitedNodes[newCellX][newCellY]) {
                        Cell newCell = new Cell(newCellX, newCellY);
                        int newDist = currDist + 1;
                        queue.add(new Pair(newCell, newDist));
                        visitedNodes[newCellX][newCellY] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
