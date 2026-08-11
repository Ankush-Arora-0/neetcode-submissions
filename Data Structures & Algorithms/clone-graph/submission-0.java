/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node,HashMap<Integer,Node> map){
        Node temp = new Node(node.val);
        map.put(node.val,temp);
        List<Node> nbrs = new ArrayList<>();
        for(Node nd:node.neighbors){
            if(map.containsKey(nd.val)){
                nbrs.add(map.get(nd.val));
            }
            else{
                nbrs.add(dfs(nd,map));
            }
        }
        temp.neighbors = nbrs;
        return temp;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        return dfs(node,map);
    }
}