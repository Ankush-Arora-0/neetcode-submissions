class Solution {
    HashMap<Integer,Integer> map= new HashMap<>();
    public int dfs(int[] nums,int n){
        if(n<=1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int ans = Math.max(dfs(nums,n-2)+nums[n-2],dfs(nums,n-1));
        map.put(n,ans);
        return ans;
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n<2) return nums[0];
        return Math.max(dfs(nums,n-1)+nums[n-1],dfs(nums,n-2)+nums[n-2]);
    }
}
