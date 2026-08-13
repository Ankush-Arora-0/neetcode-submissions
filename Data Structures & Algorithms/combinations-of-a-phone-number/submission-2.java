class Solution {
    public static HashMap<Character,List<Character>> map = new HashMap<>();
    static{
        map.put('2',new ArrayList<>(List.of('a','b','c')));
        map.put('3',new ArrayList<>(List.of('d','e','f')));
        map.put('4',new ArrayList<>(List.of('g','h','i')));
        map.put('5',new ArrayList<>(List.of('j','k','l')));
        map.put('6',new ArrayList<>(List.of('m','n','o')));
        map.put('7',new ArrayList<>(List.of('p','q','r','s')));
        map.put('8',new ArrayList<>(List.of('t','u','v')));
        map.put('9',new ArrayList<>(List.of('w','x','y','z')));
    }
    public void dfs(char dgts[],int i,StringBuilder str,List<String> ans){
        if(i==dgts.length){
            if(str.length()>0)ans.add(new String(str));
            return;
        }
        char d = dgts[i];
        for(char c:map.get(d)){
            StringBuilder str2 = new StringBuilder(str);
            str2.append(c);
            dfs(dgts,i+1,str2,ans);
            // str.delete(str.length()-1,str.length());
        }
    }
    public List<String> letterCombinations(String digits) {
        char dgt[] = digits.toCharArray();
        List<String> ans = new ArrayList<>();
        dfs(dgt,0,new StringBuilder(),ans);
        return ans;
    }
}
