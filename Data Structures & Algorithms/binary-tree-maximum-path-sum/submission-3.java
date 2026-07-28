/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int[] dfs(TreeNode root){
        if(root==null) return new int[]{-1001,-1001};

        int my = root.val;
        int left[] =dfs(root.left);
        int right[] = dfs(root.right);
        int allMax = Math.max(my+left[0]+right[0],Math.max(left[1],Math.max(my,right[1])));
        int leftRightMax = Math.max(left[0],right[0]);
        int meLeftRight = Math.max(my,my+leftRightMax);
        // int allMax = Math.max(my,Math.max(my+leftRightMax,Math.max(my,my+left+right)));
        return new int[]{meLeftRight,allMax};

    }

    public int maxPathSum(TreeNode root) {

        int me = root.val;
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        return Math.max(me,Math.max(right[1],Math.max(left[1],Math.max(me+left[0],Math.max(me+right[0],me+left[0]+right[0])))));
    }
}
