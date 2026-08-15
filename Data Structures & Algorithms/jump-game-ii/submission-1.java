class Solution {
    public int dfs(int nums[],int i,int jumps,int cost[]){
        if(i==nums.length-1) return 0;
        if(i>nums.length-1 || cost[i]<=jumps) return -1;
        cost[i] = jumps;
        int min = Integer.MAX_VALUE;
        for(int j= nums[i];j>=1;j--){
            int val = dfs(nums,i+j,jumps+1,cost);
            if(val!=-1){
                min = Math.min(min,val+1);
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
    public int jump(int[] nums) {
        int cost[]= new int[nums.length];
        Arrays.fill(cost,(int)1e8);

        return dfs(nums,0,0,cost);
    }
}
