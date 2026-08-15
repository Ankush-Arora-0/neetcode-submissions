class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        int cost[] = new int[n];
        Arrays.fill(cost,(int)1e8);
        cost[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> e:edges){
            int f = e.get(0);
            int t = e.get(1);
            int w = e.get(2);
            adj.get(f).add(new int[]{t,w});
            
        }
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int nd = node[0];
            int cst = node[1];
            if(cost[nd]<cst)continue;
            for(int nbrs[]:adj.get(nd)){
                int nbr = nbrs[0];
                int w = nbrs[1];
                if(cst+w<cost[nbr]){
                    // System.out.println("h");
                    cost[nbr] = cst+w;
                    pq.offer(new int[]{nbr,cost[nbr]});
                }
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(cost[i]==(int)1e8)map.put(i,-1);
            else map.put(i,cost[i]);
        }
        return map;
    }  
}
