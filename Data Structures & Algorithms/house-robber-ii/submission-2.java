class Solution {
 
    public int dfs(int[] nums,int n,boolean canChooseLast,HashMap<Integer,Integer> map){
        if(n==0){
            if(!canChooseLast) return Integer.MIN_VALUE;
        }
        if(n<=1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int ans = Math.max(dfs(nums,n-2,canChooseLast,map)+nums[n-2],dfs(nums,n-1,canChooseLast,map));
        map.put(n,ans);
        return ans;
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n<2) return nums[0];
        return Math.max(dfs(nums,n-1,false,new HashMap<>())+nums[n-1],Math.max(dfs(nums,n-2,true,new HashMap<>()),Math.max(dfs(nums,n-2,true,new HashMap<>())+nums[n-2],dfs(nums,n-1,true,new HashMap<>()))));
    }
}
