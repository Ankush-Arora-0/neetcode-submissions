class Solution {
    List<String> ans = new ArrayList<>();
    // int mainN;
    public void dfs(int open,int close,StringBuilder str){
        if(open==0 && close==0){
            ans.add(new String(str));
        }
        if(open>0){
            str.append("(");
            dfs(open-1,close,str);
            str.delete(str.length()-1,str.length());
        }
        if(close>open){
            str.append(")");
            dfs(open,close-1,str);
            str.delete(str.length()-1,str.length());
        }
    }
    public List<String> generateParenthesis(int n) {
        // mainN = n;
        dfs(n,n,new StringBuilder());
        return ans;
    }
}
