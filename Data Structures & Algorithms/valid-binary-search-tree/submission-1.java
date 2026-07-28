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
    int prev =-1001;
    boolean ans = true;
    public void inorder(TreeNode root){
        if(root==null) return ;

        inorder(root.left);
        if(root.val<=prev){ ans = false;}
        else{
        prev = root.val;
        inorder(root.right);
        }


    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;
    }
}
