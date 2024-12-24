package life.jinjiang.algorithm;

import life.jinjiang.Stack;


enum Operator {
    LEFT_BRACKET(Integer.MAX_VALUE), RIGHT_BRACKET(Integer.MAX_VALUE), MUL(1), DIV(1), ADD(2), SUB(2);

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

                var op = getOperator(c);

                if (op == Operator.LEFT_BRACKET) {
                    op_stack.push(op);
                }
                else if (op == Operator.RIGHT_BRACKET) {
                    while (op_stack.tryGetTop() != Operator.LEFT_BRACKET) {
                        var top = op_stack.pop();
                        var right = num_stack.pop();
                        var left = num_stack.pop();
                        var result = calculate(left, right, top);
                        num_stack.push(result);
                    }
                    op_stack.pop();
                }
                else {
                    var top = op_stack.tryGetTop();
                    while (top != null && top.getPriority() < op.getPriority()){
                        top = op_stack.pop();
                        var right = num_stack.pop();
                        var left = num_stack.pop();
                        var result = calculate(left, right, top);
                        num_stack.push(result);
                        top = op_stack.tryGetTop();
                    }
                    op_stack.push(op);
                }
            }
        }

        if (!num_buffer.isEmpty()) {
            num_stack.push(Double.parseDouble(num_buffer.toString()));
            num_buffer.setLength(0);
        }

        var top = op_stack.tryGetTop();
        while (top != null) {
            top = op_stack.pop();
            var right = num_stack.pop();
            var left = num_stack.pop();
            var result = calculate(left, right, top);
            num_stack.push(result);
            top = op_stack.tryGetTop();
        }

        return num_stack.pop();
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
        if (c == '(') {
            return Operator.LEFT_BRACKET;
        }
        if (c == ')') {
            return Operator.RIGHT_BRACKET;
        }
        throw new IllegalArgumentException("Invalid operator: " + c);
    }

    private static double calculate(double left, double right, Operator op) {
        switch (op) {
            case MUL -> {
                return left * right;
            }
            case DIV -> {
                return left / right;
            }
            case ADD -> {
                return left + right;
            }
            case SUB -> {
                return left - right;
            }
        }

        throw new IllegalArgumentException("Invalid operator: " + op);
    }
}
