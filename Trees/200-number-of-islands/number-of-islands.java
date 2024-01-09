class Solution {
    public boolean isValid(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0'){
            return false;
        }
        return true;
    }
    public void doDfs(int i, int j, boolean[][] visited, char[][] grid, List<List<Integer>> directionsList){
        if(!isValid(grid, i, j)){
            return;
        }
        if(visited[i][j]){
            return;
        }
        visited[i][j] = true;
        for(List<Integer> direction : directionsList){
            int iDirection = direction.get(0);
            int jDirection = direction.get(1);
            doDfs(i + iDirection, j + jDirection, visited, grid, directionsList);
        }
    }
    public int numIslands(char[][] grid) {
        List<List<Integer>> directionsList = List.of(
            List.of(new Integer[] {-1, 0}),
            List.of(new Integer[] {+1, 0}),
            List.of(new Integer[] {0, -1}),
            List.of(new Integer[] {0, +1})
        );

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int numIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isValid(grid, i, j)){
                    if(!visited[i][j]){
                        numIslands++;
                    }
                    doDfs(i, j, visited, grid, directionsList);
                }
            }
        }
        return numIslands;
    }
}