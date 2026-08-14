class Solution {
    public int hammingWeight(int n) {
        int idx = 0;
        int ans=0;
        while(idx<32){
            if((n&1)==1)ans++;
            n=n>>1;
            idx++;
        }
        return ans;
    }
}
