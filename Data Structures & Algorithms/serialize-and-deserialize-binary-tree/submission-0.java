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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder ans =new StringBuilder();
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        ans.append(root.val+",");
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                q.offer(curr.left);
                ans.append(curr.left.val+",");
            }else{
                ans.append("null"+",");
            }
            if(curr.right!=null){
                q.offer(curr.right);
                ans.append(curr.right.val+",");
            }else{
                ans.append("null"+",");
            }


        }
        int len =ans.length()-1;
        // System.out.println(ans.toString().substring(0,len));
        return ans.toString().substring(0,len);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String nodes[] = data.split(",");
        // System.out.println(Arrays.toString(nodes));
        int idx =0;
        int val = Integer.parseInt(nodes[idx]);
        idx++;
        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(idx<nodes.length){
            TreeNode temp = q.poll();
            
            if(idx+1<nodes.length){
                TreeNode left = null;
                TreeNode right =null;
                if(!nodes[idx].equals("null")){
                    // System.out.println(temp.val + " - "+idx);
                    left = new TreeNode(Integer.parseInt(nodes[idx]));
                    q.offer(left);
                }
                idx++;
                if(!nodes[idx].equals("null")){
                    // System.out.println(temp.val + " - "+idx);
                    right = new TreeNode(Integer.parseInt(nodes[idx]));
                    q.offer(right);
                }
                idx++;
                // System.out.println(temp.val +" - left - "+left);
                // System.out.println(temp.val +" - "+right);
                temp.left = left;
                temp.right =right;
            }

        }
        return root;
    }
}
