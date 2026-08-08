class Solution {
    class DisJointSets{
        int size[];
        int parent[];
        int components;
        DisJointSets(int nodes){
            this.components = nodes;
            this.size = new int[nodes+1];
            this.parent = new int[nodes+1];
            for(int i=1;i<=nodes;i++){
                parent[i] = i;
            }
        }
        public int findRootParent(int node){
            if(node==parent[node]) return node;
            parent[node] = findRootParent(parent[node]);
            return parent[node];
        }
        public boolean union(int node1,int node2){
            int p1 = findRootParent(node1);
            int p2 = findRootParent(node2);
            if(p1==p2){
                return true;
            }
            components--;
            if(size[p1]<=size[p2]){
                parent[p1] = p2;
                size[p2]+=size[p1];
            }
            else{
                parent[p2] = p1;
                size[p1]+=size[p2];
            }
            return false;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DisJointSets dsu = new DisJointSets(edges.length);

        // List<List<Integer>> adj = new ArrayList<>();
        for(int e[]:edges){
            int f = e[0];
            int t = e[1];
            if(dsu.union(f,t)){
                return new int[]{f,t};
            }
        }

        // Queue<int[]> q= new LinkedList<>();
        // q.offer(new int[]{1,-1});
        // boolean vis[] = new boolean[adj.size()];
        // while(!q.isEmpty()){
        //     int node[] = q.poll();
        //     int it = node[0];
        //     int pt = node[1];
        //     for(int chld:adj.get(it)){
        //         if(chld!=pt){
        //             if(vis[chld]){
        //                 for(int i=edges.length-1;i>=0;i++){
        //                     if(edges[i][0]==it || edges[i][0]==chld || edges[i][1]==it || edges[i][1]==chld){
        //                         return edges[i];
        //                     }
        //                 }
        //             }
        //             else{
        //                 q.offer(new int[]{chld,it});
        //                 vis[chld] = true;
        //             }
        //         }
        //     }
        // }
        return new int[]{};
    }
}
