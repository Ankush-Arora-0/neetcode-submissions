class Solution {
    public boolean isValid(int i,int j, int n){
        if(i<0 || i>=n || j<0 || j>=n) return false;
        return true;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean vis[][] = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,grid[0][0]});
        vis[0][0] = true;
        int max =grid[0][0] ;
        while(!pq.isEmpty()){
            int cell[] = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int w = cell[2];
            max = Math.max(max,w);
            if(x==n-1 && y==n-1){return max;}
            if(isValid(x+1,y,n)){
                if(!vis[x+1][y]){
                    pq.offer(new int[]{x+1,y,grid[x+1][y]});
                    vis[x+1][y] = true;
                }
            }
            if(isValid(x,y+1,n)){
                if(!vis[x][y+1]){
                    pq.offer(new int[]{x,y+1,grid[x][y+1]});
                    vis[x][y+1] = true;
                }
            }
            if(isValid(x-1,y,n)){
                if(!vis[x-1][y]){
                    pq.offer(new int[]{x-1,y,grid[x-1][y]});
                    vis[x-1][y] = true;
                }
            }
            if(isValid(x,y-1,n)){
                if(!vis[x][y-1]){
                    pq.offer(new int[]{x,y-1,grid[x][y-1]});
                    vis[x][y-1] = true;
                }
            }
        }
        return max;
    }
}
