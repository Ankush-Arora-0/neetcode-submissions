class Solution {
    public List<List<Integer>> threeSum(int[] dup) {
        Arrays.sort(dup);
        List<List<Integer>> list = new ArrayList<>();
        // HashSet<Integer> set = new HashSet<>();
        for(int j=0;j<dup.length-2;j++){
            // if(set.contains(dup[j])) continue;
            // set.add(dup[j]);
            // System.out.println(set);
            if (j > 0 && dup[j] == dup[j - 1]) {
                continue;
            }
            int target = -dup[j];
            int s = j+1;
            int e = dup.length-1;
            while(s<e){
                int sum = dup[s]+dup[e];
                if(sum==target){
                    list.add(new ArrayList<>(List.of(dup[j],dup[s],dup[e])));
                    s++;
                    e--;

                    while (s < e && dup[s] == dup[s - 1])
                        s++;

                    while (s < e && dup[e] == dup[e + 1])
                        e--;
                }
                else if(sum<target){
                    s++;
                }
                else {
                    e--;
                }
            }
        }
        return list;
    }
}
