class Solution {
    public boolean dfs(int nums[],int i){

        // if(i==nums.length-1) return true;
        // if(i>nums.length-1) return false;
        // for(int j = nums[i];j>=1;j--){
        //     if(dfs(nums,i+j))return true;
        // }
        // return false;
        if(i==0)return true;
        for(int j =i-1;j>=0;j--){
            for(int k = nums[j];k>=1;k--){
                if(k==i-j){
                // System.out.printf("j->%d, i->%d\n",j,i);
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
