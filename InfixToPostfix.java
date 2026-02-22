/**
 * Converts infix expressions to postfix (Reverse Polish Notation)
 * Uses the Shunting Yard algorithm by Dijkstra
 */
public class InfixToPostfix {

    /**
     * Determines the precedence of operators
     * Higher number means higher precedence
     * @param operator the operator character
     * @return the precedence level
     */
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    /**
     * Determines if an operator is right associative
     * @param operator the operator character
     * @return true if right associative (like ^), false otherwise
     */
    private static boolean isRightAssociative(char operator) {
        return operator == '^';
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
     * Converts an infix expression to postfix notation
     * @param infix the infix expression (without spaces)
     * @return the postfix expression
     */
    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char character = infix.charAt(i);

            // If the character is a digit or letter (operand), add to output
            if (Character.isDigit(character) || Character.isLetter(character)) {
                postfix.append(character).append(" ");
            }
            // If the character is an opening parenthesis, push to stack
            else if (character == '(') {
                stack.push(character);
            }
            // If the character is a closing parenthesis
            else if (character == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the opening parenthesis
                }
            }
            // If the character is an operator
            else if (isOperator(character)) {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                       isOperator(stack.peek()) &&
                       (getPrecedence(stack.peek()) > getPrecedence(character) ||
                        (getPrecedence(stack.peek()) == getPrecedence(character) && 
                         !isRightAssociative(character)))) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(character);
            }
        }

        // Pop remaining operators from stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }
}
