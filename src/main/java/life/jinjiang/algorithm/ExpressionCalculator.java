package life.jinjiang.algorithm;

import life.jinjiang.Stack;


enum Operator {
    MUL(1), DIV(2), ADD(3), SUB(4);

    private final int priority;

    Operator(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}

public class ExpressionCalculator {
    public static double calculate(String expression) {
        var num_stack = new Stack<Double>();
        var op_stack = new Stack<Operator>();
        var num_buffer = new StringBuilder();
        for (var c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num_buffer.append(c);
            }
            else {
                if (!num_buffer.isEmpty()) {
                    num_stack.push(Double.parseDouble(num_buffer.toString()));
                    num_buffer.setLength(0);
                }

                op_stack.push(getOperator(c));
            }
        }

        return 0;
    }

    private static Operator getOperator(char c) {
        if (c == '+') {
            return Operator.ADD;
        }
        if (c == '-') {
            return Operator.SUB;
        }
        if (c == '*') {
            return Operator.MUL;
        }
        if (c == '/') {
            return Operator.DIV;
        }
        throw new IllegalArgumentException("Invalid operator: " + c);
    }
}
