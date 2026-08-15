class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int arr[] = new int[1001];
        for(int h:hand){
            arr[h]++;
        }
        for(int i=0;i<=1000;i++){
            if(arr[i]>0){
                if(i+groupSize-1>1000)return false;
                for(int t= i;t<i+groupSize;t++){
                    if(arr[t]==0)return false;
                    arr[t]--;
                }
            }
            if(arr[i]>0)i--;
        }
        return true;
    }
}
