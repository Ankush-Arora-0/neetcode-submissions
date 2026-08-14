class Solution {
    public int missingNumber(int[] nums) {
        int f = nums.length;
        // int max = 0;
        // for(int n:nums){
        //     f = (f^n);
        //     max = Math.max(max,n);
        // }
            for(int i=0;i<nums.length;i++){
            f = (f^nums[i]);
            f = (f^i);
        }
        
    
        
        return f;
    }
}
