package life.jinjiang;

import java.util.Iterator;

/**
 * 链表
 * @param <T> 数据类型
 */
public class LinkedList<T> implements Iterable<T> {
    private Node head; //头节点
    private Node tail; //尾节点
    private int size;  //长度

    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }


    /**
     * 内部插入方法，在pre_node节点后插入一个新节点
     * @param pre_node 要插入位置的前一个节点，为null表示在第一个位置插入
     * @param value 要插入的值
     */
    private void insert(Node pre_node, T value) {
        if (pre_node == null) {
            //在第一个位置插入节点
            this.head = new Node(value, this.head);
            if (this.tail == null) {
                this.tail = this.head;
            }
        } else {
            pre_node.next = new Node(value, pre_node.next);
            if (this.tail == pre_node) {
                //如果在最后一个位置插入，需要修改尾节点
                this.tail = pre_node.next;
            }
        }

        size += 1;
    }


    /**
     * 在指定位置插入
     * @param index 要插入的位置
     * @param value 要插入的值
     */
    public void insert(int index, T value) {
        insert(get_node(index), value);
    }


    /**
     * 在最后插入
     * @param value 要插入的值
     */
    public void insert_last(T value) {
        insert(this.tail, value);
    }


    /**
     * 在第一个位置插入
     * @param value 要插入的值
     */
    public void insert_first(T value) {
        insert(null, value);
    }


    /**
     * @param pre_node 要删除的节点的前一个节点
     */
    private void remove(Node pre_node) {
        if (pre_node == null) {
            if (this.head == null) {
                throw new IndexOutOfBoundsException();
            }
            this.head = this.head.next;

            if (this.head == null) {
                this.tail = null;
            }
        } else {
            if (pre_node.next == null) {
                throw new IndexOutOfBoundsException();
            }

            pre_node.next = pre_node.next.next;

            if (pre_node.next == null) {
                this.tail = pre_node;
            }
        }

        size -= 1;
    }

    public void remove(int index) {
        if (index == 0) {
            remove(null);
        } else {
            remove(get_node(index - 1));
        }
    }

    private Node get_node(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;

        while (index > 0 && node != null) {
            node = node.next;
            index -= 1;
        }

        return node;
    }

    public T get(int index) {
        return get_node(index).data;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<T> {
        private Node curNode = head;

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public T next() {
            var data = curNode.data;
            curNode = curNode.next;
            return data;
        }
    }

    public class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
