/**
 * Demo class to test the Stack implementation and expression evaluation
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generic Stack Demo ===\n");
        
        // Test 1: Generic Stack with Integers
        System.out.println("Test 1: Stack<Integer>");
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Stack: " + intStack);
        System.out.println("Peek: " + intStack.peek());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Stack after pop: " + intStack);
        System.out.println();

        // Test 2: Generic Stack with Strings
        System.out.println("Test 2: Stack<String>");
        Stack<String> stringStack = new Stack<>();
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");
        System.out.println("Stack: " + stringStack);
        System.out.println("Pop: " + stringStack.pop());
        System.out.println("Stack after pop: " + stringStack);
        System.out.println();

        // Test 3: Infix to Postfix Conversion and Evaluation
        System.out.println("=== Infix to Postfix Conversion and Evaluation ===\n");
        
        String[] infixExpressions = {
            "5+3*2",
            "10-5+3",
            "(5+3)*2",
            "100/5-3",
            "2^3*4",
            "(10+20)/5-2"
        };

        for (String infix : infixExpressions) {
            String postfix = InfixToPostfix.convertToPostfix(infix);
            double result = EvaluatePostfix.evaluatePostfix(postfix);
            System.out.println("Infix:   " + infix);
            System.out.println("Postfix: " + postfix);
            System.out.println("Result:  " + result);
            System.out.println();
        }

        // Test 4: Complex expression
        System.out.println("=== Complex Expression ===\n");
        String complexInfix = "(15+5)*2-10/5";
        String complexPostfix = InfixToPostfix.convertToPostfix(complexInfix);
        double complexResult = EvaluatePostfix.evaluatePostfix(complexPostfix);
        System.out.println("Infix:   " + complexInfix);
        System.out.println("Postfix: " + complexPostfix);
        System.out.println("Result:  " + complexResult);
    }
}
