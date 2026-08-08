    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Arrays.sort(flights,(a,b)->Integer.compare(a[0],b[0]));
            int cost[] = new int[n];
            Arrays.fill(cost,(int)1e8);
            cost[src] = 0;
            for(int i=0;i<=k;i++){
                int temp[] = Arrays.copyOf(cost,n);
                for(int e[]:flights){
                int f = e[0];
                int t = e[1];
                int c = e[2];
                // adj.get(f).add(new int[]{t,c});
                
                    if(cost[f]!=(int)1e8 && cost[f]+c<temp[t]){
                        temp[t] = cost[f]+c;
                        // System.out.printf("cost[t] -> %d ,f->%d,  t ->%d\n",cost[t],f,t);
                    }
                }
                cost = Arrays.copyOf(temp,n);
            }
            
            return cost[dst]==(int)1e8?-1:cost[dst];
        }
    }
