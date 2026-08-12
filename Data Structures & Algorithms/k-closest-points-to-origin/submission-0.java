class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq =  new PriorityQueue<>((a,b)->Double.compare(a[1],b[1]));
        double idx =0;
        for(int p[]:points){
            double dist = Math.sqrt(Math.pow(p[0],2)+Math.pow(p[1],2));
            pq.offer(new double[]{idx,dist});
            idx++;
        }
        int ans[][]= new int[k][2];
        int i=0;
        while(i<k){
            double id = pq.poll()[0];
            ans[i] = points[(int)id];
            i++;
        }
        return ans;
    }
}
