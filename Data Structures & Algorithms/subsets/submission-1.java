class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[] nums,int i,List<Integer> lst){
        if(i==nums.length){ans.add(new ArrayList<>(lst));return;}
        lst.add(nums[i]);
        dfs(nums,i+1,lst);
        lst.removeLast();
        dfs(nums,i+1,lst);
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return ans;
    }
}
