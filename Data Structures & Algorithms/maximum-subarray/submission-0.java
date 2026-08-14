class Solution {
    public int maxSubArray(int[] nums) {
        int j=0;
        int ans =Integer.MIN_VALUE;
        int sum =0;
        while(j<nums.length){
            sum+=nums[j];
            ans=  Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
                

            j++;
        }
        return ans;
    }
}
