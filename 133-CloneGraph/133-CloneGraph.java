// Last updated: 9/21/2026, 5:39:05 PM
class Solution {
    private Node[] visited = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited[node.val] != null) {
            return visited[node.val];
        }

        Node clone = new Node(node.val);
        visited[node.val] = clone;

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}