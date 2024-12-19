package left.jinjiang;

import life.jinjiang.LinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void base_test(){
        LinkedList<Integer> list = new LinkedList<>();
        var head = list.get_node(-1);
        list.insert(head, 1);
        list.insert(head, 2);
        list.insert(head, 3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
