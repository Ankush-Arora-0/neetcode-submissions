class Solution {
    public boolean isValid(int i,int j, int n,int m){
        if(i<0||i>=n || j<0||j>=m) return false;
        return true;
    }
    public void solve(char[][] board) {    
        int n = board.length;
        int m = board[0].length; 
        Queue<int[]> q= new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((i==0 || i==board.length-1 || j==0 || j==board[0].length-1) && board[i][j]=='O'){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int cell[] = q.poll();
            int r = cell[0];
            int c = cell[1];
            if(isValid(r+1,c,n,m)){
                if(!vis[r+1][c]){
                    if(board[r+1][c]=='O'){
                        vis[r+1][c]= true;
                        q.offer(new int[]{r+1,c});
                    }
                }
            }
            if(isValid(r-1,c,n,m)){
                if(!vis[r-1][c]){
                    if(board[r-1][c]=='O'){
                        vis[r-1][c]= true;
                        q.offer(new int[]{r-1,c});
                    }
                }
            }
            if(isValid(r,c-1,n,m)){
                if(!vis[r][c-1]){
                    if(board[r][c-1]=='O'){
                        vis[r][c-1]= true;
                        q.offer(new int[]{r,c-1});
                    }
                }
            }
            if(isValid(r,c+1,n,m)){
                if(!vis[r][c+1]){
                    if(board[r][c+1]=='O'){
                        vis[r][c+1]= true;
                        q.offer(new int[]{r,c+1});
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
