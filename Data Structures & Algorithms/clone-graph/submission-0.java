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
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        //2, [2, {}]
        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node); //2
        while(!queue.isEmpty()){
            Node original = queue.poll(); //2
            Node clone = map.get(original); //[2, {}]
            for(Node n : original.neighbors){ //2
               if(!map.containsKey(n)){
                  map.put(n, new Node(n.val, new ArrayList<>()));
                  queue.offer(n);
               }
               clone.neighbors.add(map.get(n)); //{2, {}}
            }
        }
        return map.get(node);
    }
}