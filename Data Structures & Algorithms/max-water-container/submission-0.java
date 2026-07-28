class Solution {
    public int maxArea(int[] h) {
        int left =0;
        int right = h.length-1;
        int maxArea=0;
        while(left<right){
            int min = Math.min(h[left],h[right]);
            int diff = right-left;
            int area = Math.max(0,diff*min);
            maxArea = Math.max(area,maxArea);
            if(h[left]==h[right]){
                right--;
                left++;
            }
            else if(h[left]<h[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
