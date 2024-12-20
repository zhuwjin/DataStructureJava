package left.jinjiang;

import life.jinjiang.LinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void base_test(){
        LinkedList<Integer> list = new LinkedList<>();

        list.insert_last(1);
        list.insert_last(2);
        list.insert_last(3);

        list.insert_first(0);
        list.insert_last(4);

        for (var v : list){
            System.out.print(v + ",");
        }

        list.remove(4);
        for (var v : list){
            System.out.print(v + ",");
        }
    }
}
