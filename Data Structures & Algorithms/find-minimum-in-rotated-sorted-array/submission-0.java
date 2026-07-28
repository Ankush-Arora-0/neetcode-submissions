class Solution {
    public int findMin(int[] nums) {
        int i=0;
        int j = nums.length-1;
        while(i<j){
            int mid = (j-i)/2+i;
            if(nums[j]<nums[mid]){
                i=mid+1;
                // System.out.println(i);
            }
            else{
                j=mid;
            }
        }
        return nums[j];
    }
}
