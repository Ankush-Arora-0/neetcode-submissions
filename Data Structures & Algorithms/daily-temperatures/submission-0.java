class Solution {
    public int[] dailyTemperatures(int[] t) {
        int len =t.length;
        int ans[] = new int[len];
        Stack<int[]> st =new Stack<>();
        for(int i=0;i<t.length;i++){
            int tt = t[i];
            if(st.isEmpty()){
                st.push(new int[]{t[i],i});
                
            }
            else{
                
                while(!st.isEmpty() && st.peek()[0]<tt){
                    
                    int cell[] =st.pop();
                    int val =cell[0];
                    int idx =cell[1];
                    ans[idx] = i-idx;
                }
                st.push(new int[]{t[i],i});
               
            }
        }
        return ans;
    }
}
