class Solution {
    public boolean dfs(List<List<Integer>> adj,int i,int visited[],Deque<Integer> dq){
        if(visited[i]==-1)return false;
        if(visited[i]==1)return true;
        visited[i] = -1;
        dq.offerFirst(i);
        System.out.println(i);
        for(int a:adj.get(i)){
            // System.out.printf("i-> %d, a-> %d\n",i,a);
            // System.out.println(set);

             if(!dfs(adj,a,visited,dq)) return false;
             
        }
        visited[i]=1;
        return true;
    }
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int dependency[] = new int[n];
        for(int p[]:prerequisites){
            int f =p[0];
            int t = p[1];
            adj.get(t).add(f);
            dependency[f]++;
        }
        for(int d=0;d<dependency.length;d++){
            if(dependency[d]==0){
                q.offer(d);
            }
        }
        if(q.isEmpty()) return new int[]{};
        int ans[] = new int[n];
        int idx=0;
        // System.out.println(q);
        while(!q.isEmpty()){
            int v = q.poll();
            ans[idx++] =v;
            for(int g:adj.get(v)){
                if((--dependency[g])==0) q.offer(g);
            }
        }
        for(int d=0;d<dependency.length;d++){
            if(dependency[d]!=0){
                return new int[]{};
            }
        }
        return ans;
    }
}
