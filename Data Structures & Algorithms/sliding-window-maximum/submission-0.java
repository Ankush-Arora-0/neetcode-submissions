class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        int i=0,j=0;
        int ans[] = new int[nums.length-k+1];
        int idx=0;
        while(j<k){
            pq.offer(new int[]{nums[j],j});
            j++;
        }
        ans[idx++] = pq.peek()[0];
        while(j<nums.length){
            pq.offer(new int[]{nums[j],j});
            while(pq.peek()[1]<=i){
                pq.poll();
            }
            i++;
            j++;
            ans[idx++] = pq.peek()[0];
        }
        return ans;
    }
}
