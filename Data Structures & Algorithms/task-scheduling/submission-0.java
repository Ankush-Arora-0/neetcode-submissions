class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char t:tasks){
            int idx = (int)(t-'A');
            freq[idx]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq){
            if(f!=0){
                pq.offer(f);
            }
        }
        int time =0;
        Queue<Integer> q = new LinkedList<>();
        while(!pq.isEmpty()){
            int val = pq.poll();
            time++;
            if(val-1!=0){
                q.offer(val-1);
                int cooldown = 0;
                while(cooldown<n){
                    if(!pq.isEmpty()){
                        int v = pq.poll();
                        if(v-1!=0){
                            q.offer(v-1);
                        }
                    }
                    cooldown++;
                }
                time+=n;
            }
            while(!q.isEmpty()){
                pq.offer(q.poll());
            }
            
        }
        return time;
    }
}
