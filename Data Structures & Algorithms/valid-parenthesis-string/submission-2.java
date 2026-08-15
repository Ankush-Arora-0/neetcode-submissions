class Solution {
    class Temp{
        char a;
        int idx;
        Temp(char a,int idx){
            this.a = a;
            this.idx= idx;
        }
    }
    public boolean checkValidString(String s) {
        char arr[] = s.toCharArray();
        Stack<Temp> stl = new Stack<>();
        Stack<Temp> sts = new Stack<>();
        int idx =0;
        for(char c:arr){
            if(c=='('){
                stl.push(new Temp(c,idx));
            }
            else if(c=='*'){
                sts.push(new Temp(c,idx));
            }
            else{
                if(stl.isEmpty()&& sts.isEmpty())return false;
                if(stl.isEmpty())sts.pop();
                else stl.pop();
            }
            idx++;
        }
        while(!sts.isEmpty() && !stl.isEmpty()){
            if(sts.peek().idx>stl.peek().idx){
                sts.pop();
                stl.pop();
            }else return false;
        }
        return stl.isEmpty()==true;
    }
}
