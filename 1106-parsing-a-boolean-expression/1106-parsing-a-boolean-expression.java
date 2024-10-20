import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') {
                // Ignore commas
                continue;
            } else if (ch == 't' || ch == 'f' || ch == '!' || ch == '&' || ch == '|') {
                // Push boolean values or operators onto the stack
                stack.push(ch);
            } else if (ch == ')') {
                // Process the current expression
                List<Character> subExpr = new ArrayList<>();
                // Collect the sub-expressions until we hit an operator
                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    subExpr.add(stack.pop());
                }
                // Pop the operator
                char operator = stack.pop();
                // Evaluate the sub-expression based on the operator
                char result = evaluate(subExpr, operator);
                // Push the result (t/f) onto the stack
                stack.push(result);
            }
        }
        // At the end, the stack will contain the final result
        return stack.pop() == 't';
    }

    // Helper method to evaluate sub-expressions based on the operator
    private char evaluate(List<Character> subExpr, char operator) {
        if (operator == '!') {
            // NOT operator should only have one operand
            return subExpr.get(0) == 't' ? 'f' : 't';
        } else if (operator == '&') {
            // AND operator: if any operand is 'f', the result is 'f'
            for (char c : subExpr) {
                if (c == 'f') {
                    return 'f';
                }
            }
            return 't';
        } else if (operator == '|') {
            // OR operator: if any operand is 't', the result is 't'
            for (char c : subExpr) {
                if (c == 't') {
                    return 't';
                }
            }
            return 'f';
        }
        return 'f'; // Default (should never reach here)
    }
}
