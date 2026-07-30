class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char arr[] = s.toCharArray();
        int i=0,j=0;
        int ans=0;
        while(j<arr.length){
            char a = arr[j];
            // System.out.println(map+" - "+a);
            if(map.containsKey(a)){
                i=map.get(a)+1;
                map.clear();
                j=i;
                a= arr[j];
                // System.out.printf("i ->%d, j->%d, a->%c\n",i,j,a);
            }
            map.put(a,j);
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
