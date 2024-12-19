package life.jinjiang;

public class LinkedList<T> {
    private Node head;
    private int size;

    public LinkedList() {
        size = 0;
        head = new Node(null, null);
    }

    public void insert(Node pre_node, T value) {
        if (pre_node == null) {
            throw new NullPointerException();
        }
        pre_node.next = new Node(value, pre_node.next);
        size += 1;
    }

    public void insert(int index, T value) {
        insert(get_node(index), value);
    }

    public Node get_node(int index) {
        if (index < -1 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == -1) {
            return head;
        }

        Node node = head;

        while (index >= 0 && node != null) {
            node = node.Next();
            index -= 1;
        }

        if (node == null || head.hashCode() == node.hashCode()) {
            throw new IndexOutOfBoundsException();
        }

        return node;
    }

    public T get(int index) {
        return get_node(index).Data();
    }

    public class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node Next() {
            return next;
        }

        public T Data() {
            return data;
        }
    }
}
