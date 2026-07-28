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
    int preIdx = 0;

    public TreeNode traversal(int[] preorder,HashMap<Integer,Integer> map,int i,int j){
        if(j<i || i>j) return null;
        if(j==0 || i==preorder.length-1){
            // System.out.println(preorder[preIdx]);
            return new TreeNode(preorder[preIdx++]);
        }
        
        TreeNode root = new TreeNode(preorder[preIdx++]);
        int idx = map.get(root.val);
        // System.out.println(root.val);
        root.left = traversal(preorder,map,i,idx-1);
        root.right = traversal(preorder,map,idx+1,j);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return traversal(preorder,map,0,inorder.length-1);
    }
}
