import java.util.Scanner;
import java.util.Stack;

public class LegendaryDuel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean isLegendary = true;

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), c)) {
                    isLegendary = false;
                    break;
                }
                stack.pop();
            } else if (c == '!') {
                if (!stack.isEmpty() && stack.peek() == '!') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        if (!stack.isEmpty()) {
            isLegendary = false;
        }

        if (isLegendary) {
            System.out.println("Legendary");
        } else {
            System.out.println("Not Legendary");
        }
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}');
    }
}
