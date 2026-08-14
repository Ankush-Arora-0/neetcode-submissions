class Solution {
    public boolean dfs(int nums[],int i){

        if(i==0)return true;
        for(int j =i-1;j>=0;j--){
            for(int k = nums[j];k>=1;k--){
                if(k==i-j){
                
                if(dfs(nums,j))return true;
            }
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return dfs(nums,nums.length-1);
    }
}
