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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pq.offer(p);
        qq.offer(q);
        while(!(pq.isEmpty() || qq.isEmpty())){
            TreeNode pNode = pq.poll();
            TreeNode qNode = qq.poll();
            if(pNode.val!=qNode.val) return false;
            if(pNode.left!=null){
                if(qNode.left==null) return false;
                pq.offer(pNode.left);
                qq.offer(qNode.left);
            }
            else if(qNode.left!=null){
                return false;
            }
            if(pNode.right!=null){
                if(qNode.right==null) return false;
                pq.offer(pNode.right);
                qq.offer(qNode.right);
            }
            else if(qNode.right!=null){
                return false;
            }

        }
        return true;
    }
}
