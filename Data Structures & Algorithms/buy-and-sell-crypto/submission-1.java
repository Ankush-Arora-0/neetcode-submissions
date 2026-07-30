class Solution {
    public int maxProfit(int[] p) {
        if(p.length<2) return 0;
        int i=0,j=1;
        int ans = 0;
        int val = p[j]-p[i];
        ans = Math.max(ans,val);
        while(j<p.length){
            if(p[j]<p[i]){
                i=j;
                j++;
            }
            else{
                int v = p[j]-p[i];
                ans = Math.max(ans,v);
                j++;
            }

        }
        return ans;
    }
}
