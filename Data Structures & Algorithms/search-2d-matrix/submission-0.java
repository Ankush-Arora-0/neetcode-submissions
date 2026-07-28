class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0] && target<=matrix[i][m-1]){
                int k=0, j =m-1;
                while(k<=j){
                    int mid = (j-k)/2+k;
                    if(matrix[i][mid]==target) return true;
                    if(matrix[i][mid]<target){
                        k = mid+1;
                    }
                    else{
                        j=mid-1;
                    }
                }
                break;
            }
        }
        return false;
    }
}
