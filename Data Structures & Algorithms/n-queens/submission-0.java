class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean isSafe(char board[][],int i,int j){
        int n = board.length;
        int hi = i;
        int vli = i;
        int vlj = j;
        int vri = i;
        int vrj = j;
        while(hi>=0){
            if(board[hi][j]=='Q')return false;
            hi--;
        }
        while(vli>=0 && vlj>=0){
            if(board[vli][vlj]=='Q')return false;
            vli--;
            vlj--;
        }
        while(vri>=0 && vrj<n){
            if(board[vri][vrj]=='Q')return false;
            vri--;
            vrj++;
        }
        return true;

    }
    public void dfs(char board[][],int idx){
        if(idx==board.length){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,idx,i)){
                board[idx][i] = 'Q';
                dfs(board,idx+1);
                board[idx][i] ='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        dfs(board,0);
        return ans;
    }
}
