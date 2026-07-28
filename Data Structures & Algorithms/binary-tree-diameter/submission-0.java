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
    public int[] diameter(TreeNode root){
        if(root==null) return new int[]{0,0};
        int left[] = diameter(root.left);
        int right[] = diameter(root.right);

        int diameter = Math.max(left[0],Math.max(right[0],left[1]+right[1]));
        int height = Math.max(left[1],right[1])+1;
        return new int[]{diameter,height};
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root)[0];
    }
}
