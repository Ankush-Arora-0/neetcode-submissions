class Solution {
    public void solve(int[] nums,List<List<Integer>> list,List<Integer> tempList,HashSet<Integer> set,int i){
        if(i==nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int idx =0;idx<nums.length;idx++){
            if(!set.contains(idx)){
                set.add(idx);
                tempList.add(nums[idx]);
                solve(nums,list,tempList,set,i+1);
                tempList.removeLast();
                set.remove(idx);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(nums,list,new ArrayList<>(),new HashSet<>(),0);
        return list;
    }
}
