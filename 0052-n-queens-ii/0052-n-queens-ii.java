class Solution {
    private static Set rowSet = new TreeSet();
    private static Set colSet = new TreeSet();
    private static Set diagonal1Set = new TreeSet();
    private static Set diagonal2Set = new TreeSet();
    private static int totalSolutions = 0;

    public static boolean isSafe(int row, int col, int n){
        int diagonal1Num = row + col;
        int diagonal2Num = (col - row) + n;

        if(colSet.contains(col) || diagonal1Set.contains(diagonal1Num) || diagonal2Set.contains(diagonal2Num)){
            return false;
        }
        return true;
    }
    public static void addToset(int row, int col, int n){
        int diagonal1Num = row + col;
        int diagonal2Num = (col - row) + n;

        rowSet.add(row);
        colSet.add(col);
        diagonal1Set.add(diagonal1Num);
        diagonal2Set.add(diagonal2Num);
    }
    public static void removeFromSet(int row, int col, int n){
        int diagonal1Num = row + col;
        int diagonal2Num = (col - row) + n;

        rowSet.remove(row);
        colSet.remove(col);
        diagonal1Set.remove(diagonal1Num);
        diagonal2Set.remove(diagonal2Num);
        
    }
    public static void solve(int row, int n){
        if(row == n){
            totalSolutions++;
        }

        for(int col=0; col<n; col++){
            if(isSafe(row, col, n)){
                addToset(row, col, n);
                solve(row + 1, n);
                removeFromSet(row, col, n);
            }
        }
    }

    public int totalNQueens(int n) {
        totalSolutions = 0;
        solve(0, n);
        return totalSolutions;
    }
}