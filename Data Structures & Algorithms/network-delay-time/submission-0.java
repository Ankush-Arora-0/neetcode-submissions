class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int t[]:times){
            int f = t[0];
            int s = t[1];
            int w = t[2];
            adj.get(f).add(new int[]{s,w});
        }
        int cost[] = new int[n+1];
        Arrays.fill(cost,(int)1e8);
        cost[k]=0;
        cost[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int node[] = pq.poll();
            int nd = node[0];
            int cst = node[1];
            if(cost[nd]<cst) continue;
            for(int[] nbrs:adj.get(nd)){
                int nbr = nbrs[0];
                int ncst = nbrs[1];
                if(cost[nbr]>cst+ncst){
                    cost[nbr] = cst+ncst;
                    pq.offer(new int[]{nbr,cst+ncst});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int c:cost){
            if(c==(int)1e8)return -1;
            max=Math.max(max,c);
        }
        return max;

    }
}
