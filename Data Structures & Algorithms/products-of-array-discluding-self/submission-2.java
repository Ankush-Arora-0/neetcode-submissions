class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftProduct[] = new int[nums.length];
        int rightProduct[] = new int[nums.length];
        int i=1,j=nums.length-2;
        leftProduct[0] = nums[0];
        rightProduct[nums.length-1] = nums[nums.length-1];

        while(i<nums.length){
            leftProduct[i] = leftProduct[i-1]*nums[i];
            rightProduct[j] = rightProduct[j+1]*nums[j];
            i++;
            j--;
        }
        // System.out.println(Arrays.toString(leftProduct));
        // System.out.println(Arrays.toString(rightProduct));
        int ans[] =new int[nums.length];
        for(int k=0;k<ans.length;k++){
            if(k==0){
                ans[k] =rightProduct[k+1];
            }
            else if(k==ans.length-1){
                ans[k] = leftProduct[k-1];
            }
            else{
                ans[k] = leftProduct[k-1]*rightProduct[k+1];
            }
        }
        return ans;
    }
}  
