class Solution {
     public int getRightMax(int[] heights, int idx){
        int max = 0;
        int maxIdx = idx;
        idx++;
        while(idx<heights.length){
            
            if(max<heights[idx]){
                max = heights[idx];
                maxIdx = idx;
            }
            idx++;
        }
        return maxIdx;
    }
    public int trap(int[] heights) {
        int leftMax =0;
        int rightMax = getRightMax(heights,0);
        int maxArea=0;
        for(int i =0;i<heights.length;i++){
            if(i>=rightMax){
                rightMax = getRightMax(heights,i);
            }
            if(heights[leftMax]<heights[i]){
                leftMax =i;
            }
            int min = Math.min(heights[leftMax],heights[rightMax]);
            int area= Math.max(min-heights[i],0);
            // System.out.printf("i-> %d, area -> %d,lef -> %d, right -> %d\n",i,area,leftMax,rightMax);
            maxArea+=area;
        }
        return maxArea;
    }
}
