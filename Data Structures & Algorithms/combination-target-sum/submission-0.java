class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[] nums,int i,int sum,int target,List<Integer> lst){
        if(i==nums.length){
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<>(lst));
        }
        else if(sum>target){
            return;
        }
        else{
            lst.add(nums[i]);
            dfs(nums,i,sum+nums[i],target,lst);
            lst.removeLast();
            // lst.add(nums[i]);
            // dfs(nums,i+1,sum+nums[i],target,lst);
            // lst.removeLast();
            dfs(nums,i+1,sum,target,lst);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,0,0,target,new ArrayList<>());
        return ans;
    }
}
