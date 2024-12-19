package left.jinjiang;

import life.jinjiang.Array;
import org.junit.jupiter.api.Test;

public class ArrayTest {
    @Test
    public void base_test(){
        Array<Integer> array = new Array<>();

        for (int i = 0; i < 10; i ++) {
            array.insert(i, i);
        }

        System.out.println("size: " + array.size());
        System.out.println("capacity: " + array.capacity());

        System.out.print("array: ");
        for (var v : array){
            System.out.print(v + ",");
        }
        System.out.println();

        var v9 = array.get(9);
        System.out.println("v9: " + v9);

        try {
            array.get(10);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }

        try {
            array.get(-1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }

        array.insert(0, 100);

        System.out.println("v0: " + array.get(0) + ", v10: " + array.get(10));
    }
}
