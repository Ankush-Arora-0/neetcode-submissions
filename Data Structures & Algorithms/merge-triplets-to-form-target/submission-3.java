class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> tps = new ArrayList<>();
        int x = target[0];
        int y = target[1];
        int z = target[2];
        for(int t[]:triplets){
            int x1 = t[0];
            int y1 = t[1];
            int z1 = t[2];
            if(x1>x || y1>y || z1>z)continue;
            tps.add(new int[]{x1,y1,z1});
        }
        for(int i=0;i<tps.size();i++){
            for(int j=0;j<tps.size();j++){
                    int cell[] = tps.get(i);
                    int cell1[] = tps.get(j);
                    int x1 = Math.max(cell[0],cell1[0]);
                    int y1 = Math.max(cell[1],cell1[1]);
                    int z1 = Math.max(cell[2],cell1[2]);
                    if(x1==x && y1==y && z1==z)return true;
                    cell[0] = x1;
                    cell[1] = y1;
                    cell[2] = z1;
            }
        }
        return false;
    }
}
