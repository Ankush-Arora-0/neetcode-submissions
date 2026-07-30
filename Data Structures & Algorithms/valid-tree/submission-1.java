class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int e[]:edges){
            int f = e[0];
            int t = e[1];
            adj.get(f).add(t);
            adj.get(t).add(f);
        }
        // System.out.println(adj);
            boolean visited[] = new boolean[n];
            Queue<int[]> q =new LinkedList<>();
            q.offer(new int[]{0,-1});
            visited[0] = true;
            while(!q.isEmpty()){
                int cell[] = q.poll();
                int a = cell[0];
                int p = cell[1];
                
                for(int l:adj.get(a)){
                    if(l!=p){
                        if(visited[l]) return false;
                        q.offer(new int[]{l,a});
                        visited[l] = true;
                    }
                }
            }
            for(boolean v:visited){
                if(!v) return false;
            }
        return true;

    }
}
