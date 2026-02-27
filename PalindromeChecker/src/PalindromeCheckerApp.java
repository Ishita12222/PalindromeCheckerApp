import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        String normalized = text.replaceAll("\\s+", "").toLowerCase();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    private PalindromeStrategy strategy;

    public PalindromeCheckerApp(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void check(String text) {
        if (strategy.isPalindrome(text)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    public static void main(String[] args) {
        String text = "Racecar";

        // Using Stack strategy
        PalindromeCheckerApp app1 = new PalindromeCheckerApp(new StackStrategy());
        app1.check(text);

        // Using Deque strategy
        PalindromeCheckerApp app2 = new PalindromeCheckerApp(new DequeStrategy());
        app2.check(text);
    }
}