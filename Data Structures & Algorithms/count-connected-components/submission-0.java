class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            int i = e[0];
            int j =e[1];
            adj.get(i).add(j);
            adj.get(j).add(i);
        }
        boolean visited[] = new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int v = q.poll();
                    for(int l:adj.get(v)){
                        if(!visited[l]){
                            visited[l] = true;
                            q.offer(l);
                        }
                    }
                
                }
            }
        }
        return ans;
    }
}
