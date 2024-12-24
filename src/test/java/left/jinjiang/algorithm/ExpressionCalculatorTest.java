package left.jinjiang.algorithm;

import life.jinjiang.algorithm.ExpressionCalculator;
import org.junit.jupiter.api.Test;

public class ExpressionCalculatorTest {
    @Test
    public void base_test(){
        var result = ExpressionCalculator.calculate("(1+2)*3");
        assert result == 9;
    }
}
