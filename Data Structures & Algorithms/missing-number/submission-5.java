class Solution {
    public int missingNumber(int[] nums) {
        int f = nums.length;
            for(int i=0;i<nums.length;i++){
            f = (f^nums[i]);
            f = (f^i);
        }
        
    
        
        return f;
    }
}
