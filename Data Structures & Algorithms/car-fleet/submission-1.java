class Solution {
    public int carFleet(int target, int[] pos, int[] sp) {
        PriorityQueue<double[]> pq= new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));
        for(int i=0;i<pos.length;i++){
            double p = (double) pos[i];
            double s =  (double) sp[i];
            double time =(target-p)/(double)s;
            pq.offer(new double[]{p,s,time});
        }
        int ans =0;
        double t =0.0;
        while(!pq.isEmpty()){
            double car[] =pq.poll();
            // System.out.println(Arrays.toString(car));
            if(car[2]>t){
                ans++;
                t=car[2];
            }
        }
        return ans;
    }
}
