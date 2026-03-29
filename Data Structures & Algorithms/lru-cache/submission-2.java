class LRUCache {

    private static class Node {
        int key, value;
        Node prev, next;
        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private final Node head; // dummy head
    private final Node tail; // dummy tail

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.capacity = capacity;
        this.head = new Node(); // sentinel
        this.tail = new Node(); // sentinel
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addAfterHead(newNode);

        if (map.size() > capacity) {
            Node lru = popTail();     // the real LRU node (before dummy tail)
            map.remove(lru.key);      // important: remove from map
        }
    }

    // Insert node right after dummy head
    private void addAfterHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Detach node from the list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // Optional: clear links to help GC / avoid accidental reuse
        node.prev = null;
        node.next = null;
    }

    // Move existing node to MRU position
    private void moveToHead(Node node) {
        removeNode(node);
        addAfterHead(node);
    }

    // Remove and return the LRU node (node before dummy tail)
    private Node popTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}