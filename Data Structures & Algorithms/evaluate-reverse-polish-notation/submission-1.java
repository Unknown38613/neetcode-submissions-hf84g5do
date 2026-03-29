class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String tok : tokens) {
            // If token is an operator (only single-char +, -, *, /), apply it.
            if (tok.length() == 1 && isOperator(tok.charAt(0))) {
                int right = stack.pop();
                int left = stack.pop();
                switch (tok.charAt(0)) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        // Java int division truncates toward zero, which matches the spec.
                        stack.push(left / right);
                        break;
                }
            } else {
                // Parse integers directly; handles negatives like "-11" as well.
                stack.push(Integer.parseInt(tok));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
