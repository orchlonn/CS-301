import java.util.Stack;

public class EvaluateExpressions {
    
    public String convertToPostFix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // Handle numbers (including multiple digits)
            if (Character.isDigit(c)) {
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    postfix.append(infix.charAt(i));
                    i++;
                }
                i--; // Back up one character since the for loop will increment
                postfix.append(" ");
            }
            // Skip spaces
            else if (c == ' ') {
                continue;
            }
            // Handle operators
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
            // Handle parentheses
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove '('
                }
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() != '(') {
                postfix.append(stack.pop()).append(" ");
            } else {
                stack.pop();
            }
        }
        
        return postfix.toString().trim();
    }
    
    public double evaluatePostFix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");
        
        for (String token : tokens) {
            if (isOperator(token.charAt(0))) {
                double b = stack.pop();
                double a = stack.pop();
                double result = calculate(a, b, token.charAt(0));
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
    
    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
    private double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            case '^': return Math.pow(a, b);
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}