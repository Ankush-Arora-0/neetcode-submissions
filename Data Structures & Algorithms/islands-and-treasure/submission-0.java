class Solution {
    public boolean isValid(int i,int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length ||grid[i][j]==-1) return false;
        return true;
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                    visited[i][j] =true;
                }
            }
        }
        while(!q.isEmpty()){
            int cell[] = q.poll();
            int r = cell[0];
            int c = cell[1];


            if(isValid(r+1,c,grid)){
                if(!visited[r+1][c]){
                    grid[r+1][c] = grid[r][c]+1;
                    q.offer(new int[]{r+1,c});
                    visited[r+1][c] = true;
                }
            }
            if(isValid(r-1,c,grid)){
                if(!visited[r-1][c]){
                    grid[r-1][c] = grid[r][c]+1;
                    q.offer(new int[]{r-1,c});
                    visited[r-1][c] = true;
                }
            }
            if(isValid(r,c+1,grid)){
                if(!visited[r][c+1]){
                    grid[r][c+1] = grid[r][c]+1;
                    q.offer(new int[]{r,c+1});
                    visited[r][c+1] = true;
                }
            }
            if(isValid(r,c-1,grid)){
                if(!visited[r][c-1]){
                    grid[r][c-1] = grid[r][c]+1;
                    q.offer(new int[]{r,c-1});
                    visited[r][c-1] = true;
                }
            }
        }
    }
}
