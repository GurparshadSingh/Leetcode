class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1; 

         Stack<Integer> stack = new Stack<>();

         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // Save current state
                stack.push(result);
                stack.push(sign);

                // Start fresh for the expression inside parentheses
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                // Finish the current expression
                result += sign * number;
                number = 0;

                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + prevSign * result;
            }
         }// Add the last number
        result += sign * number;
            return result;
    }
}