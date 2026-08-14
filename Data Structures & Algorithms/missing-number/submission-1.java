class Solution {
    public int missingNumber(int[] nums) {
        int f = nums.length;
        int max = 0;
        for(int n:nums){
            f = (f^n);
            max = Math.max(max,n);
        }
        if(max==nums.length){
            for(int i=0;i<max;i++){
            f = (f^i);
        }
        }
        else{
            for(int i=0;i<=max;i++){
            f = (f^i);
        }
        }
        
        return f;
    }
}
