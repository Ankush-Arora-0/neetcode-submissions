class Solution {
    public boolean isValid(int []piles,int k,int h){
        int total=0;
        for(int p:piles){
            total+=(int)(Math.ceil((double)p/k));
        }
        if(total<=h) return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        
        for(int p:piles){
            
            max = Math.max(p,max);
        }
        int i=1;
        while(i<max){
            int mid = (max-i)/2 +i;

            if(isValid(piles,mid,h)){
                max = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }
}
