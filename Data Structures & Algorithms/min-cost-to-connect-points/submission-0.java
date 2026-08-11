class Solution {
    class DJS{
        int parent[];
        int size[];
        DJS(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int findParent(int n){
            if(n==parent[n]) return n;
            return parent[n] = findParent(parent[n]);
        }
        public boolean union(int n1,int n2){
            int p1 = findParent(n1);
            int p2 = findParent(n2);
            if(p1==p2) return false;
            if(size[p1]<=size[p2]){
                parent[p1] = p2;
                size[p2]+=size[p1];
            }
            else{
                parent[p2] = p1;
                size[p1]+=size[p2];
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    pq.offer(new int[]{i,j,dist});
                }
            }
        }

        DJS dsu = new DJS(n);
        int cost =0;
        while(!pq.isEmpty() && n>1){
            int cell[]  =pq.poll();
            int f = cell[0];
            int t = cell[1];
            int c  =cell[2];
            if(dsu.union(f,t)){
                cost+=c;
                n--;
            }
        }
        return cost;
    }
}
