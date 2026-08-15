class Solution {
    public int isPossible(int[] gas, int[] cost,int start){
        int myGas =0;
        int idx =0;
        int n = gas.length;
        while(idx<n){
            
            int thisIdx = (start+idx)%n;
            myGas+=gas[thisIdx];
            if(myGas>=cost[thisIdx]){
                myGas-=cost[thisIdx];
            }
            else{
                return thisIdx;
            }
            idx++;
        }

        return -1;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        // int myGas=0;
        for(int i=0;i<gas.length;i++){
           if(gas[i]<cost[i])continue;
        //    System.out.println(i);
            int temp =isPossible(gas,cost,i);
            System.out.println(temp);
            if(temp==-1)return i;
            if(i<temp)i = temp;
        }
        // while(!pq.isEmpty()){
        //     int cell[] = pq.poll();
        //     int start = cell[1];
            
        // }
        return -1;
    }
}
