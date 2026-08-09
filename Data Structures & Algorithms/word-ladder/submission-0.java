class Solution {
    public boolean isValid(String fst,String scd){
        if(fst.length()!=scd.length())return false;
        char f[] = fst.toCharArray();
        char s[] = scd.toCharArray();
        int diff=0;
        for(int i=0;i<f.length;i++){
            if(f[i]!=s[i])diff++;
            if(diff>1) return false;
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> map = new HashMap<>();
        int n = wordList.size();
        for(int i=0;i<n;i++){
            String thisWord = wordList.get(i);
            map.put(thisWord,new ArrayList<>());
            for(int j=0;j<n;j++){
                if(i!=j){
                    String thatWord = wordList.get(j);
                    if(isValid(thisWord,thatWord)){
                        map.get(thisWord).add(thatWord);
                    }
                }
            }
        }
        String thisWord = beginWord;
        map.put(thisWord,new ArrayList<>());
        for(int j=0;j<n;j++){
                String thatWord = wordList.get(j);
                if(isValid(thisWord,thatWord)){
                    map.get(thisWord).add(thatWord);
                }
        }
        // System.out.println(map);
        int ans =1;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.offer(beginWord);
        set.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                String myWord = q.poll();
                if(myWord.equals(endWord)) return ans;
                for(String wrds:map.get(myWord)){
                    if(!set.contains(wrds)){
                        set.add(wrds);
                        q.offer(wrds);
                    }
                }
                size--;
            }
            ans++;
        }
        return 0;
    }
}
