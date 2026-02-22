/**
 * Evaluates postfix (Reverse Polish Notation) expressions
 */
public class EvaluatePostfix {

    /**
     * Performs a basic arithmetic operation
     * @param operand1 the first operand
     * @param operand2 the second operand
     * @param operator the operator
     * @return the result of the operation
     */
    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '%':
                if (operand2 == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                return operand1 % operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * Checks if a character is an operator
     * @param character the character to check
     * @return true if the character is an operator
     */
    private static boolean isOperator(char character) {
        return character == '+' || character == '-' || 
               character == '*' || character == '/' || 
               character == '%' || character == '^';
    }

    /**
     * Evaluates a postfix expression
     * @param postfix the postfix expression with space-separated tokens
     * @return the result of the evaluation
     */
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            char character = token.charAt(0);

            // If the token is a number (operand)
            if (Character.isDigit(character)) {
                stack.push(Double.parseDouble(token));
            }
            // If the token is an operator
            else if (isOperator(character) && token.length() == 1) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, character);
                stack.push(result);
            }
            else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();
    }
}
