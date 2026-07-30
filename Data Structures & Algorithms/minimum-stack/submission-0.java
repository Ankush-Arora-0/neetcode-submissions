class MinStack {
    int min= Integer.MAX_VALUE;
    int top =-1;
    List<Integer> st = new ArrayList<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        st.add(val);
        top++;
        min = Math.min(min,val);
    }
    
    public void pop() {
        st.removeLast();
        top--;
        min= Integer.MAX_VALUE;
        for(int m:st){
            min =Math.min(min,m);
        }
    }
    
    public int top() {
        return st.get(top);
    }
    
    public int getMin() {
        return min;
    }
}
