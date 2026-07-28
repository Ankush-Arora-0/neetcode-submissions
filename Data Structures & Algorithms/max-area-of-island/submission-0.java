class Solution {
    public boolean isValid(int i,int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return false;
        return true;
    }
    public int maxAreaOfIsland(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int ans= 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(grid[i][j]==0){
                        visited[i][j] =true;
                    }
                    else{
                        
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i,j});
                        visited[i][j] =true;
                        int temp =0;
                        while(!q.isEmpty()){
                            temp++;
                            int cell[] = q.poll();
                            int r = cell[0];
                            int c = cell[1];
                            if(isValid(r+1,c,grid)){
                                if(!visited[r+1][c]){
                                    q.offer(new int[]{r+1,c});
                                    visited[r+1][c] = true;
                                }
                            }
                            if(isValid(r-1,c,grid)){
                                if(!visited[r-1][c]){
                                q.offer(new int[]{r-1,c});
                                visited[r-1][c] = true;
                                }
                            }
                            if(isValid(r,c+1,grid)){
                                if(!visited[r][c+1]){
                                q.offer(new int[]{r,c+1});
                                visited[r][c+1] = true;
                                }
                            }
                            if(isValid(r,c-1,grid)){
                                if(!visited[r][c-1]){
                                q.offer(new int[]{r,c-1});
                                visited[r][c-1] = true;
                                }
                            }
                        }
                        ans = Math.max(ans,temp);
                    }
                }
            }
        }
        return ans;
    }
}
