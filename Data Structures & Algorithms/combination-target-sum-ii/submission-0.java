class Solution {
     List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[] nums,int i,int sum,int target,List<Integer> lst){
        if(sum==target){
            ans.add(new ArrayList<>(lst));
            return;
        }
        if(i==nums.length || sum>target){
            return;
        }
        
       
       
            // lst.add(nums[i]);
            // dfs(nums,i,sum+nums[i],target,lst);
            // lst.removeLast();
            lst.add(nums[i]);
            dfs(nums,i+1,sum+nums[i],target,lst);
            lst.removeLast();
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            dfs(nums,i+1,sum,target,lst);


    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums,0,0,target,new ArrayList<>());
        return ans;
    }
}
