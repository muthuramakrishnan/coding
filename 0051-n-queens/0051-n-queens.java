class Solution {
    private static Set rowSet = new TreeSet();
    private static Set colSet = new TreeSet();
    private static Set diagonal1Set = new TreeSet();
    private static Set diagonal2Set = new TreeSet();

    public static boolean isSafe(int row, int col,  boolean[][] board){
        int n = board.length;
        int diagonal1Num = row + col;
        int diagonal2Num = (col - row) + n;

        if(colSet.contains(col) || diagonal1Set.contains(diagonal1Num) || diagonal2Set.contains(diagonal2Num)){
            return false;
        }
        return true;
    }
    public static void addToset(int row, int col, int n, boolean[][] board){
        int diagonal1Num = row + col;
        int diagonal2Num = (col - row) + n;

        rowSet.add(row);
        colSet.add(col);
        diagonal1Set.add(diagonal1Num);
        diagonal2Set.add(diagonal2Num);
        board[row][col] = true;
    }
    public static void removeFromSet(int row, int col, int n, boolean[][] board){
        int diagonal1Num = row + col;
        int diagonal2Num = (col - row) + n;

        rowSet.remove(row);
        colSet.remove(col);
        diagonal1Set.remove(diagonal1Num);
        diagonal2Set.remove(diagonal2Num);
        board[row][col] = false;
        
    }
    public static void solve(int row, List<List<String>> solutions, boolean[][] board){
        int n = board.length;
        if(row == n){
            List<String> solution = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringBuffer sb = new StringBuffer();
                for(int j=0; j<n; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                solution.add(sb.toString());
            }
            solutions.add(solution);
            return;
        }

        for(int col=0; col<n; col++){
            if(isSafe(row, col, board)){
                addToset(row, col, n, board);
                solve(row + 1, solutions, board);
                removeFromSet(row, col, n, board);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> solutions = new ArrayList<>();
        
        int row = 0;
        solve(row, solutions, board);
        return solutions;
    }
}