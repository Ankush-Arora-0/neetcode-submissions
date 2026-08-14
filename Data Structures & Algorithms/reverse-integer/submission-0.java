class Solution {
    public int reverse(int x) {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        if(x==Math.abs(x)){
            
            
            long temp = 0L;
            while(x>0){
                int dgt = x%10;

                temp*=10;
                temp+=dgt;
                x/=10;

            }
            if(temp>maxValue)return 0;
            return (int)temp;
        }
        else{
            long temp = 0L;
            long copy = Math.abs(x);
            
            while(copy>0){
                int dgt = (int)copy%10;

                temp*=10;
                temp+=dgt;
                copy/=10;
            }
            temp=-temp;
            if(temp<minValue)return 0;
            return (int)temp;
        }
    }
}
