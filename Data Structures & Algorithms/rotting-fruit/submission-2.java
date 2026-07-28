class Solution {
    public boolean isValid(int[][] grid,int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1) return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int fresh =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }

            }
        }
        // if(q.isEmpty())return -1;
        int ans =0;
        while(!q.isEmpty()){
            int size = q.size();
            // System.out.println(size);
            while(size>0){
                int cell[] = q.poll();
                int r =cell[0];
                int c = cell[1];

                if(isValid(grid,r+1,c)){
                    if(!visited[r+1][c]){
                        // grid[r+1][c] = 2;
                        visited[r+1][c] =true;
                        q.offer(new int[]{r+1,c});
                        // System.out.printf("r-> %d, c-> %d, to r->%d, c-> %d\n",r,c,r+1,c);
                    }
                }
                if(isValid(grid,r-1,c)){
                    if(!visited[r-1][c]){
                        visited[r-1][c] =true;
                        q.offer(new int[]{r-1,c});
                        // System.out.printf("r-> %d, c-> %d, to r->%d, c-> %d\n",r,c,r-1,c);
                    }
                }
                if(isValid(grid,r,c+1)){
                    if(!visited[r][c+1]){
                        visited[r][c+1] =true;
                        q.offer(new int[]{r,c+1});
                        // System.out.printf("r-> %d, c-> %d, to r->%d, c-> %d\n",r,c,r,c+1);
                    }
                }
                if(isValid(grid,r,c-1)){
                    if(!visited[r][c-1]){
                        visited[r][c-1] =true;
                        q.offer(new int[]{r,c-1});
                        // System.out.printf("r-> %d, c-> %d, to r->%d, c-> %d\n",r,c,r,c-1);
                    }
                }
                size--;
            }
            if(!q.isEmpty()){
                fresh-=q.size();
                ans++;
            }
        }
        return fresh>0?-1:ans;
    }
}
