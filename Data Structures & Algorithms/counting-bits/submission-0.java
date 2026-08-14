class Solution {
    public static HashMap<Integer,Integer> map  = new HashMap<>();
    public int getBits(int num){
        int idx = 0;
        int ans =0;
        while(idx<32){
            if((num&1)==1) ans++;
            num =num>>1;
            idx++;
        }
        return ans;
    }
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++){
            if(map.containsKey(i)){
                ans[i]= map.get(i);
            }
            else{
                int x= getBits(i);
                map.put(i,x);
                ans[i] = x;
            }
        }
        return ans;
    }
}
