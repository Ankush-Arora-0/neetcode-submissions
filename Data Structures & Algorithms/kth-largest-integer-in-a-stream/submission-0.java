class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n:nums){
            pq.offer(n);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        Queue<Integer> q = new LinkedList<>();
        int tempK = k;
        int ans =0;
        while(tempK>1){
            q.offer(pq.poll());
            tempK--;
        }
        ans = pq.peek();
        while(!q.isEmpty()){
            pq.offer(q.poll());
        }
        return ans;
    }
}
