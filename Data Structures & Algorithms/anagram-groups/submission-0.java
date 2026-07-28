class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String temp =new String(arr);
            if(map.containsKey(temp)){
                map.get(temp).add(s);
            }
            else{
                List<String> lst = new ArrayList<>();
                lst.add(s);
                map.put(temp,lst);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> m:map.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
}
