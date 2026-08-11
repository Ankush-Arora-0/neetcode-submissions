class Solution {
    public void dfs(HashMap<String,PriorityQueue<String>> map,String frm,List<String> ans){
        
        PriorityQueue<String> pq = map.get(frm);
        while(pq!=null && !pq.isEmpty()){
            String to = pq.poll();
            dfs(map,to,ans);
        }
            ans.addFirst(frm);
        
        
        
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();
        // HashSet<String> set = new HashSet<>();
        // Queue<String> pq = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        for(List<String> tck:tickets){
            String f = tck.get(0);
            String t = tck.get(1);
            if(!map.containsKey(f)){
                map.put(f,new PriorityQueue<>());

            }
            map.get(f).offer(t);
        }
        // for(Map.Entry<String,List<String>> m :map.entrySet()){
        //     Collections.sort(m.getValue());
        // }
        String frm = "JFK";
        dfs(map,frm,ans);
        // ans.addFirst(frm);
        
        return ans;
    }
}
