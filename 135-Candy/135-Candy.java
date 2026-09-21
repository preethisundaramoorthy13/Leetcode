// Last updated: 9/21/2026, 5:28:41 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class LRUCache {
5
6    private class Node {
7        int key;
8        int value;
9        Node prev;
10        Node next;
11
12        Node(int key, int value) {
13            this.key = key;
14            this.value = value;
15        }
16    }
17
18    private final int capacity;
19    private final Map<Integer, Node> map;
20    private final Node head;
21    private final Node tail;
22
23    public LRUCache(int capacity) {
24        this.capacity = capacity;
25        this.map = new HashMap<>();
26        this.head = new Node(-1, -1);
27        this.tail = new Node(-1, -1);
28        head.next = tail;
29        tail.prev = head;
30    }
31
32    public int get(int key) {
33        Node node = map.get(key);
34        if (node == null) {
35            return -1;
36        }
37        moveToHead(node);
38        return node.value;
39    }
40
41    public void put(int key, int value) {
42        Node node = map.get(key);
43        if (node != null) {
44            node.value = value;
45            moveToHead(node);
46        } else {
47            if (map.size() == capacity) {
48                Node lru = tail.prev;
49                removeNode(lru);
50                map.remove(lru.key);
51            }
52            Node newNode = new Node(key, value);
53            map.put(key, newNode);
54            addToHead(newNode);
55        }
56    }
57
58    private void addToHead(Node node) {
59        node.next = head.next;
60        node.prev = head;
61        head.next.prev = node;
62        head.next = node;
63    }
64
65    private void removeNode(Node node) {
66        node.prev.next = node.next;
67        node.next.prev = node.prev;
68    }
69
70    private void moveToHead(Node node) {
71        removeNode(node);
72        addToHead(node);
73    }
74}