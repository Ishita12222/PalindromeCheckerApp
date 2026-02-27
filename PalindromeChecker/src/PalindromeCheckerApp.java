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
            if (ch != stack.pop()) return false;
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
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

class PalindromePerformanceTest {

    public static void main(String[] args) {
        String text = "A man a plan a canal Panama";

        runTest("StackStrategy", new StackStrategy(), text);
        runTest("DequeStrategy", new DequeStrategy(), text);
        runTest("TwoPointerStrategy", new TwoPointerStrategy(), text);
    }

    private static void runTest(String name, PalindromeStrategy strategy, String text) {
        long startTime = System.nanoTime();
        boolean result = strategy.isPalindrome(text);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println(name + " => Result: " + (result ? "Palindrome" : "Not a palindrome")
                + ", Time: " + duration + " ns");
    }
}