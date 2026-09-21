// Last updated: 9/21/2026, 3:42:06 PM
1class Solution {
2    private Node[] visited = new Node[101];
3
4    public Node cloneGraph(Node node) {
5        if (node == null) {
6            return null;
7        }
8
9        if (visited[node.val] != null) {
10            return visited[node.val];
11        }
12
13        Node clone = new Node(node.val);
14        visited[node.val] = clone;
15
16        for (Node neighbor : node.neighbors) {
17            clone.neighbors.add(cloneGraph(neighbor));
18        }
19
20        return clone;
21    }
22}