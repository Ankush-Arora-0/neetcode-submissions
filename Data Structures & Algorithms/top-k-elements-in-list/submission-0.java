class Solution {
    class Pair implements Comparable<Pair>{
        int value;
        int freq;
        Pair(int v,int f){
            this.value = v;
            this.freq =f;
        }
        @Override
        public int compareTo(Pair that){
            return that.freq -this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
         for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
         }
         PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            pq.offer(new Pair(m.getKey(),m.getValue()));
        }
        int ans[] = new int[k];
        int i=0;
        while(i<k){
            ans[i] = pq.poll().value;
            i++;
        }
        return ans;
    }
}
