class Solution {
    public boolean isValid(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> st =new Stack<>();
        for(char c:arr){
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else if(c==')'){
                if(st.isEmpty() || st.pop()!='(')return false;
            }
            else if(c=='}'){
                if(st.isEmpty() || st.pop()!='{')return false;
            }
            else if(c==']'){
                if(st.isEmpty() || st.pop()!='[')return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
