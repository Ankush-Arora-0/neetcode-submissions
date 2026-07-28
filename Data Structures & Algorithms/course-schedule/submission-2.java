class Solution {
    public boolean dfs(List<List<Integer>> adj,int i,HashSet<Integer> set){
        if(set.contains(i))return false;
        set.add(i);
        for(int a:adj.get(i)){
            // System.out.printf("i-> %d, a-> %d\n",i,a);
            // System.out.println(set);
             if(!dfs(adj,a,set)) return false;
             set.remove(a);
        }
        return true;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int p[]:prerequisites){
            int f =p[0];
            int t = p[1];
            adj.get(f).add(t);
        }

        for(int i =0;i<n;i++){
           boolean res = dfs(adj,i,new HashSet<>());
           if(!res) return false;
        }
        return true;
    }
}
