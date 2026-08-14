class Solution {
    public int singleNumber(int[] nums) {
        int f = 0;
        for(int n:nums){
            f = f^n;
        }
        return f;
    }
}
