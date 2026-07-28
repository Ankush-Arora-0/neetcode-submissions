class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        long prev = Long.MIN_VALUE;
        int count=0;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==prev){

            }
            else if(nums[i]==prev+1){
                count++;
                // if(i==nums.length-1)ans =Math.max(count,ans);
            }
            else{
                ans =Math.max(count,ans);
                count=1;
            }
            prev=nums[i];
        }
        ans =Math.max(count,ans);
        return ans;
    }
}
