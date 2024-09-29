import java.util.*;

class AllOne {

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Integer> keyCount; // Maps key to its count
    private Map<Integer, Node> countToNode; // Maps count to corresponding node in doubly linked list
    private Node head, tail;

    public AllOne() {
        keyCount = new HashMap<>();
        countToNode = new HashMap<>();
        head = new Node(Integer.MIN_VALUE); // Dummy head node
        tail = new Node(Integer.MAX_VALUE); // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0);
        keyCount.put(key, count + 1);
        moveKey(key, count, count + 1);
    }

    public void dec(String key) {
        int count = keyCount.get(key);
        if (count == 1) {
            keyCount.remove(key);
            moveKey(key, count, 0);
        } else {
            keyCount.put(key, count - 1);
            moveKey(key, count, count - 1);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void moveKey(String key, int oldCount, int newCount) {
        // Remove the key from its old count node, if it exists
        if (oldCount > 0) {
            Node oldNode = countToNode.get(oldCount);
            oldNode.keys.remove(key);
            if (oldNode.keys.isEmpty()) {
                removeNode(oldNode);
                countToNode.remove(oldCount);
            }
        }

        // Add the key to the new count node
        if (newCount > 0) {
            Node newNode = countToNode.get(newCount);
            if (newNode == null) {
                newNode = new Node(newCount);
                countToNode.put(newCount, newNode);
                insertNodeAfter(getPrevNode(newCount), newNode);
            }
            newNode.keys.add(key);
        }
    }

    private Node getPrevNode(int count) {
        Node node = head;
        while (node.next != tail && node.next.count < count) {
            node = node.next;
        }
        return node;
    }

    private void insertNodeAfter(Node prev, Node newNode) {
        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next.prev = newNode;
        prev.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
