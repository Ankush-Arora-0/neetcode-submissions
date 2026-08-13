class Solution {
    String word;
    public boolean isValid(int i, int j, int n,int m){
        if(i<0 || j<0 || i>=n || j>=m)return false;
        return true;
    }
    public boolean dfs(char[][] board,int i,int j,StringBuilder str,boolean[][] vis){
        str.append(board[i][j]+"");
        vis[i][j] = true;
        if(str.toString().equals(word)) return true;
        if(isValid(i+1,j,board.length,board[0].length)){
            if(!vis[i+1][j]){
                if(dfs(board,i+1,j,str,vis))return true;
            }
        }
        if(isValid(i-1,j,board.length,board[0].length)){
            if(!vis[i-1][j]){
                if(dfs(board,i-1,j,str,vis))return true;
            }
        }
        if(isValid(i,j+1,board.length,board[0].length)){
            if(!vis[i][j+1]){
                if(dfs(board,i,j+1,str,vis))return true;
            }
        }
        if(isValid(i,j-1,board.length,board[0].length)){
            if(!vis[i][j-1]){
                if(dfs(board,i,j-1,str,vis))return true;
            }
        }
        str.delete(str.length()-1,str.length());
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String w) {
        word = w;
        StringBuilder str = new StringBuilder();
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,str,vis))return true;
            }
        }
        return false;
    }
}
