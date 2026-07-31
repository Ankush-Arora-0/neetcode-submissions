class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(n<=2) return n;
        if(map.containsKey(n)) return map.get(n);
        map.put(n,climbStairs(n-1)+climbStairs(n-2));
        return map.get(n);
    }
}
