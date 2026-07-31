class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st =new Stack<>();
        for(int i=0;i<tokens.length;i++){
            char c = tokens[i].charAt(tokens[i].length()-1);
            // System.out.println(st);
            if(Character.isDigit(c)){
                int val =Integer.parseInt(tokens[i]);
                st.push(val);
            }
            else{
                int f = st.pop();
                int s = st.pop();
                if(c=='+'){
                    st.push(f+s);
                }
                else if(c=='-'){
                    st.push(s-f);
                }
                else if(c=='*'){
                    st.push(f*s);
                }
                else if(c=='/'){
                    st.push(s/f);
                }
            }
        }
        return st.pop();
    }
}
