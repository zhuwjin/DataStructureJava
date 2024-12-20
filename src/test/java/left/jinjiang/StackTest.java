package left.jinjiang;

import static org.junit.jupiter.api.Assertions.*;

import life.jinjiang.Stack;
import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void base_test(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        var n = stack.pop();
        assertEquals(1, n);
    }
}
