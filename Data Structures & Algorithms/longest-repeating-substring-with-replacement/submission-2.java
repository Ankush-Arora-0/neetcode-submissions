class Solution {
    public int getMax(int f[],char arr[],int i,int j){
        int max =0;
        while(i<=j){
            int idx= (int)(arr[i]-'A');
            max = Math.max(max,f[idx]);
            i++;
        }
        return max;
    }
    public boolean isValid(int len,int count,int k){
        if(len-count<=k)return true;
        return false;
    }
    public int characterReplacement(String s, int k) {
        if(s.length()==1) return 1;
        char arr[] = s.toCharArray();
        int i=0,j=0;
        int f[] = new int[26];
        int ans =0;
        while(j<arr.length){
            int idx= (int)(arr[j]-'A');
            f[idx]++;
            int len =j-i+1;
            int count = getMax(f,arr,i,j);
            while(!isValid(len,count,k)){
                idx= (int)(arr[i]-'A');
                f[idx]--;
                i++;
                len =j-i+1;
                count = getMax(f,arr,i,j);
            }
            ans = Math.max(len,ans);
            j++;
        }
        return ans;
    }
}
