class Solution {
     HashMap<Integer,Integer> map = new HashMap<>();
     public int dfs(int[] cost,int n){
        if(n<=1) return 0;
        if(map.containsKey(n)) return map.get(n);
        map.put(n,Math.min(dfs(cost,n-1)+cost[n-1],dfs(cost,n-2)+cost[n-2]));
        return map.get(n);
     }
    public int minCostClimbingStairs(int[] cost) {
        return dfs(cost,cost.length);
    }
}
