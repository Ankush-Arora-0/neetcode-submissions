class Solution {
    public List<Integer> partitionLabels(String s) {
        char arr[] = s.toCharArray();
        int [] lastIdx = new int[26];
        for(int i=0;i<arr.length;i++){
            int idx = (int)(arr[i] -'a');
            lastIdx[idx] = i;
        }
        int i=0,j=0;
        System.out.println(Arrays.toString(lastIdx));
        List<Integer> ans=  new ArrayList<>();
        while(i<arr.length){
            int id =i;
            while(id<=j){
                int idx = (int)(arr[id] -'a');
                j  = Math.max(lastIdx[idx],j);
                // System.out.printf("j->%d, i->%d\n",j,id);
                id++;
            }
            // System.out.printf("j->%d, i->%d\n",j,i);
            ans.add(j-i+1);
            i = id;
            j = i;

        }
        return ans;
    }
}
