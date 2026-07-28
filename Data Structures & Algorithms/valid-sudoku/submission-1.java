class Solution {
  
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char a = board[i][j];
                if(a!='.'){
                    for(int k=0;k<9;k++){
                        if(k!=j){if(board[i][k]==a)return false;}
                    }
                    for(int k=0;k<9;k++){
                        if(k!=i){if(board[k][j]==a)return false;}
                    }
                    int sr = (i/3)*3;
                    int sc = (j/3)*3;   
                    
                    for (int r = sr; r < sr + 3; r++) {
                        for (int c = sc; c < sc + 3; c++) {
                            if(r!=i || c!=j){
                                if(board[r][c] ==a)
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
